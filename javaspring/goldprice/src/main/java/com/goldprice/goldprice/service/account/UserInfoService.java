package com.goldprice.goldprice.service.account;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.account.UserInfoDto;

@Service
public interface UserInfoService {
	/**
	 * Get User Info
	 * 
	 * @param userInfoDto userInfoDto contains information about a user to get
	 * 
	 * @return userInfoDto Object contains information about a user in database
	 */
	UserInfoDto getUserInfo(UserInfoDto userInfoDto);

	/**
	 * Get All User Info
	 * 
	 * @return userInfoDto Object contains information about all user in database
	 */
	Object getAllUserInfo();

	/**
	 * Update User Info
	 * 
	 * @param userInfoDto userInfoDto contains information about a user to update
	 * 
	 * @return true/Exception Success/Failed to update
	 */
	Object updateUserInfo(UserInfoDto userInfoDto);
}
