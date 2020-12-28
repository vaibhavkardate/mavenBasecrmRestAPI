package com.lovecode.spring.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lovecode.spring.restful.DAO.CustomerDAO;
import com.lovecode.spring.restful.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO clist;
	
	@Transactional
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
	return clist.getCustomer();
	}

	
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		clist.saveCustomer(theCustomer);
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return clist.getCustomer(id);
	}

@Transactional
	@Override
	public void deleteCustomer(int id) {
		clist.deleteCustomer(id);
		
	}

}
