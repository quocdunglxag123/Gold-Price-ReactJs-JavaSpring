package com.goldprice.goldprice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String roleName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "roleEntities")
	private List<AccountEntity> accountEntities = new ArrayList<>();
	
	
	public RoleEntity() {
		super();
	}

	public RoleEntity(String roleName, List<AccountEntity> accountEntities) {
		super();
		this.roleName = roleName;
		this.accountEntities = accountEntities;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName.toLowerCase();
	}

	public List<AccountEntity> getAccountEntities() {
		return accountEntities;
	}

	public void setAccountEntities(List<AccountEntity> accountEntities) {
		this.accountEntities = accountEntities;
	}

	
	
}
