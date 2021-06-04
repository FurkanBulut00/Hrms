package kodlamaio.hrms.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvLink;

@RestController
@RequestMapping("/api/cvLinkController")
public class CvLinkController {
	
	private CvLinkService cvLinkService;

	public CvLinkController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink) {
		this.cvLinkService.add(cvLink);
		return new SuccessResult("Success");
	}

}
