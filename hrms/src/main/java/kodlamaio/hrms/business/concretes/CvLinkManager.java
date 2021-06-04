package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLinkDao;
import kodlamaio.hrms.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService {

	private CvLinkDao cvLinkDao;
	private CandidateService candidateService;
	
	public CvLinkManager(CvLinkDao cvLinkDao,CandidateService candidateService) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public DataResult<List<CvLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCandidateId(id),"Success");
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Success");
	}

	@Override
	public Result update(CvLink cvLink) {
		return null;
	}

	@Override
	public Result delete(CvLink cvLink) {
		return null;
	}

	@Override
	public Result addAll(List<CvLink> cvLinks) {
		this.cvLinkDao.saveAll(cvLinks);
		return new SuccessResult("Success");
	}

}
