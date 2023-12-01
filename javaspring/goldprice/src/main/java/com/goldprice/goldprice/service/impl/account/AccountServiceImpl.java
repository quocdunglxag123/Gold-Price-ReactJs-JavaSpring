package com.goldprice.goldprice.service.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.goldprice.goldprice.dto.account.AccountDto;
import com.goldprice.goldprice.dto.account.RegisterDto;
import com.goldprice.goldprice.dto.account.RoleDto;
import com.goldprice.goldprice.entity.account.AccountEntity;
import com.goldprice.goldprice.entity.account.RoleEntity;
import com.goldprice.goldprice.entity.account.UserInfoEntity;
import com.goldprice.goldprice.entity.order.OrderEntity;
import com.goldprice.goldprice.entity.order.PaymentOrderEntity;
import com.goldprice.goldprice.entity.order.StatusOrderEntity;
import com.goldprice.goldprice.exception.AccountException;
import com.goldprice.goldprice.exception.OrderException;
import com.goldprice.goldprice.mapstruct.AccountMapper;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.mapstruct.UserInfoMapper;
import com.goldprice.goldprice.repository.account.AccountRepository;
import com.goldprice.goldprice.repository.account.RoleRepository;
import com.goldprice.goldprice.repository.account.UserInfoRepository;
import com.goldprice.goldprice.repository.order.OrderRepository;
import com.goldprice.goldprice.repository.order.PaymentOrderRepository;
import com.goldprice.goldprice.repository.order.StatusOrderRepository;
import com.goldprice.goldprice.service.account.AccountService;
import com.goldprice.goldprice.service.account.RoleService;

@Service
public class AccountServiceImpl implements AccountService {

	//Repository Order
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private StatusOrderRepository statusOrderRepository;
	@Autowired
	private PaymentOrderRepository paymentOrderRepository;
	
	//Repository Acccount
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleRepository roleRepository;
	

	private PasswordEncoder BCrypt = new BCryptPasswordEncoder();
	@Autowired
	private GenerateMapper generateMapper;

	/**
	 * Get Account
	 * 
	 * @param accountDto AccountDto info
	 * @return accountDto Object contains information about an account in database
	 */
	@Override
	public AccountDto getAccount(AccountDto accountDto) {
		AccountEntity accountEntity = new AccountEntity();
		if (accountDto.getUsername() != null) {
			accountEntity = accountRepository.findByUsername(accountDto.getUsername());
		} else {
			accountEntity = accountRepository.findOneById(accountDto.getId());
		}
		if (accountEntity == null) {
			throw new AccountException("Account Not Found!");
		}
		return accountMapper.accountEntityToAccountDto(accountEntity);
	}

	/**
	 * Get All Account
	 * 
	 * @return accountDto Object contains information about all account in database
	 */
	@Override
	public Object getAllAccount() {
		List<AccountEntity> accountEntities = accountRepository.findAll();
		if (accountEntities.size() < 1) {
			throw new AccountException("No Account In Database!");
		}
		return accountMapper.listAccountEntityToListAccountDto(accountEntities);
	}

	/**
	 * Add Account (Register)
	 * 
	 * @param registerDto RegisterDto contains information about an account and user
	 *                    info to register
	 * 
	 * @return boolean true
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object addAccount(RegisterDto registerDto) {

		// Convert Dto to Entity
		AccountEntity account = accountMapper.registerDtoToAccountEntity(registerDto);
		UserInfoEntity userInfo = userInfoMapper.registerDtoToUserInfoEntity(registerDto);

		// Endcode Password with BCrypt
		String encodedPassword = BCrypt.encode(account.getPassword());// BCrypt

		// Get Role Customer
		RoleEntity roleEntity = roleRepository.findByName("customer");

		if (roleEntity == null) {
			throw new AccountException("Please add role customer!");
		}

		// Save data account and user info to database
		account.setPassword(encodedPassword);
		account.addRoleEntity(roleEntity);
		accountRepository.save(account);
		userInfo.setAccountEntity(account);
		userInfoRepository.save(userInfo);
		
		OrderEntity orderEntity =  new OrderEntity();
		orderEntity.setAccountEntity(account);
		StatusOrderEntity statusOrderEntity = statusOrderRepository.findByName("Shopping Cart");
		if(statusOrderEntity == null) {
			throw new OrderException("Please Add Status Order Name: Shopping Cart!");
		}
		PaymentOrderEntity paymentOrderEntity = paymentOrderRepository.findByName("Pending");
		if(paymentOrderEntity == null) {
			throw new OrderException("Please Add Payment Order Name: Pending!");
		}
		orderEntity.setPaymentOrderEntity(paymentOrderEntity);
		orderEntity.setStatusOrderEntity(statusOrderEntity);
		
		orderRepository.save(orderEntity);

		return true;
	}

	/**
	 * Delete Account
	 * 
	 * @param accountDto AccountDto contains information about an account to delete
	 * 
	 * @return true/false Success or failed
	 */
	@Override
	public Object deleteAccount(AccountDto accountDto) {
		accountRepository.deleteById(accountDto.getId());
		return true;

	}

	/**
	 * Update Account
	 * 
	 * @param accountDto AccountDto contains information about an account to update
	 * 
	 * @return true/false Success or failed
	 */
	@Override
	public Object updateAccount(AccountDto accountDto) {
		// Check Account Is In Database
		AccountEntity accountEntityUpdate = accountRepository.findOneById(accountDto.getId());
		if (accountEntityUpdate != null) {
			// Case: Account Is In Database
			if (accountDto.getPassword() != null && accountDto.getPassword() != "") {
				// Case: Update Password
				String encodedPassword = BCrypt.encode(accountDto.getPassword());// BCrypt
				accountEntityUpdate.setPassword(encodedPassword);
			}
			List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
			if (accountDto.getRoleDtos() != null) {
				// Case: Update Role
				for (RoleDto roleDto : accountDto.getRoleDtos()) {
					RoleEntity roleEntity = (RoleEntity) generateMapper
							.roleDtoToRoleEntity((RoleDto) roleService.getRole(roleDto));
					roleEntities.add(roleEntity);
				}
			}
			accountEntityUpdate.setRoleEntities(roleEntities);

			// Update Account In Database
			accountRepository.save(accountEntityUpdate);
			return true;
		} else {
			// Case: Account Is Not Found In Database
			throw new AccountException("Account Not Found!");
		}
	}

}
