package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("/api/cvSchoolsController")
public class CvSchoolsController {
	
	private CvSchoolService cvSchoolService;
	
	@Autowired
	public CvSchoolsController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvSchool cvSchool) {
		this.cvSchoolService.add(cvSchool);
		return new SuccessResult("Success");
	}

}
