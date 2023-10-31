package com.goldprice.goldprice.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.goldprice.goldprice.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtServiceImpl implements JwtService {

	public static final String secretKey = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	@Value("${accessTokenExpireTime}")
	private String accessTokenExpireTime;

	/**
	 * Extract Username From Access Token
	 * 
	 * @param token String AccessToken to extract
	 * 
	 * @return username Username from AccessToken
	 */
	@Override
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * Extract Expiration From Access Token
	 * 
	 * @param token String AccessToken to extract
	 * 
	 * @return expiryDate expiry date from AccessToken
	 */
	@Override
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	@Override
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	}

	/**
	 * Check Access Token Is Expiry
	 * 
	 * @param token String AccessToken to check Expiry Date
	 * 
	 * @return true/false Expire/Not expired
	 */
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	/**
	 * validate Token By Username
	 * 
	 * @param token String AccessToken to extract
	 * 
	 * @return true/false Checks if the username from the token is the same as the
	 *         username from the UserDetails
	 */
	@Override
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/**
	 * Generate Access Token
	 * 
	 * @param username Username to create AccessToken
	 * 
	 * @return accessToken String Access Token
	 */
	@Override
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(accessTokenExpireTime)))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}