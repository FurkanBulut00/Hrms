package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.dto.CvAddDto;
import kodlamaio.hrms.entities.concretes.dto.CvDto;


public interface CvService {
	
	Result add(CvAddDto cvAddDto);
	
	DataResult<Cv> getById(int id);
	
	DataResult<List<Cv>> getAllBycvId(int id);
	
	DataResult<List<Cv>> getAllByCandidateId(int id);
	
	
}
