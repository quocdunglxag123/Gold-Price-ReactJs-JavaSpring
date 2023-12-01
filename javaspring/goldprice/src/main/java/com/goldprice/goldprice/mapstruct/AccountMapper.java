package com.goldprice.goldprice.mapstruct;

import java.util.List;

import com.goldprice.goldprice.dto.account.AccountDto;
import com.goldprice.goldprice.dto.account.RegisterDto;
import com.goldprice.goldprice.entity.account.AccountEntity;

public interface AccountMapper {
	// ----------------------------Entity To DTO---------------------------

	AccountDto accountEntityToAccountDto(AccountEntity accountEntity);
	
	List<AccountDto> listAccountEntityToListAccountDto(List<AccountEntity> accountEntities);
	

	// ---------------------------DTO To Entity----------------------

	AccountEntity accountDtoToAccountEntity(AccountDto accountDto);	
	
	List<AccountEntity> listAccountDtoToListAccountEntity(List<AccountDto> accountDtos);
	
	AccountEntity registerDtoToAccountEntity(RegisterDto registerDto);	

}