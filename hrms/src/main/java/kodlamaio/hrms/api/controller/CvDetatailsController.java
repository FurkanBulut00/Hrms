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

import kodlamaio.hrms.business.abstracts.CvDetailsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.dto.CvDetailsDto;

@RestController
@RequestMapping("/api/cvDetatailsController")
@CrossOrigin
public class CvDetatailsController {
	
	private CvDetailsService cvDetailsService;

	@Autowired
	public CvDetatailsController(CvDetailsService cvDetailsService) {
		super();
		this.cvDetailsService = cvDetailsService;
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.cvDetailsService.getById(id);
	}
	
	@GetMapping("/getAllByCv")
	public DataResult<List<CvDetails>> getAllByCv(@RequestParam int cvId) {
		return this.cvDetailsService.getAllByCv_CvId(cvId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvDetailsDto cvDetailsDto ) {
		this.cvDetailsService.add(cvDetailsDto);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvDetailsDto cvDetailsDto,int id ) {
		this.cvDetailsService.update(cvDetailsDto, id);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id ) {
		this.cvDetailsService.delete(id);
		return new SuccessResult("Success");
	}
	

	
}
