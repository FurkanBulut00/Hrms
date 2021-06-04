package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;

public interface ProgramingTechnologyService {

	DataResult<List<ProgramingTechnology>> getAllByCandidateId(int id);

	Result add(ProgramingTechnology programingTechnology);

	Result addAll(List<ProgramingTechnology> programingTechnologies);

	Result update(ProgramingTechnology programingTechnology);

	Result delete(ProgramingTechnology programingTechnology);
}
