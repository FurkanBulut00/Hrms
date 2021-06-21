package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertWorkStyleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertWorkStyle;

@RestController
@RequestMapping("/api/jobAdvertWorkStyles")
public class JobAdvertWorkStylesController {
	
	private JobAdvertWorkStyleService jobAdvertWorkStyleService;

	@Autowired
	public JobAdvertWorkStylesController(JobAdvertWorkStyleService jobAdvertWorkStyleService) {
		super();
		this.jobAdvertWorkStyleService = jobAdvertWorkStyleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertWorkStyle>> getAll(){
		return this.jobAdvertWorkStyleService.getAll();
	}

}
