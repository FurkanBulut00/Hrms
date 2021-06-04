package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidateId(id), "Success");
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndDateDesc(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidateIdOrderByEndDateDesc(id),
				"Success");
	}

	@Override
	public Result add(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Success");
	}

	@Override
	public Result update(CvExperience cvExperience) {
		return null;
	}

	@Override
	public Result delete(CvExperience cvExperience) {
		return null;
	}

	@Override
	public Result addAll(List<CvExperience> cvExperienceS) {
		this.cvExperienceDao.saveAll(cvExperienceS);
		return new SuccessResult("Success");
	}

}
