package com.goldprice.goldprice.dto;

import java.text.ParseException;
import java.util.Date;

import com.goldprice.goldprice.shared.FormatDate;

public class RegisterDto extends BaseDto {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String phoneNumber;
	private Date birthday;

	public void setBirthday(String birthday) throws ParseException {
		FormatDate frmDate = new FormatDate();
		this.birthday = frmDate.convertStringToDate(birthday, "yyyy/MM/dd");
	}

	public RegisterDto() {
		super();
	}

	public RegisterDto(String firstName, String lastName, String username, String password, String address,
			String phoneNumber, Date birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
