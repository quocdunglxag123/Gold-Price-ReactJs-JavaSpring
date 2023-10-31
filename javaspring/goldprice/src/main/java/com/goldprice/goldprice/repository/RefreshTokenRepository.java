package com.goldprice.goldprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldprice.goldprice.entity.RefreshTokenEntity;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
	RefreshTokenEntity findByToken(String token);
	RefreshTokenEntity findByIpAddress(String ipAddress);
}
