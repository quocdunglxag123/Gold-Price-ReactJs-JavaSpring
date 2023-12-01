package com.goldprice.goldprice.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.account.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneById(Long id);

	RoleEntity findByName(String name);
}