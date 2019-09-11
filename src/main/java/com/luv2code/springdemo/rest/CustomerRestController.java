package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Ledger;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.LedgerService;

@RestController
@RequestMapping("/api/v0")
public class CustomerRestController {
	
	//autowire the customerService 
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LedgerService ledgerService;
	
	//add mapping for GET /cutomers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
	}
	
	//add mapping for GET /cutomers
	@GetMapping("/ledger")
	public List<Ledger> getledgerValues() {
			
		return ledgerService.getValues();
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/customers/{customerId}")
	public Customer getledgerValues(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer not found : "+ customerId);
		}
		
		return theCustomer;
	}
	
	//Add mapping for post /customers - add new customer 
	@PostMapping("customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//also just in case the pass an id in JSON .. set if to 0
		//this will force a save of new item .. instead of update
		
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	
	//Add mapping for put /customers - update an existing customer 
	@PutMapping("customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	//Add mapping to DELETE /customers/{customerId} to delete if a customer exists
	@DeleteMapping("/customers/{customerId}") 
	public String deleteCustomer(@PathVariable int customerId){
		
		//Throw expection if null 
		Customer tempCustomer = customerService.getCustomer(customerId);
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer not found : "+ customerId);
		}
		
		customerService.deleteCustomer(customerId);
		return " Deleted the customer with the id : "+ customerId;
	}

}
