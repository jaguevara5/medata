package com.medata.api.customer;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Customer> query =
			currentSession.createQuery("from Customer", Customer.class);

		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Optional<Customer> findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer theCustomer =
			currentSession.get(Customer.class, theId);
		return Optional.ofNullable(theCustomer);
	}

	@Override
	public void save(Customer theCustomer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery =
			currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}
