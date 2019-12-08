package com.mahes.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mahes.ecommerce.dao.AccountRepo;
import com.mahes.ecommerce.exception.EcommerceException;
import com.mahes.ecommerce.model.Account;

@Service
public class AccountService {

	@Autowired
	AccountRepo accountRepo;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Account createAccount(Account ac) {
		ac = new Account();
		ac.setName("abcddd");
		ac = accountRepo.saveAndFlush(ac);
		return ac;
	}
}
