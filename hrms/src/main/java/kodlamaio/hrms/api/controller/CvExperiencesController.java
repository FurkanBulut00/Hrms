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

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.dto.CvExperienceDto;

@RestController
@RequestMapping("/api/cvExperiencesController")
@CrossOrigin
public class CvExperiencesController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperiencesController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvExperienceDto cvExperienceDto) {
		this.cvExperienceService.add(cvExperienceDto);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvExperienceDto cvExperienceDto,int id) {
		this.cvExperienceService.update(cvExperienceDto,id);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		this.cvExperienceService.delete(id);
		return new SuccessResult("Success");
	}
	
	@GetMapping("/getAllByCv_CvId")
	public DataResult<List<CvExperience>> getAllByCv_CvId(int cvId){
		
		return this.cvExperienceService.getAllByCv_CvId(cvId);
	}
	
	@GetMapping("/getAllByCv_CvIdOrderByEndDateDesc")
	public DataResult<List<CvExperience>> getAllByCv_CvIdOrderByEndDateDesc(int cvId){
		
		return this.cvExperienceService.getAllByCv_CvIdOrderByEndDateDesc(cvId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.cvExperienceService.getById(id);
	}
	
	
}
