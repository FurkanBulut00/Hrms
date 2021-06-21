package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Data Listelendi");

	}

	@Override
	public Result add(Job job) {
		if(runAllRules(job)!=null) {
			return runAllRules(job);
		}
		this.jobDao.save(job);
		return new SuccessResult("İş eklendi");
	}
	private Result runAllRules(Job job) {
		if(fieldController(job)!=null) {
			return fieldController(job);
		}
		if(jobController(job)!=null) {
			return jobController(job);
		}
		
		return null;
	}
	
	
	private Result fieldController(Job job) {
		if(job.getJobTitle()==null) {
			return new ErrorResult("Lütfen alanları doldurunuz");
		}
		if(job.getJobTitle().equals("")) {
			return new ErrorResult("Lütfen alanları doldurunuz");
		}
		return null;
	}
	private Result jobController(Job job) {
		if(jobDao.findByJobId(job.getJobId())!=null) {
			return new ErrorResult("Bu iş pozisyonu halihazirda var.");
		}
		return null;
	}

	@Override
	public DataResult<Job> getByJobId(int id) {
	return new SuccessDataResult<Job>(this.jobDao.findByJobId(id));
	}

}
