package com.goldprice.goldprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.UserInfoEntity;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
	UserInfoEntity findOneById(Long id);

	@Query(value = "SELECT * FROM user_info WHERE user_info.account_id = :accountId", nativeQuery = true)
	UserInfoEntity findByAccountId(@Param("accountId") Long accountId);
}