package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvLinkService {
	
	DataResult<List<CvLink>> getAllByCandidateId(int id);
	
	Result add(CvLink cvLink);
	
	Result addAll(List<CvLink> cvLinks);
	
	Result update(CvLink cvLink);
	
	Result delete(CvLink cvLink);
}
