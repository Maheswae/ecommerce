package com.mahes.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mahes.ecommerce.dao.AccountRepo;
import com.mahes.ecommerce.dao.InventoryRepo;
import com.mahes.ecommerce.dao.OrderRepo;
import com.mahes.ecommerce.exception.EcommerceException;
import com.mahes.ecommerce.model.Account;
import com.mahes.ecommerce.model.Inventory;
import com.mahes.ecommerce.model.Item;
import com.mahes.ecommerce.model.Orders;

@Service
public class MainService {
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	@Autowired
	AccountService accountService;
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = EcommerceException.class)
	public Integer createOrder(Orders order) throws EcommerceException {
		if (order.getAccount() == null) {
			throw new EcommerceException("Account Not Found");
		}
		Account account= null;
		if(order.getAccount().getId() == null) {
			account = accountService.createAccount(order.getAccount());
			order.setAccount(account);
		} else {
			Optional<Account> accountnw = accountRepo.findById(order.getAccount().getId());
			account = accountnw.isPresent() ? accountnw.get() : null;
			if (account == null) {
				account = accountService.createAccount(order.getAccount());
				order.setAccount(account);
			} else {
				order.setAccount(account);
			}			
		}
		Inventory inventoryItem = null;
		for (Item item : order.getItems()) {
			inventoryItem = inventoryRepo.findByName(item.getItemName());
			if (inventoryItem.getCount() < item.getCount()) {
				throw new EcommerceException("Stock Not Available");
			} else {
				inventoryItem.setCount(inventoryItem.getCount() - item.getCount());
			}
		} 
		return orderRepo.save(order).getOrderId();
	}
	
	
}
