package com.medata.api.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("labs")
public class LabController {

	private final LabService labService;

	@Autowired
	public LabController(LabService _labService) {
		labService = _labService;
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Lab createLab(@RequestBody Lab lab) {
		labService.save(lab);
		return lab;
	}

	@PutMapping("")
	public Lab updateLab(@RequestBody Lab lab) {
		labService.save(lab);
		return lab;
	}

	@GetMapping("")
	public Iterable<Lab> getLabs() {
		return labService.findAll();
	}

	@GetMapping("/{labId}")
	public Lab getLab(@PathVariable int labId) {
		Optional<Lab> lab = labService.findById(labId);
		if (!lab.isPresent()) {
			throw new RuntimeException("Lab with id " + labId + " not found!");
		}
		return lab.get();
	}

	@DeleteMapping("/{labId}")
	public String deleteLab(@PathVariable int labId) {
		Optional<Lab> lab = labService.findById(labId);
		if (!lab.isPresent()) {
			throw new RuntimeException("Lab with id " + labId + " not found!");
		}
		labService.deleteById(labId);
		return "Lab with id " + labId + " was removed successfully";
	}
}
