package com.mahes.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahes.ecommerce.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
