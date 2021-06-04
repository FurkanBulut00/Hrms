package kodlamaio.hrms.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgramingTechnologyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;

@RestController
@RequestMapping("/api/programingTechnologiesController")
public class ProgramingTechnologiesController {
	
	private ProgramingTechnologyService programingTechnologyService;

	public ProgramingTechnologiesController(ProgramingTechnologyService programingTechnologyService) {
		super();
		this.programingTechnologyService = programingTechnologyService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody ProgramingTechnology programingTechnology) {
		this.programingTechnologyService.add(programingTechnology);
		return new SuccessResult("Success");
	}

}
