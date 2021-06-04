package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

public interface CvSchoolService {

	DataResult<List<CvSchool>> getAllByCandidateId(int id);

	DataResult<List<CvSchool>> getAllByCandidateIdOrderBySchoolGraduationDateDesc(int id);

	Result add(CvSchool cvSchool);

	Result addAll(List<CvSchool> cvSchools);

	Result update(CvSchool cvSchool);

	Result delete(CvSchool cvSchool);
}
