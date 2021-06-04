package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvPhotoService;
import kodlamaio.hrms.core.utilities.imageService.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvPhotoDao;
import kodlamaio.hrms.entities.concretes.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService {

	private CvPhotoDao cvPhotoDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao,ImageUploadService imageUploadService) {
		super();
		this.cvPhotoDao = cvPhotoDao;
		this.imageUploadService= imageUploadService;
	}

	@Override
	public DataResult<List<CvPhoto>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvPhoto>>(this.cvPhotoDao.getAllByCandidateId(id), "Success");
	}

	@Override
	public Result add(CvPhoto cvPhoto,MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		this.cvPhotoDao.save(cvPhoto);	
		return new SuccessResult("Success");
		
	}

	@Override
	public Result update(CvPhoto cvPhoto) {
		return null;
	}

	@Override
	public Result delete(CvPhoto cvPhoto) {
		return null;
	}

	@Override
	public Result addAll(List<CvPhoto> cvPhotos) {
		this.cvPhotoDao.saveAll(cvPhotos);
		return new SuccessResult("Success");
	}

}
