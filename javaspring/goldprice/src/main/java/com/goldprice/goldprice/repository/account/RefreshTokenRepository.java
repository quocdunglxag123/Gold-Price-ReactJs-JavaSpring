package com.goldprice.goldprice.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldprice.goldprice.entity.account.RefreshTokenEntity;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
	RefreshTokenEntity findByToken(String token);
	RefreshTokenEntity findByIpAddress(String ipAddress);
}
