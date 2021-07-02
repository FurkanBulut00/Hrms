package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.dto.CvExperienceDto;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;
	private CvService cvService;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao,CvService cvService) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		this.cvService=cvService;
	}

//	@Override
//	public DataResult<List<CvExperience>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidateId(id), "Success");
//	}
//
//	@Override
//	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndDateDesc(int id) {
//		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidateIdOrderByEndDateDesc(id),
//				"Success");
//	}
//
//	@Override
//	public Result add(CvExperience cvExperience) {
//		this.cvExperienceDao.save(cvExperience);
//		return new SuccessResult("Success");
//	}
//
//	@Override
//	public Result update(CvExperience cvExperience) {
//		return null;
//	}
//
//	@Override
//	public Result delete(CvExperience cvExperience) {
//		return null;
//	}

	@Override
	public Result addAll(List<CvExperience> cvExperienceS) {
		this.cvExperienceDao.saveAll(cvExperienceS);
		return new SuccessResult("Success");
	}

@Override
public DataResult<List<CvExperience>> getAllByCv_CvId(int cvId) {
	return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCv_CvId(cvId));
	
}

@Override
public DataResult<List<CvExperience>> getAllByCv_CvIdOrderByEndDateDesc(int cvId) {
	return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCv_CvIdOrderByEndDateDesc(cvId));
}

@Override
public Result add(CvExperienceDto cvExperienceDto) {
	CvExperience cvExperienceAdd = new CvExperience();
	cvExperienceAdd.setBeginingDate(cvExperienceDto.getBeginingDate());
	cvExperienceAdd.setCvExperienceName(cvExperienceDto.getCvExperienceName());
	cvExperienceAdd.setEndDate(cvExperienceDto.getEndDate());
	cvExperienceAdd.setOtherCompany(cvExperienceDto.getOtherCompany());
	cvExperienceAdd.setCv(cvService.getById(cvExperienceDto.getCvId()).getData());
	cvExperienceDao.save(cvExperienceAdd);
	return new SuccessResult();
}

@Override
public Result update(CvExperienceDto cvExperienceDto, int id) {
	CvExperience cvExperienceUpdate = cvExperienceDao.getOne(id);
	cvExperienceUpdate.setBeginingDate(cvExperienceDto.getBeginingDate());
	cvExperienceUpdate.setCvExperienceName(cvExperienceDto.getCvExperienceName());
	cvExperienceUpdate.setEndDate(cvExperienceDto.getEndDate());
	cvExperienceUpdate.setOtherCompany(cvExperienceDto.getOtherCompany());
	cvExperienceDao.save(cvExperienceUpdate);
	return new SuccessResult();
}

@Override
public Result delete(int id) {
	this.cvExperienceDao.deleteById(id);
	return new SuccessResult();
}

@Override
public DataResult<CvExperience> getById(int id) {
	CvExperience cvExperience = cvExperienceDao.findById(id);
	return new SuccessDataResult<CvExperience>(cvExperience);
}

}
