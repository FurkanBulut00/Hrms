package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CvDetailsDao;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.dto.CvDetailsDto;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvDetailsService {
		
	DataResult<List<CvDetails>> getAllByCv_CvId(int cvId);
	
	Result add(CvDetailsDto cvDetailsDto);
	
	Result addAll(List<CvDetails> cvDetails);
	
	Result update(CvDetailsDto cvDetailsDto,int id);
	
	Result delete(int id);
	
	DataResult<CvDetails> getById(int id);
}
