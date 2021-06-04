package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvDetailsService {
		
	DataResult<List<CvDetails>> getAllByCandidateId(int id);
	
	Result add(CvDetails cvDetails);
	
	Result addAll(List<CvDetails> cvDetails);
	
	Result update(CvDetails cvDetails);
	
	Result delete(CvDetails cvDetails);
}
