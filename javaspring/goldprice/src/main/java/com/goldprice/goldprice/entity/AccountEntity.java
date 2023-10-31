package com.goldprice.goldprice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL)
	private UserInfoEntity userInfoEntity;

	@OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL)
	private RefreshTokenEntity refreshTokenEntity;

	@ManyToMany
	@JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();

	public AccountEntity() {
		super();
	}

	public AccountEntity(String username, String password, UserInfoEntity userInfoEntity,
			RefreshTokenEntity refreshTokenEntity, List<RoleEntity> roleEntities) {
		super();
		this.username = username;
		this.password = password;
		this.userInfoEntity = userInfoEntity;
		this.refreshTokenEntity = refreshTokenEntity;
		this.roleEntities = roleEntities;
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

	public UserInfoEntity getUserInfoEntity() {
		return userInfoEntity;
	}

	public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
		this.userInfoEntity = userInfoEntity;
	}

	public RefreshTokenEntity getRefreshTokenEntity() {
		return refreshTokenEntity;
	}

	public void setRefreshTokenEntity(RefreshTokenEntity refreshTokenEntity) {
		this.refreshTokenEntity = refreshTokenEntity;
	}

	public List<RoleEntity> getRoleEntities() {
		return roleEntities;
	}

	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}
	
	public void addRoleEntity(RoleEntity roleEntities) {
		this.roleEntities.add(roleEntities);
	}
}
