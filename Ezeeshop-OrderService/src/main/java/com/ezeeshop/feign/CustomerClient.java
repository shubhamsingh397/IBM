package com.ezeeshop.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ezeeshop.dto.Customer;

@FeignClient(value = "customer")
public interface CustomerClient {

	@GetMapping("/customers/{userName}")
	public Customer getCustomerByUserName(@PathVariable("userName") String userName);
}