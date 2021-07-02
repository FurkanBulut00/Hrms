package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgramingTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;
import kodlamaio.hrms.entities.concretes.dto.ProgramingTechnologyDto;

@RestController
@RequestMapping("/api/programingTechnologiesController")
@CrossOrigin
public class ProgramingTechnologiesController {
	
	private ProgramingTechnologyService programingTechnologyService;

	public ProgramingTechnologiesController(ProgramingTechnologyService programingTechnologyService) {
		super();
		this.programingTechnologyService = programingTechnologyService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProgramingTechnologyDto programingTechnologyDto) {
		this.programingTechnologyService.add(programingTechnologyDto);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ProgramingTechnologyDto programingTechnologyDto,int id) {
		this.programingTechnologyService.update(programingTechnologyDto,id);
		return new SuccessResult("Success");
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id ) {
		this.programingTechnologyService.delete(id);
		return new SuccessResult("Success");
	}
	
	@GetMapping("/getAllByCv_CvId")
	public DataResult<List<ProgramingTechnology>> getAllByCv_CvId(int cvId){
		return this.programingTechnologyService.getAllByCv_CvId(cvId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.programingTechnologyService.getById(id);
	}

}
