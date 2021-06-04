package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvPhotoService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CvPhoto;

@RestController
@RequestMapping("/api/cvPhotosController")
public class CvPhotosController {
	
	private CvPhotoService cvPhotoService;

	@Autowired
	public CvPhotosController(CvPhotoService cvPhotoService) {
		super();
		this.cvPhotoService = cvPhotoService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvPhoto cvPhoto,MultipartFile multipartFile) {
		this.cvPhotoService.add(cvPhoto, multipartFile);
		return new SuccessResult("Success");
	}
	
	

}
