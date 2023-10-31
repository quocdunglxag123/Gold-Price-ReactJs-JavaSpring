package com.goldprice.goldprice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.goldprice.goldprice.entity.AccountEntity;
import com.goldprice.goldprice.exception.AccountException;
import com.goldprice.goldprice.repository.AccountRepository;

@Component
public class AccountEntityUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	/**
	 * Get Account By Username
	 * 
	 * @param username String username to get
	 * @return accountEntityUserDetails UserDetails
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountEntity accountEntity = accountRepository.findByUsername(username);
		if (accountEntity != null) {
			AccountEntityUserDetails accountEntityUserDetails = new AccountEntityUserDetails(accountEntity);
			return accountEntityUserDetails;
		}
		throw new AccountException("Account Not Found!");
	}
}
