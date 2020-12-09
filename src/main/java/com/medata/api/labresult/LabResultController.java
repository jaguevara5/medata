package com.medata.api.labresult;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/labresults")
public class LabResultController {

	private final LabResultRepository labResultRepository;

	public LabResultController(LabResultRepository labResultRepository) {
		this.labResultRepository = labResultRepository;
	}

	@GetMapping("")
	public Iterable<LabResult> getLabResults() {
		return labResultRepository
			.findAll(Sort.by(Sort.Direction.ASC, "resultsDate"));
	}
}
