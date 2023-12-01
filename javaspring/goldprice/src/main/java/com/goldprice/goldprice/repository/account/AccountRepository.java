package com.goldprice.goldprice.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.account.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	AccountEntity findOneById(Long id);

	AccountEntity findByUsername(String username);
	
}