package com.lovecode.spring.restful.service;

import java.util.List;

import com.lovecode.spring.restful.entity.Customer;



public interface CustomerService {

	
	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
}
