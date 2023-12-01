package com.goldprice.goldprice.service.impl.account;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.entity.account.AccountEntity;
import com.goldprice.goldprice.entity.account.RefreshTokenEntity;
import com.goldprice.goldprice.exception.AccountException;
import com.goldprice.goldprice.exception.MailException;
import com.goldprice.goldprice.repository.account.AccountRepository;
import com.goldprice.goldprice.repository.account.RefreshTokenRepository;
import com.goldprice.goldprice.service.account.RefreshTokenService;
import com.goldprice.goldprice.shared.MachineInfo;
import com.goldprice.goldprice.shared.MailInfo;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Value("${refreshTokenExpireTime}")
	private String refreshTokenExpireTime;

	/**
	 * Check And Generate Refresh Token
	 * 
	 * @param username String username to create token
	 * 
	 * @return refreshTokenEntity refresh token info
	 */
	@Override
	public RefreshTokenEntity createRefreshToken(String username) {
		// Get Ip Machine
		MachineInfo machineInfo = new MachineInfo();
		String ipAddress = machineInfo.getIpAddress();

		// Check refresh Token is in database
		RefreshTokenEntity refreshTokenEntity = refreshTokenRepository.findByIpAddress(ipAddress);
		AccountEntity accountEntity = accountRepository.findByUsername(username);
		if (accountEntity != null) {
			if (refreshTokenEntity != null && username.equals(accountEntity.getUsername())) {
				// Update token
				refreshTokenEntity.setExpiryDate(Instant.now().plusMillis(Integer.parseInt(refreshTokenExpireTime)));
				refreshTokenEntity.setToken(UUID.randomUUID().toString());
				refreshTokenRepository.save(refreshTokenEntity);

			} else if (username.equals(accountEntity.getUsername())) {
				// Create Token
				refreshTokenEntity = new RefreshTokenEntity();
				refreshTokenEntity.setIpAddress(ipAddress);
				refreshTokenEntity.setExpiryDate(Instant.now().plusMillis(Integer.parseInt(refreshTokenExpireTime)));
				refreshTokenEntity.setAccountEntity(accountEntity);
				refreshTokenEntity.setToken(UUID.randomUUID().toString());
			} else {
				throw new AccountException("Invalid Username To Create Token!");
			}
			refreshTokenRepository.save(refreshTokenEntity);
			
			MailInfo mailInfo = new MailInfo();
			try {
				mailInfo.sendMail(accountEntity.getUsername(), "Warning about a security risk",
						"We detected a new login request to your account on a " + machineInfo.getNameMachine() + " "+ machineInfo.getIpAddress()
								+ " device. If this was your request, you don't need to do anything further. If this was not your request, we recommend you change your password immediately!",
						"AlertEmail.jpg");
			} catch (Exception e) {
				throw new MailException(e.getMessage());
			}

			return refreshTokenEntity;
		}
		throw new AccountException("Invalid Username To Create Token!");
	}

	/**
	 * Find Token In Database
	 * 
	 * @param token String info refresh token
	 * 
	 * @return refreshTokenEntity refresh Token Entity info
	 */
	@Override
	public RefreshTokenEntity findByRefreshToken(String token) {
		MachineInfo machineInfo = new MachineInfo();
		RefreshTokenEntity refreshTokenEntity = refreshTokenRepository.findByToken(token);
		if (refreshTokenEntity != null) {
			if (refreshTokenEntity.getIpAddress().equals(machineInfo.getIpAddress())) {
				return refreshTokenEntity;
			}
		}
		return null;
	}

	/**
	 * Verify Expiration Refresh Token
	 * 
	 * @param refreshTokenEntity refresh Token Entity Info
	 * 
	 * @return refreshTokenEntity refresh Token Entity Info
	 */
	@Override
	public RefreshTokenEntity verifyRefreshTokenExpiration(RefreshTokenEntity token) {
		if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
			// Token expired
			deleteRefreshToken(token);
			throw new RuntimeException(
					token.getToken() + " Refresh token was expired. Please make a new signin request");
		}
		return token;
	}

	/**
	 * Delete Refresh Token
	 * 
	 * @param refreshTokenEntity refreshTokenEntity contains information about an
	 *                           token to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteRefreshToken(RefreshTokenEntity refreshTokenEntity) {
		refreshTokenRepository.deleteById(refreshTokenEntity.getId());
		return true;
	}

}
