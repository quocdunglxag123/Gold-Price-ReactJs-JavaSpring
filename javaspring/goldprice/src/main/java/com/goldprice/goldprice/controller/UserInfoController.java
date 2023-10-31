package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.UserInfoDto;
import com.goldprice.goldprice.service.UserInfoService;

@RestController
@CrossOrigin
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/userinfo")
	@PreAuthorize("hasAuthority('admin')")
	public DataResponse accountLogin(@RequestBody UserInfoDto userInfoDto) {
		if (userInfoDto.getServiceCall().equals("add")) {
			//Case: Add user info By userInfoDto property 
			return new DataResponse("500", "Cannot Add User Info, Please Go To Sign Up Page!");
		} else if (userInfoDto.getServiceCall().equals("get")) {
			//Case: Get user info By userInfoDto property 
			return new DataResponse(userInfoService.getUserInfo(userInfoDto));
		} else if (userInfoDto.getServiceCall().equals("getAll")) {
			//Case: Get All user info
			return new DataResponse(userInfoService.getAllUserInfo());
		} else if (userInfoDto.getServiceCall().equals("update")) {
			//Case: Update user info By userInfoDto property 
			return new DataResponse(userInfoService.updateUserInfo(userInfoDto));
		} else if (userInfoDto.getServiceCall().equals("delete")) {
			//Case: Delete user info By userInfoDto property 
			return new DataResponse("500", "Delete User Info Is Delete Account");
		}
		return new DataResponse("500", "Method Not Found");

	}

}
