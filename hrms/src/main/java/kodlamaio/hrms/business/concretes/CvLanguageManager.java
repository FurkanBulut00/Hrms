package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.dto.CvLanguageDto;

@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;
	private CvService cvService;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao,CvService cvService) {
		super();
		this.cvLanguageDao = cvLanguageDao;
		this.cvService = cvService;
	}

	@Override
	public DataResult<List<CvLanguage>> getAllByCv_CvId(int cvId) {
	return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCv_CvId(cvId));
	}

	@Override
	public Result add(CvLanguageDto cvLanguageDto) {
	CvLanguage cvLanguageAdd = new CvLanguage();
	cvLanguageAdd.setLanguageLevel(cvLanguageDto.getLanguageLevel());
	cvLanguageAdd.setLanguageName(cvLanguageDto.getLanguageName());
	cvLanguageAdd.setCv(cvService.getById(cvLanguageDto.getCvId()).getData());
	cvLanguageDao.save(cvLanguageAdd);
	return new SuccessResult();
	}

	@Override
	public Result addAll(List<CvLanguage> cvLanguages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(CvLanguageDto cvLanguageDto, int id) {
	CvLanguage cvLanguageUpdate = cvLanguageDao.getOne(id);
	cvLanguageUpdate.setLanguageLevel(cvLanguageDto.getLanguageLevel());
	cvLanguageUpdate.setLanguageName(cvLanguageDto.getLanguageName());
	cvLanguageDao.save(cvLanguageUpdate);
	return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		this.cvLanguageDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<CvLanguage> getById(int id) {
		CvLanguage cvLanguage = cvLanguageDao.findById(id);
		return new SuccessDataResult<CvLanguage>(cvLanguage);
	}

//	@Override
//	public DataResult<List<CvLanguage>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCandidateId(id),"Success");
//	}
//
//	@Override
//	public Result add(CvLanguage cvLanguage) {
//		this.cvLanguageDao.save(cvLanguage);
//		return new SuccessResult("Success");
//	}
//
//	@Override
//	public Result update(CvLanguage cvLanguage) {
//		return null;
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.cvLanguageDao.deleteById(id);
//		return new SuccessResult("Dil silindi");
//	}
//
//	@Override
//	public Result addAll(List<CvLanguage> cvLanguages) {
//		this.cvLanguageDao.saveAll(cvLanguages);
//		return new SuccessResult("Success");
//	}

}
