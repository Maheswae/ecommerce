package com.mahes.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahes.ecommerce.model.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
