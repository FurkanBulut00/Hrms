package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.dto.CvDto;
import kodlamaio.hrms.entities.concretes.dto.CvExperienceDto;

public interface CvExperienceService {
	
	DataResult<List<CvExperience>> getAllByCv_CvId(int cvId);
	
	DataResult<List<CvExperience>> getAllByCv_CvIdOrderByEndDateDesc(int cvId);
	
	Result add(CvExperienceDto cvExperienceDto);
	
	Result addAll(List<CvExperience> cvExperienceS );
	
	Result update(CvExperienceDto cvExperienceDto,int id);
	
	Result delete(int id);
	
	DataResult<CvExperience> getById(int id);
}
