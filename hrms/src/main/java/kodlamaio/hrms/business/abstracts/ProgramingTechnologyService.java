package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;
import kodlamaio.hrms.entities.concretes.dto.ProgramingTechnologyDto;

public interface ProgramingTechnologyService {

	DataResult<List<ProgramingTechnology>> getAllByCv_CvId(int cvId);

	Result add(ProgramingTechnologyDto programingTechnologyDto);

	Result addAll(List<ProgramingTechnology> programingTechnologies);

	Result update(ProgramingTechnologyDto programingTechnologyDto,int id);

	Result delete(int id);
	
	DataResult<ProgramingTechnology> getById(int id);
}
