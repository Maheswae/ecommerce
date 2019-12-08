package com.mahes.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahes.ecommerce.model.Orders;
import com.mahes.ecommerce.service.MainService;



@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired	
	MainService mainService;
	
	@PostMapping
	public Integer postOrder(@RequestBody Orders order) throws Exception {
		return mainService.createOrder(order);
	}
}
