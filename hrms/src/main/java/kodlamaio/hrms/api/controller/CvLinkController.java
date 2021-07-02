package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.concretes.dto.CvLinkDto;

@RestController
@RequestMapping("/api/cvLinkController")
@CrossOrigin
public class CvLinkController {
	
	private CvLinkService cvLinkService;

	public CvLinkController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLinkDto cvLinkDto) {
		this.cvLinkService.add(cvLinkDto);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLinkDto cvLinkDto,int id) {
		this.cvLinkService.update(cvLinkDto,id);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		this.cvLinkService.delete(id);
		return new SuccessResult("Success");
	}
	
	@GetMapping("/getAllByCv_CvId")
	 public DataResult<List<CvLink>> getAllByCv_CvId(int cvId){
		return this.cvLinkService.getAllByCv_CvId(cvId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.cvLinkService.getById(id);
	}

}
