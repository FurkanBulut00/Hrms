package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertSchedule;

public interface JobAdvertScheduleService {
	DataResult<List<JobAdvertSchedule>> getAll();
	DataResult<JobAdvertSchedule> getByJobAdvertScheduleId(int id);
}
