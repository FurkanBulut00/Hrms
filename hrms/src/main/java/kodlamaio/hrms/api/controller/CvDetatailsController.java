package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvDetailsService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvDetails;

@RestController
@RequestMapping("/api/cvDetatailsController")
public class CvDetatailsController {
	
	private CvDetailsService cvDetailsService;

	@Autowired
	public CvDetatailsController(CvDetailsService cvDetailsService) {
		super();
		this.cvDetailsService = cvDetailsService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvDetails cvDetails ) {
		this.cvDetailsService.add(cvDetails);
		return new SuccessResult("Success");
	}
	
}
