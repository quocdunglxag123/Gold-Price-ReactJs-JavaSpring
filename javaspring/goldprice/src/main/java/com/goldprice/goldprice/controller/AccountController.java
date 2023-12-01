package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.account.AccountDto;
import com.goldprice.goldprice.dto.account.LoginDto;
import com.goldprice.goldprice.dto.account.RegisterDto;
import com.goldprice.goldprice.dto.account.RoleDto;
import com.goldprice.goldprice.dto.account.TokenDto;
import com.goldprice.goldprice.dto.account.UserInfoDto;
import com.goldprice.goldprice.entity.account.RefreshTokenEntity;
import com.goldprice.goldprice.service.account.AccountService;
import com.goldprice.goldprice.service.account.JwtService;
import com.goldprice.goldprice.service.account.RefreshTokenService;
import com.goldprice.goldprice.service.account.RoleService;
import com.goldprice.goldprice.service.account.UserInfoService;

@RestController
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public DataResponse login(@RequestBody AccountDto accountDto) {
		if (accountDto.getServiceCall().equals("login")) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(accountDto.getUsername(), accountDto.getPassword()));
			if (authentication.isAuthenticated()) {
				
				//Token
				TokenDto tokenDto = new TokenDto();
				RefreshTokenEntity refreshToken = refreshTokenService.createRefreshToken(accountDto.getUsername());
				tokenDto.setAccessToken(jwtService.generateToken(accountDto.getUsername()));
				tokenDto.setRefreshToken(refreshToken.getToken());
				
				//Account
				AccountDto accountDtoDb =  accountService.getAccount(accountDto);
				
				//UserInfo
				UserInfoDto userInfoDto = new UserInfoDto();
				userInfoDto.setAccountId(accountDtoDb.getId());
				UserInfoDto userInfoDtoDb = userInfoService.getUserInfo(userInfoDto);
				
				//Response Data
				LoginDto loginDto = new LoginDto();
				loginDto.setAccountDto(accountDtoDb);
				loginDto.setTokenDto(tokenDto);
				loginDto.setUserInfoDto(userInfoDtoDb);
			
				return new DataResponse(loginDto);
			} else {
				throw new UsernameNotFoundException("invalid user request !");
			}
		}
		return new DataResponse("500", "Method Not Found");

	}

	@PostMapping("/refreshToken")
	public DataResponse refreshToken(@RequestBody TokenDto tokenDto) {
		RefreshTokenEntity refreshTokenEntity =  refreshTokenService.findByRefreshToken(tokenDto.getRefreshToken());
		refreshTokenEntity = refreshTokenService.verifyRefreshTokenExpiration(refreshTokenEntity);
		if(refreshTokenEntity != null) {
			TokenDto tokenDtoResponse = new TokenDto();
			tokenDtoResponse.setAccessToken(jwtService.generateToken(refreshTokenEntity.getAccountEntity().getUsername()));
			tokenDtoResponse.setRefreshToken(tokenDto.getRefreshToken());
			LoginDto loginDto = new LoginDto();
			loginDto.setTokenDto(tokenDtoResponse);
			return new DataResponse(loginDto);
		}
		return new DataResponse("403", "Token Invalid!");
	}

	@PostMapping("/register")
	public DataResponse register(@RequestBody RegisterDto registerDto) {
		if (registerDto.getServiceCall().equals("register")) {
			// Case: register Account
			return new DataResponse(accountService.addAccount(registerDto));
		}
		return new DataResponse("500", "Method Not Found");

	}

	@PostMapping("/account")
	public DataResponse account(@RequestBody AccountDto accountDto) {
		if (accountDto.getServiceCall().equals("getAll")) {
			// Case: Get All Account
			return new DataResponse(accountService.getAllAccount());
		} else if (accountDto.getServiceCall().equals("get")) {
			// Case: Get One Account By accountDto property
			return new DataResponse(accountService.getAccount(accountDto));
		} else if (accountDto.getServiceCall().equals("add")) {
			// Case: Add Account By accountDto property
			return new DataResponse("500", "Add Account Is Register, Please Go To Sign Up page!");
		} else if (accountDto.getServiceCall().equals("update")) {
			// Case: Update Account By accountDto property
			return new DataResponse(accountService.updateAccount(accountDto));
		} else if (accountDto.getServiceCall().equals("delete")) {
			// Case: Delete Account By accountDto property
			return new DataResponse(accountService.deleteAccount(accountDto));
		}
		return new DataResponse("500", "Method Not Found");

	}
	

	@PostMapping("/role")
	public DataResponse accountLogin(@RequestBody RoleDto roleDto) {
		if (roleDto.getServiceCall().equals("add")) {
			//Case: Add Role By roleDto property 
			return new DataResponse(roleService.addRole(roleDto));
		} else if (roleDto.getServiceCall().equals("get")) {
			//Case: Get One  Role By roleDto property 
			return new DataResponse(roleService.getRole(roleDto));
		} else if (roleDto.getServiceCall().equals("getAll")) {
			//Case: Get All  Role
			return new DataResponse(roleService.getAllRole());
		} else if (roleDto.getServiceCall().equals("update")) {
			//Case: Update  Role By roleDto property 
			return new DataResponse(roleService.updateRole(roleDto));
		} else if (roleDto.getServiceCall().equals("delete")) {
			//Case: Delete  Role By roleDto property 
			return new DataResponse(roleService.deleteRole(roleDto));
		}
		return new DataResponse("500", "Method Not Found");

	}
	

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
