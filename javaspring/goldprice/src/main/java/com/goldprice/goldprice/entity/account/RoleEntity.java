package com.goldprice.goldprice.entity.account;

import java.util.ArrayList;
import java.util.List;

import com.goldprice.goldprice.entity.BaseEntity;

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
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "roleEntities")
	private List<AccountEntity> accountEntities = new ArrayList<>();

	public RoleEntity() {
		super();
	}

	public RoleEntity(String name, List<AccountEntity> accountEntities) {
		super();
		this.name = name;
		this.accountEntities = accountEntities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountEntity> getAccountEntities() {
		return accountEntities;
	}

	public void setAccountEntities(List<AccountEntity> accountEntities) {
		this.accountEntities = accountEntities;
	}

}
