package com.goldprice.goldprice.mapstruct.mapStructImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldprice.goldprice.dto.AccountDto;
import com.goldprice.goldprice.dto.RegisterDto;
import com.goldprice.goldprice.entity.AccountEntity;
import com.goldprice.goldprice.mapstruct.AccountMapper;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
@Component
public class AccountMapperImpl implements AccountMapper{

	@Autowired
	GenerateMapper generateMapper;
	
	@Override
	public AccountDto accountEntityToAccountDto(AccountEntity accountEntity) {
		AccountDto accountDto = new AccountDto();
		accountDto.setId(accountEntity.getId());
		accountDto.setUsername(accountEntity.getUsername());
		accountDto.setPassword(accountEntity.getPassword());
		accountDto.setUpdateDate(accountEntity.getUpdateDate());
		accountDto.setCreateDate(accountEntity.getCreateDate());
		accountDto.setRoleDtos(generateMapper.listRoleEntityToListRoleDto(accountEntity.getRoleEntities()));
		return accountDto;
	}

	@Override
	public AccountEntity accountDtoToAccountEntity(AccountDto accountDto) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(accountDto.getId());
		accountEntity.setUsername(accountDto.getUsername());
		accountEntity.setPassword(accountDto.getPassword());
		return accountEntity;
	}

	@Override
	public AccountEntity registerDtoToAccountEntity(RegisterDto registerDto) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setUsername(registerDto.getUsername());
		accountEntity.setPassword(registerDto.getPassword());
		return accountEntity;
	}
	
	@Override
    public List<AccountDto> listAccountEntityToListAccountDto(List<AccountEntity> accountEntities) {
        if ( accountEntities == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accountEntities.size() );
        for ( AccountEntity accountEntity : accountEntities ) {
            list.add( accountEntityToAccountDto( accountEntity ) );
        }

        return list;
    }

	@Override
	public List<AccountEntity> listAccountDtoToListAccountEntity(List<AccountDto> accountDtos) {
		if ( accountDtos == null ) {
            return null;
        }

        List<AccountEntity> list = new ArrayList<AccountEntity>( accountDtos.size() );
        for ( AccountDto accountDto : accountDtos ) {
            list.add( accountDtoToAccountEntity( accountDto ) );
        }

        return list;
	}
	
}
