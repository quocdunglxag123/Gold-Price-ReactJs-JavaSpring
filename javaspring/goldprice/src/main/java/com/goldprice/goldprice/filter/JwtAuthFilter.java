package com.goldprice.goldprice.filter;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.security.AccountEntityUserDetailsService;
import com.goldprice.goldprice.service.account.JwtService;
import com.google.gson.Gson;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private Gson gson = new Gson();

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AccountEntityUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			String authHeader = request.getHeader("Authorization");
			String token = null;
			String username = null;
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				token = authHeader.substring(7);
				username = jwtService.extractUsername(token);
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if (jwtService.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException e) {
			final String expiredMsg = e.getMessage();
	        logger.warn(expiredMsg);
	        
	        final String msg = (expiredMsg != null) ? expiredMsg : "Unauthorized";
	      	PrintWriter out = response.getWriter();
	        DataResponse dataResponse = new DataResponse("403", msg);
	        String dataReponseString = this.gson.toJson(dataResponse);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(dataReponseString);
	        out.flush();   
		}

	}
}