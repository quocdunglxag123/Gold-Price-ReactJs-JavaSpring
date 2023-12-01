package com.goldprice.goldprice.service.account;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.entity.account.RefreshTokenEntity;

@Service
public interface RefreshTokenService {
	/**
	 * Check And Generate Refresh Token
	 * 
	 * @param username String username to create token
	 * 
	 * @return refreshTokenEntity refresh token info
	 */
	RefreshTokenEntity createRefreshToken(String username);

	/**
	 * Find Refresh Token In Database
	 * 
	 * @param token String info refresh token
	 * 
	 * @return refreshTokenEntity refresh Token Entity info
	 */
	RefreshTokenEntity findByRefreshToken(String token);

	/**
	 * Verify Expiration Refresh Token
	 * 
	 * @param refreshTokenEntity refresh Token Entity Info
	 * 
	 * @return refreshTokenEntity refresh Token Entity Info
	 */
	RefreshTokenEntity verifyRefreshTokenExpiration(RefreshTokenEntity token);
	
	/**
	 * Delete Refresh Token
	 * 
	 * @param refreshTokenEntity refreshTokenEntity contains information about an token to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteRefreshToken(RefreshTokenEntity refreshTokenEntity);
}
