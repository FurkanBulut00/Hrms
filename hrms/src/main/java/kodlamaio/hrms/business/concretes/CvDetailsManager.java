package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvDetailsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDetailsDao;
import kodlamaio.hrms.entities.concretes.CvDetails;

@Service
public class CvDetailsManager implements CvDetailsService {

	private CvDetailsDao cvDetailsDao;

	@Autowired
	public CvDetailsManager(CvDetailsDao cvDetailsDao) {
		super();
		this.cvDetailsDao = cvDetailsDao;
	}

	@Override
	public DataResult<List<CvDetails>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvDetails>>(this.cvDetailsDao.getAllByCandidateId(id),"Success");
	}

	@Override
	public Result add(CvDetails cvDetails) {
		this.cvDetailsDao.save(cvDetails);
		return new SuccessResult("Success");
	}

	@Override
	public Result update(CvDetails cvDetails) {
		return null;
	}

	@Override
	public Result delete(CvDetails cvDetails) {
		return null;
	}

	@Override
	public Result addAll(List<CvDetails> cvDetails) {
		this.cvDetailsDao.saveAll(cvDetails);
		return new SuccessResult("Success");
	}

}
