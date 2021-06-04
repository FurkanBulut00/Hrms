package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvExperienceService {
	
	DataResult<List<CvExperience>> getAllByCandidateId(int id);
	
	DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndDateDesc(int id);
	
	Result add(CvExperience cvExperience);
	
	Result addAll(List<CvExperience> cvExperienceS );
	
	Result update(CvExperience cvExperience);
	
	Result delete(CvExperience cvExperience);
}
