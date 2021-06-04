package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvPhotoService {

	DataResult<List<CvPhoto>> getAllByCandidateId(int id);

	Result add(CvPhoto cvPhoto,MultipartFile imageFile);

	Result addAll(List<CvPhoto> cvPhotos);

	Result update(CvPhoto cvPhoto);

	Result delete(CvPhoto cvPhoto);
}
