package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.dto.CvAddDto;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

@RestController
@RequestMapping("api/cvController")
@CrossOrigin
public class CvController {
	private CvService cvService;
	

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvAddDto cvAddDto) {
		return this.cvService.add(cvAddDto);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Cv>>getAllByCandidateId(@RequestParam int id){
		return this.cvService.getAllByCandidateId(id);
	
	}
	
	

	
	
}
