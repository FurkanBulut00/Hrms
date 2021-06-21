package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertWorkStyleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertWorkStyleDao;
import kodlamaio.hrms.entities.concretes.JobAdvertWorkStyle;

@Service
public class JobAdvertWorkStyleManager implements JobAdvertWorkStyleService {

	private JobAdvertWorkStyleDao jobAdvertWorkStyleDao;

	@Autowired
	public JobAdvertWorkStyleManager(JobAdvertWorkStyleDao jobAdvertWorkStyleDao) {
		super();
		this.jobAdvertWorkStyleDao = jobAdvertWorkStyleDao;
	}

	@Override
	public DataResult<List<JobAdvertWorkStyle>> getAll() {
		return new SuccessDataResult<List<JobAdvertWorkStyle>>(this.jobAdvertWorkStyleDao.findAll());
	}

	@Override
	public DataResult<JobAdvertWorkStyle> getByJobAdvertWorkStyleId(int id) {
		return new SuccessDataResult<JobAdvertWorkStyle>(this.jobAdvertWorkStyleDao.findByJobAdvertWorkStyleId(id));
	}

}
