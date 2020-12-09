package com.medata.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository _personRepository) {
		personRepository = _personRepository;
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public void save(Person lab) {
		personRepository.save(lab);
	}

	@Override
	public void deleteById(Long id) {
		personRepository.deleteById(id);
	}
}
