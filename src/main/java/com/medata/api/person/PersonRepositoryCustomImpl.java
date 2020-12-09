package com.medata.api.person;

import com.medata.api.person.patient.Patient;
import com.medata.api.person.physician.Physician;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Patient> getAllPatients() {
		return entityManager.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
	}

	@Override
	public List<Physician> getAllPhysicians() {
		return entityManager.createQuery("SELECT p FROM Physician p", Physician.class).getResultList();
	}
}
