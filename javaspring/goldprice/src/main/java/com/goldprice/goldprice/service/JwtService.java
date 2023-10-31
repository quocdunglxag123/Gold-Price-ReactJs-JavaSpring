package com.goldprice.goldprice.service;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;

@Service
public interface JwtService {

	/**
	 * Extract Username From Access Token
	 * 
	 * @param token String AccessToken to extract
	 * 
	 * @return username Username from AccessToken
	 */
	String extractUsername(String token);

	/**
	 * Extract Expiration From Access Token
	 * 
	 * @param token String AccessToken to extract
	 * 
	 * @return expiryDate expiry date from AccessToken
	 */
	Date extractExpiration(String token);

	<T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	/**
	 * validate Token By Username
	 * 
	 * @param token String AccessToken to extract
	 * 
	 * @return true/false Checks if the username from the token is the same as the username from the UserDetails
	 */
	Boolean validateToken(String token, UserDetails userDetails);

	/**
	 * Generate Access Token
	 * 
	 * @param username Username to create AccessToken
	 * 
	 * @return accessToken String Access Token
	 */
	String generateToken(String username);

}