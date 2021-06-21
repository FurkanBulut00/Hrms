package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertWorkStyle;

public interface JobAdvertWorkStyleService {

	DataResult<List<JobAdvertWorkStyle>> getAll();
	DataResult <JobAdvertWorkStyle> getByJobAdvertWorkStyleId(int id);
}
