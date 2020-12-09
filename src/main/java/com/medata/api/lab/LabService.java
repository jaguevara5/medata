package com.medata.api.lab;

import java.util.List;
import java.util.Optional;

public interface LabService {

	public List<Lab> findAll();

	public Optional<Lab> findById(int id);

	public void save(Lab lab);

	public void deleteById(int id);
}
