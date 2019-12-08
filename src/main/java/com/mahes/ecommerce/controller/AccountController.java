package com.mahes.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahes.ecommerce.model.Account;
import com.mahes.ecommerce.service.MainService;

@RestController
@RequestMapping(value="/account")
public class AccountController {
	
	@Autowired
	MainService service; 
	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return service.createAccount(account);
	}
}
