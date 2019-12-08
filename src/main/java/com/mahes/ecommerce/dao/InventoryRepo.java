package com.mahes.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahes.ecommerce.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
	
	Inventory findByName(String name);
}
