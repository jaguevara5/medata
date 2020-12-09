package com.medata.api.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabServiceImpl implements LabService {

	private LabRepository labRepository;

	@Autowired
	public LabServiceImpl(LabRepository _labRepository) {
		labRepository = _labRepository;
	}

	@Override
	public List<Lab> findAll() {
		return labRepository.findAll();
	}

	@Override
	public Optional<Lab> findById(int id) {
		return labRepository.findById(id);
	}

	@Override
	public void save(Lab lab) {
		labRepository.save(lab);
	}

	@Override
	public void deleteById(int id) {
		labRepository.deleteById(id);
	}
}
