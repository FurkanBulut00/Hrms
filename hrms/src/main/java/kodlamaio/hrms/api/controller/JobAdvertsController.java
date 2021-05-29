package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	@PostMapping("/changeActiveToPassive")
	public Result changeActiveToPassive(int id) {
		return this.jobAdvertService.changeActiveToPassive(id);
	}
	@GetMapping("/findByIsActiveTrue")
	public DataResult<List<JobAdvert>> findByIsActiveTrue(){
		return this.jobAdvertService.findByIsActiveTrue();
	}
	@GetMapping("findByIsActiveTrueOrderByPostedDate")
	public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPostedDate(){
		return this.jobAdvertService.findByIsActiveTrueOrderByPostedDate();
	}
	@GetMapping("getAllActiveJobAdvertByCompany")
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompany(int id){
		return this.jobAdvertService.getAllActiveJobAdvertByCompany(id);
	}
	
}
