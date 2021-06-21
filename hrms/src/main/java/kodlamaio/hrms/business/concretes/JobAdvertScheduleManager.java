package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertScheduleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertScheduleDao;
import kodlamaio.hrms.entities.concretes.JobAdvertSchedule;

@Service
public class JobAdvertScheduleManager implements JobAdvertScheduleService {

	private JobAdvertScheduleDao jobAdvertScheduleDao;

	@Autowired
	public JobAdvertScheduleManager(JobAdvertScheduleDao jobAdvertScheduleDao) {
		super();
		this.jobAdvertScheduleDao = jobAdvertScheduleDao;
	}

	@Override
	public DataResult<List<JobAdvertSchedule>> getAll() {
		return new SuccessDataResult<List<JobAdvertSchedule>>(this.jobAdvertScheduleDao.findAll());
	}

	@Override
	public DataResult<JobAdvertSchedule> getByJobAdvertScheduleId(int id) {
		return new SuccessDataResult<JobAdvertSchedule>(this.jobAdvertScheduleDao.findByJobAdvertScheduleId(id));
	}

}
