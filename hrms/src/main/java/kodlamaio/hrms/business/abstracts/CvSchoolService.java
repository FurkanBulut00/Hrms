package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.concretes.dto.CvDto;
import kodlamaio.hrms.entities.concretes.dto.CvSchoolDto;

public interface CvSchoolService {

	DataResult<List<CvSchool>> getAllByCv_CvId(int cvId);

	DataResult<List<CvSchool>> getAllByCv_CvIdOrderBySchoolGraduationDateDesc(int cvId);

	Result add(CvSchoolDto cvSchoolDto);

	Result addAll(List<CvSchool> cvSchools);

	Result update(CvSchoolDto cvSchoolDto,int id);

	Result delete(int id);
	
	DataResult<CvSchool> getById(int id);
}
