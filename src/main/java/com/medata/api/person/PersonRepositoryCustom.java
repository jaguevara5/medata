package com.medata.api.person;

import com.medata.api.person.patient.Patient;
import com.medata.api.person.physician.Physician;

import java.util.List;

public interface PersonRepositoryCustom {

	List<Patient> getAllPatients();

	List<Physician> getAllPhysicians();
}
