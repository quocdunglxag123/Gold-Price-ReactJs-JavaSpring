package com.goldprice.goldprice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.UserInfoDto;
import com.goldprice.goldprice.entity.UserInfoEntity;
import com.goldprice.goldprice.exception.AccountException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.UserInfoRepository;
import com.goldprice.goldprice.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private GenerateMapper userInfoMapper;

	/**
	 * Get User Info
	 * 
	 * @param userInfoDto userInfoDto contains information about a user to get
	 * 
	 * @return userInfoDto Object contains information about a user in database
	 */
	@Override
	public UserInfoDto getUserInfo(UserInfoDto userInfoDto) {
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		if(userInfoDto.getAccountId() != null && userInfoDto.getAccountId() != 0) {
			userInfoEntity = userInfoRepository.findByAccountId(userInfoDto.getAccountId());
		}else {
			userInfoEntity = userInfoRepository.findOneById(userInfoDto.getId());
		}
		
		if (userInfoEntity == null) {
			throw new AccountException("User Info Not Found!");
		}
		return userInfoMapper.userInfoEntityToUserInfoDto(userInfoEntity);
	}

	/**
	 * Get All User Info
	 * 
	 * @return userInfoDto Object contains information about all user in database
	 */
	@Override
	public Object getAllUserInfo() {
		List<UserInfoEntity> userInfoEntities = userInfoRepository.findAll();
		if (userInfoEntities.size() < 1) {
			throw new AccountException("No User Info In Database!");
		}
		return userInfoMapper.listUserInfoEntityToListUserInfoDto(userInfoEntities);
	}

	/**
	 * Update User Info
	 * 
	 * @param userInfoDto userInfoDto contains information about a user to update
	 * 
	 * @return true/Exception Success/Failed to update
	 */
	@Override
	public Object updateUserInfo(UserInfoDto userInfoDto) {
		UserInfoEntity userInfoEntityUpdate = userInfoRepository.findOneById(userInfoDto.getId());
		if (userInfoEntityUpdate != null) {
			userInfoEntityUpdate.setUserInfoEntity(userInfoMapper.userInfoDtoToUserInfoEntity(userInfoDto));
			userInfoRepository.save(userInfoEntityUpdate);
			return true;
		} else {
			throw new AccountException("User Info Not Found!");
		}
	}

}
