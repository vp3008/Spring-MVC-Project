package com.deepankar.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepankar.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//get the list of customers by executing the query
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.save(theCustomer);
	}

}
