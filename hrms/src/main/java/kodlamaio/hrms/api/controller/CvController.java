package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

@RestController
@RequestMapping("api/cvController")
public class CvController {
	private CvService cvService;
	private CandidateService candidateService;

	@Autowired
	public CvController(CvService cvService,CandidateService candidateService) {
		super();
		this.cvService = cvService;
		this.candidateService=candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvDto cvDto,int id) {
		return this.cvService.add(cvDto, id);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CvDto>getByCandidateId(@RequestParam int id){
		return this.candidateService.getByCandidateId(id);
	
	}

	
	
}
