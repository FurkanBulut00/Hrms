package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSchoolDao;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.concretes.dto.CvSchoolDto;

@Service
public class CvSchoolManager implements CvSchoolService {

	private CvSchoolDao cvSchoolDao;
	private CvService cvService;

	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao,CvService cvService) {
		super();
		this.cvSchoolDao = cvSchoolDao;
		this.cvService= cvService;
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCv_CvId(int cvId) {
	return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByCv_CvId(cvId));
	
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCv_CvIdOrderBySchoolGraduationDateDesc(int cvId) {
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByCv_CvIdOrderBySchoolGraduationDateDesc(cvId));
		
	}

	@Override
	public Result add(CvSchoolDto cvSchoolDto) {
		CvSchool cvSchoolAdd = new CvSchool();
		cvSchoolAdd.setSchoolBeginDate(cvSchoolDto.getSchoolBeginDate());
		cvSchoolAdd.setSchoolDepartment(cvSchoolDto.getSchoolDepartment());
		cvSchoolAdd.setSchoolGraduationDate(cvSchoolDto.getSchoolGraduationDate());
		cvSchoolAdd.setSchoolName(cvSchoolDto.getSchoolName());
		cvSchoolAdd.setSchoolType(cvSchoolDto.getSchoolType());
		cvSchoolAdd.setCv(cvService.getById(cvSchoolDto.getCvId()).getData());
		cvSchoolDao.save(cvSchoolAdd);
		return new SuccessResult();
	}

	@Override
	public Result addAll(List<CvSchool> cvSchools) {
	return null;
	}

	@Override
	public Result update(CvSchoolDto cvSchoolDto, int id) {
	CvSchool cvSchoolUpdate = cvSchoolDao.getOne(id);
	cvSchoolUpdate.setSchoolBeginDate(cvSchoolDto.getSchoolBeginDate());
	cvSchoolUpdate.setSchoolDepartment(cvSchoolDto.getSchoolDepartment());
	cvSchoolUpdate.setSchoolGraduationDate(cvSchoolDto.getSchoolGraduationDate());
	cvSchoolUpdate.setSchoolName(cvSchoolDto.getSchoolName());
	cvSchoolUpdate.setSchoolType(cvSchoolDto.getSchoolType());
	cvSchoolDao.save(cvSchoolUpdate);
	return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
	this.cvSchoolDao.deleteById(id);
	return new SuccessResult();
	}

	@Override
	public DataResult<CvSchool> getById(int id) {
		CvSchool cvSchool = cvSchoolDao.findById(id);
		return new SuccessDataResult<CvSchool>(cvSchool);
	}

//	@Override
//	public DataResult<List<CvSchool>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByCandidateId(id), "Success");
//	}
//
//	@Override
//	public DataResult<List<CvSchool>> getAllByCandidateIdOrderBySchoolGraduationDateDesc(int id) {
//		return new SuccessDataResult<List<CvSchool>>(
//				this.cvSchoolDao.getAllByCandidateIdOrderBySchoolGraduationDateDesc(id), "Success");
//	}
//
//	@Override
//	public Result add(CvSchool cvSchool) {
//		this.cvSchoolDao.save(cvSchool);
//		return new SuccessResult("Success");
//	}
//
//	@Override
//	public Result update(CvSchool cvSchool) {
//		return null;
//	}
//
//	@Override
//	public Result delete(CvSchool cvSchool) {
//		return null;
//	}
//
//	@Override
//	public Result addAll(List<CvSchool> cvSchools) {
//		this.cvSchoolDao.saveAll(cvSchools);
//		return new SuccessResult("Success");
//	}

}
