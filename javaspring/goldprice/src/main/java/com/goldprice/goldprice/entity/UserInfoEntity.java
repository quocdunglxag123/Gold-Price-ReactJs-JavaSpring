package com.goldprice.goldprice.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfoEntity extends BaseEntity {
	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private Date birthday;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountEntity accountEntity;

	public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
		this.firstName = userInfoEntity.getFirstName();
		this.lastName = userInfoEntity.getLastName();
		this.address = userInfoEntity.getAddress();
		this.phoneNumber = userInfoEntity.getPhoneNumber();
		this.birthday = userInfoEntity.getBirthday();
		this.accountEntity = userInfoEntity.getAccountEntity();
	}

	public UserInfoEntity() {
		super();
	}

	public UserInfoEntity(String firstName, String lastName, String address, String phoneNumber, Date birthday,
			AccountEntity accountEntity) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.accountEntity = accountEntity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

}
