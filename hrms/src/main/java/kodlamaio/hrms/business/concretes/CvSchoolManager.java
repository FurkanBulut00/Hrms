package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSchoolDao;
import kodlamaio.hrms.entities.concretes.CvSchool;

@Service
public class CvSchoolManager implements CvSchoolService {

	private CvSchoolDao cvSchoolDao;

	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		super();
		this.cvSchoolDao = cvSchoolDao;
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByCandidateId(id), "Success");
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCandidateIdOrderBySchoolGraduationDateDesc(int id) {
		return new SuccessDataResult<List<CvSchool>>(
				this.cvSchoolDao.getAllByCandidateIdOrderBySchoolGraduationDateDesc(id), "Success");
	}

	@Override
	public Result add(CvSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Success");
	}

	@Override
	public Result update(CvSchool cvSchool) {
		return null;
	}

	@Override
	public Result delete(CvSchool cvSchool) {
		return null;
	}

	@Override
	public Result addAll(List<CvSchool> cvSchools) {
		this.cvSchoolDao.saveAll(cvSchools);
		return new SuccessResult("Success");
	}

}
