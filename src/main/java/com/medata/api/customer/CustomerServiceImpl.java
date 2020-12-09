package com.medata.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(@Qualifier("customerDAOJpaImpl") CustomerDAO _customerDAO) {
		this.customerDAO = _customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Optional<Customer> findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}
}
