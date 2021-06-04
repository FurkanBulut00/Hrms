package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvLanguage;

@RestController
@RequestMapping("/api/cvLanguagesController")
public class CvLanguagesController {
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		this.cvLanguageService.add(cvLanguage);
		return new SuccessResult("Success");
	}
}
