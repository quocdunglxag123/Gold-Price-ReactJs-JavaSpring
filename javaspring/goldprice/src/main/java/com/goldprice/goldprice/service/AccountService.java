package com.goldprice.goldprice.service;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.AccountDto;
import com.goldprice.goldprice.dto.RegisterDto;

@Service
public interface AccountService {
	/**
	 * Get Account 
	 * 
	 * @param accountDto	AccountDto info
	 * @return accountDto	Object contains information about an account in database
	 */
	AccountDto getAccount(AccountDto accountDto);

	/**
	 * Get All Account 
	 *  
	 * @return accountDto	Object contains information about all account in database
	 */
	Object getAllAccount();

	/**
	 * Add Account (Register)
	 * @param registerDto	RegisterDto contains information about an account and user info to register
	 * 
	 * @return boolean	true
	 */
	Object addAccount(RegisterDto registerDto);

	/**
	 * Delete Account
	 * @param accountDto	AccountDto contains information about an account to delete
	 * 
	 * @return true/false	Success or failed	
	 */
	Object deleteAccount(AccountDto accountDto);

	/**
	 * Update Account
	 * @param accountDto	AccountDto contains information about an account to update
	 * 
	 * @return true/false	Success or failed	
	 */
	Object updateAccount(AccountDto accountDto);
}
