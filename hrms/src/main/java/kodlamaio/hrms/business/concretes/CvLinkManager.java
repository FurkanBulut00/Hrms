package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLinkDao;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.concretes.dto.CvLinkDto;

@Service
public class CvLinkManager implements CvLinkService {

	private CvLinkDao cvLinkDao;
	private CvService cvService;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao,CvService cvService) {
		super();
		this.cvLinkDao = cvLinkDao;
		this.cvService= cvService;
	}

	@Override
	public DataResult<List<CvLink>> getAllByCv_CvId(int cvId) {
	return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCv_CvId(cvId));
	
	}

	@Override
	public Result add(CvLinkDto cvLinkDto) {
		CvLink cvLinkAdd = new CvLink();
		cvLinkAdd.setLinkName(cvLinkDto.getLinkName());
		cvLinkAdd.setCv(cvService.getById(cvLinkDto.getCvId()).getData());
		cvLinkDao.save(cvLinkAdd);
		return new SuccessResult();
	}

	@Override
	public Result addAll(List<CvLink> cvLinks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(CvLinkDto cvLinkDto, int id) {
	CvLink cvLinkUpdate = cvLinkDao.getOne(id);
	cvLinkUpdate.setLinkName(cvLinkDto.getLinkName());
	cvLinkDao.save(cvLinkUpdate);
	return new SuccessResult();
	
	}

	@Override
	public Result delete(int id) {
	this.cvLinkDao.deleteById(id);
	return new SuccessResult();
	}

	@Override
	public DataResult<CvLink> getById(int id) {
	CvLink cvLink = cvLinkDao.findById(id);
	return new SuccessDataResult<CvLink>(cvLink);
	}

//	@Override
//	public DataResult<List<CvLink>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCandidateId(id),"Success");
//	}
//
//	@Override
//	public Result add(CvLink cvLink) {
//		this.cvLinkDao.save(cvLink);
//		return new SuccessResult("Success");
//	}
//
//	@Override
//	public Result update(CvLink cvLink) {
//		return null;
//	}
//
//	@Override
//	public Result delete(CvLink cvLink) {
//		return null;
//	}
//
//	@Override
//	public Result addAll(List<CvLink> cvLinks) {
//		this.cvLinkDao.saveAll(cvLinks);
//		return new SuccessResult("Success");
//	}

}
