package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.dto.CvDto;
import kodlamaio.hrms.entities.concretes.dto.CvLanguageDto;

public interface CvLanguageService {
	
	DataResult<List<CvLanguage>> getAllByCv_CvId(int cvId);
	
	Result add(CvLanguageDto cvLanguageDto);
	
	Result addAll(List<CvLanguage> cvLanguages );
	
	Result update(CvLanguageDto cvLanguageDto,int id);
	
	Result delete(int id);
	
	DataResult<CvLanguage> getById(int id);
}
