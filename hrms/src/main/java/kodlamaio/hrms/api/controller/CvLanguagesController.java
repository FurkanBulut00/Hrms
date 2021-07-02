package kodlamaio.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.dto.CvLanguageDto;

@RestController
@RequestMapping("/api/cvLanguagesController")
@CrossOrigin
public class CvLanguagesController {
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	@PostMapping("/add")
		public Result add(@RequestBody CvLanguageDto cvLanguageDto) {
		this.cvLanguageService.add(cvLanguageDto);
		return new SuccessResult("Success");
		
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLanguageDto cvLanguageDto,int id) {
	this.cvLanguageService.update(cvLanguageDto,id);
	return new SuccessResult("Success");
	
}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
	this.cvLanguageService.delete(id);
	return new SuccessResult("Success");
	
}
	
	@GetMapping("getAllByCv_CvId")
	public DataResult<List<CvLanguage>> getAllByCv_CvId(int cvId){
		return this.cvLanguageService.getAllByCv_CvId(cvId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		return this.cvLanguageService.getById(id);
	}
	
	//public ResponseEntity<?> add(@Valid @RequestBody CvLanguage cvLanguage ){
			//	return ResponseEntity.ok(this.cvLanguageService.add(cvLanguage));
}
