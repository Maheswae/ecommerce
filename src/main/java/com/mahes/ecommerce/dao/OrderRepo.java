package com.mahes.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahes.ecommerce.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
