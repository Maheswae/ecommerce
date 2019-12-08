package com.mahes.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	 
	private String accountType;
	
	private String name;
	
	@OneToMany(mappedBy="account", cascade=CascadeType.ALL)
	private List<Orders> orders;
	
	
	

	public List<Orders> getOrder() {
		return orders;
	}

	public void setOrder(List<Orders> order) {
		this.orders = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
