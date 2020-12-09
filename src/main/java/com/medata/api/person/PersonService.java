package com.medata.api.person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

	public List<Person> findAll();

	public Optional<Person> findById(Long id);

	public void save(Person lab);

	public void deleteById(Long id);
}
