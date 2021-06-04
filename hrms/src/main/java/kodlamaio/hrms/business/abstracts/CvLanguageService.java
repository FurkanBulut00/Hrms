package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvLanguageService {
	
	DataResult<List<CvLanguage>> getAllByCandidateId(int id);
	
	Result add(CvLanguage cvLanguage);
	
	Result addAll(List<CvLanguage> cvLanguages );
	
	Result update(CvLanguage cvLanguage);
	
	Result delete(CvLanguage cvLanguage);
}
