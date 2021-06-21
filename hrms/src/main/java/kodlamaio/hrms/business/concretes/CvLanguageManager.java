package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hrms.entities.concretes.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public DataResult<List<CvLanguage>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCandidateId(id),"Success");
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Success");
	}

	@Override
	public Result update(CvLanguage cvLanguage) {
		return null;
	}

	@Override
	public Result delete(CvLanguage cvLanguage) {
		return null;
	}

	@Override
	public Result addAll(List<CvLanguage> cvLanguages) {
		this.cvLanguageDao.saveAll(cvLanguages);
		return new SuccessResult("Success");
	}

}
