package com.deepankar.springdemo.service;

import java.util.List;

import com.deepankar.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int theId);
	
	public void deleteCustomer(int theId);

	public List<Customer> search(String theSearchName);
}
