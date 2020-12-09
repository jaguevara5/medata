package com.medata.api.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

	public List<Customer> findAll();

	public Optional<Customer> findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);
}
