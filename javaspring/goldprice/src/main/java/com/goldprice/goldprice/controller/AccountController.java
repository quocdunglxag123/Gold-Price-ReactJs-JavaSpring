package com.goldprice.goldprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldprice.goldprice.dto.AccountDto;
import com.goldprice.goldprice.dto.DataResponse;
import com.goldprice.goldprice.dto.LoginDto;
import com.goldprice.goldprice.dto.RegisterDto;
import com.goldprice.goldprice.dto.TokenDto;
import com.goldprice.goldprice.dto.UserInfoDto;
import com.goldprice.goldprice.entity.RefreshTokenEntity;
import com.goldprice.goldprice.service.AccountService;
import com.goldprice.goldprice.service.JwtService;
import com.goldprice.goldprice.service.RefreshTokenService;
import com.goldprice.goldprice.service.UserInfoService;

@RestController
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public DataResponse accountLogin(@RequestBody AccountDto accountDto) {
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
	public DataResponse accountRegister(@RequestBody RegisterDto registerDto) {
		if (registerDto.getServiceCall().equals("register")) {
			// Case: register Account
			return new DataResponse(accountService.addAccount(registerDto));
		}
		return new DataResponse("500", "Method Not Found");

	}

	@PostMapping("/account")
	public DataResponse accountController(@RequestBody AccountDto accountDto) {
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

}
