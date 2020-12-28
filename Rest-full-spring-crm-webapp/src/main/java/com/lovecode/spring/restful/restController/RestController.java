package com.lovecode.spring.restful.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovecode.spring.restful.DAO.CustomerDAO;
import com.lovecode.spring.restful.entity.Customer;
import com.lovecode.spring.restful.service.CustomerService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer")
	public List<Customer> listOfCustomer()
	{
		
	return 	service.getCustomer();
	
	}
	
	@GetMapping("/customer/{customerid}")
	public Customer listOfCustomer(@PathVariable int customerid)
	{
		
	Customer cst=	service.getCustomer(customerid);
	if(cst==null)
	{
		throw new CustomerRestException("Wrong CUstomer id");
	}
	else
	return cst;
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		//this is because we use save or update
		customer.setId(0);
		service.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customer")
	public Customer UpdateCustomer(@RequestBody Customer customer)
	{
		service.saveCustomer(customer);
		return customer;
		
	}
	
	@DeleteMapping("/customer/{id}")
	public int deleteCustomer(@PathVariable int id)
	{
		Customer cst=	service.getCustomer(id);
		if(cst==null)
		{
			throw new CustomerRestException("Wrong CUstomer id");
		}
		service.deleteCustomer(id);
		return id;
		
	}
	

}
