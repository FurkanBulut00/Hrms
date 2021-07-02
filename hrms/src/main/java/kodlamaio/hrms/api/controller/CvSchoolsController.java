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

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.concretes.dto.CvSchoolDto;

@RestController
@RequestMapping("/api/cvSchoolsController")
@CrossOrigin
public class CvSchoolsController {
	
	private CvSchoolService cvSchoolService;
	
	@Autowired
	public CvSchoolsController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSchoolDto cvSchoolDto) {
		this.cvSchoolService.add(cvSchoolDto);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		this.cvSchoolService.delete(id);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvSchoolDto cvSchoolDto,int id) {
		this.cvSchoolService.update(cvSchoolDto,id);
		return new SuccessResult("Success");
	}
	
	@GetMapping("/getAllByCv_CvId")
	public DataResult<List<CvSchool>> getAllByCv_CvId(int cvId){
		return this.cvSchoolService.getAllByCv_CvId(cvId);
	}
	
	@GetMapping("/getAllByCv_CvIdOrderBySchoolGraduationDateDesc")
	public DataResult<List<CvSchool>> getAllByCv_CvIdOrderBySchoolGraduationDateDesc(int cvId){
		return this.cvSchoolService.getAllByCv_CvIdOrderBySchoolGraduationDateDesc(cvId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.cvSchoolService.getById(id);
	}
	

}
