package com.goldprice.goldprice.dto;

import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goldprice.goldprice.shared.FormatDate;

public class UserInfoDto extends BaseDto {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private Long accountId;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date birthday;

	public void setBirthday(String birthday) throws ParseException {
		FormatDate frmDate = new FormatDate();
		this.birthday = frmDate.convertStringToDate(birthday, "yyyy/MM/dd");
	}

	public UserInfoDto() {
		super();
	}

	public UserInfoDto(String firstName, String lastName, String address, String phoneNumber, Long accountId,
			Date birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accountId = accountId;
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

}
