package com.medata.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOJpaImpl(EntityManager _entityManager) {
		entityManager = _entityManager;
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> query =
			entityManager.createQuery("from Customer", Customer.class);

		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Optional<Customer> findById(int theId) {
		Customer customer = entityManager.find(Customer.class, theId);
		return Optional.ofNullable(customer);
	}

	@Override
	public void save(Customer theCustomer) {
		Customer customer = entityManager.merge(theCustomer);
		theCustomer.setId(customer.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query query = entityManager.createQuery(
			"delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		query.executeUpdate();
	}
}
