package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.ProgramingTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgramingTechnologyDao;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;
import kodlamaio.hrms.entities.concretes.dto.ProgramingTechnologyDto;

@Service
public class ProgramingTechnologyManager implements ProgramingTechnologyService {

	private ProgramingTechnologyDao programingTechnologyDao;
	private CvService cvService;

	@Autowired
	public ProgramingTechnologyManager(ProgramingTechnologyDao programingTechnologyDao,CvService cvService) {
		super();
		this.programingTechnologyDao = programingTechnologyDao;
		this.cvService=cvService;
	}

	@Override
	public DataResult<List<ProgramingTechnology>> getAllByCv_CvId(int cvId) {
		return new SuccessDataResult<List<ProgramingTechnology>>(this.programingTechnologyDao.getAllByCv_CvId(cvId));
		
	}

	@Override
	public Result add(ProgramingTechnologyDto programingTechnologyDto) {
		ProgramingTechnology programingTechnologyAdd = new ProgramingTechnology();
		programingTechnologyAdd.setProgramingTechnology(programingTechnologyDto.getProgramingTechnology());
		programingTechnologyAdd.setCv(cvService.getById(programingTechnologyDto.getCvId()).getData());
		programingTechnologyDao.save(programingTechnologyAdd);
		return new SuccessResult();
	}

	@Override
	public Result addAll(List<ProgramingTechnology> programingTechnologies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(ProgramingTechnologyDto programingTechnologyDto, int id) {
		ProgramingTechnology programingTechnologyUpdate = programingTechnologyDao.getOne(id);
		programingTechnologyUpdate.setProgramingTechnology(programingTechnologyDto.getProgramingTechnology());
		programingTechnologyDao.save(programingTechnologyUpdate);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		this.programingTechnologyDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<ProgramingTechnology> getById(int id) {
		ProgramingTechnology programingTechnology = programingTechnologyDao.findById(id);
		return new SuccessDataResult<ProgramingTechnology>(programingTechnology);
	}

//	@Override
//	public DataResult<List<ProgramingTechnology>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<ProgramingTechnology>>(this.programingTechnologyDao.getAllByCandidateId(id),
//				"Success");
//	}
//
//	@Override
//	public Result add(ProgramingTechnology programingTechnology) {
//			this.programingTechnologyDao.save(programingTechnology);
//			return new SuccessResult("Success");
//	}
//
//	@Override
//	public Result update(ProgramingTechnology programingTechnology) {
//		return null;
//	}
//
//	@Override
//	public Result delete(ProgramingTechnology programingTechnology) {
//		return null;
//	}
//
//	@Override
//	public Result addAll(List<ProgramingTechnology> programingTechnologies) {
//		this.programingTechnologyDao.saveAll(programingTechnologies);
//		return new SuccessResult("Success");
//	}

}
