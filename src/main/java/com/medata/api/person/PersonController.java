package com.medata.api.person;

import com.medata.api.person.patient.Patient;
import com.medata.api.person.physician.Physician;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/people")
public class PersonController {

	private final PersonRepository personRepository;

	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@PostMapping("patients")
	@ResponseStatus(HttpStatus.CREATED)
	public Person createPatient(@RequestBody Patient patient) {
		return personRepository.save(patient);
	}

	@PostMapping("physicians")
	@ResponseStatus(HttpStatus.CREATED)
	public Person createPhysician(@RequestBody Physician physician) {
		return personRepository.save(physician);
	}

	@GetMapping("")
	public Iterable<Person> getPeople() {
		return personRepository.findAll();
	}

	@GetMapping("patients")
	public Iterable<Patient> getPatients() {
		return personRepository.getAllPatients();
	}

	@GetMapping("physicians")
	public Iterable<Physician> getPhysicians() {
		return personRepository.getAllPhysicians();
	}

	@PutMapping("physicians")
	public ResponseEntity<Physician> updatePhysician(@RequestBody Physician physician) {
		personRepository.save(physician);;
		return ResponseEntity.ok(physician);
	}

	@PutMapping("patients")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		personRepository.save(patient);;
		return ResponseEntity.ok(patient);
	}
}
