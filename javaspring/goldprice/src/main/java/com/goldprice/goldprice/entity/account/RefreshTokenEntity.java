package com.goldprice.goldprice.entity.account;

import java.time.Instant;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class RefreshTokenEntity extends BaseEntity {

	private String token;

	private Instant expiryDate;

	private String ipAddress;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountEntity accountEntity;

	public RefreshTokenEntity() {
		super();
	}

	public RefreshTokenEntity(String token, Instant expiryDate, String ipAddress, AccountEntity accountEntity) {
		super();
		this.token = token;
		this.expiryDate = expiryDate;
		this.ipAddress = ipAddress;
		this.accountEntity = accountEntity;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

}
