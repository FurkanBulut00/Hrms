package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgramingTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgramingTechnologyDao;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;

@Service
public class ProgramingTechnologyManager implements ProgramingTechnologyService {

	private ProgramingTechnologyDao programingTechnologyDao;

	@Autowired
	public ProgramingTechnologyManager(ProgramingTechnologyDao programingTechnologyDao) {
		super();
		this.programingTechnologyDao = programingTechnologyDao;
	}

	@Override
	public DataResult<List<ProgramingTechnology>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<ProgramingTechnology>>(this.programingTechnologyDao.getAllByCandidateId(id),
				"Success");
	}

	@Override
	public Result add(ProgramingTechnology programingTechnology) {
			this.programingTechnologyDao.save(programingTechnology);
			return new SuccessResult("Success");
	}

	@Override
	public Result update(ProgramingTechnology programingTechnology) {
		return null;
	}

	@Override
	public Result delete(ProgramingTechnology programingTechnology) {
		return null;
	}

	@Override
	public Result addAll(List<ProgramingTechnology> programingTechnologies) {
		this.programingTechnologyDao.saveAll(programingTechnologies);
		return new SuccessResult("Success");
	}

}
