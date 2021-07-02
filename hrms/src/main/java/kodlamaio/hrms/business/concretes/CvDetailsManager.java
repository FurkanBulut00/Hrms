package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvDetailsService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDetailsDao;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.dto.CvDetailsDto;

@Service
public class CvDetailsManager implements CvDetailsService {

	private CvDetailsDao cvDetailsDao;
	private CvService cvService;

	@Autowired
	public CvDetailsManager(CvDetailsDao cvDetailsDao,CvService cvService) {
		super();
		this.cvDetailsDao = cvDetailsDao;
		this.cvService=cvService;
	}

//	@Override
//	public DataResult<List<CvDetails>> getAllByCandidateId(int id) {
//		return new SuccessDataResult<List<CvDetails>>(this.cvDetailsDao.getAllByCandidateId(id),"Success");
//	}

//	@Override
//	public Result add(CvDetails cvDetails) {
//		this.cvDetailsDao.save(cvDetails);
//		return new SuccessResult("Success");
//	}
//
//	@Override
//	public Result update(CvDetails cvDetails) {
//		return null;
//	}
//
//	@Override
//	public Result delete(CvDetails cvDetails) {
//		return null;
//	}

	@Override
	public Result addAll(List<CvDetails> cvDetails) {
		this.cvDetailsDao.saveAll(cvDetails);
		return new SuccessResult("Success");
	}

@Override
public DataResult<List<CvDetails>> getAllByCv_CvId(int cvId) {
	return new SuccessDataResult<List<CvDetails>>(this.cvDetailsDao.getAllByCv_CvId(cvId));
}

@Override
public Result add(CvDetailsDto cvDetailsDto) {
	CvDetails detailsAdd = new CvDetails();
	detailsAdd.setDetails(cvDetailsDto.getDetails());
	detailsAdd.setCv(cvService.getById(cvDetailsDto.getCvId()).getData());
	cvDetailsDao.save(detailsAdd);
	return new SuccessResult();
}

@Override
public Result update(CvDetailsDto cvDetailsDto, int id) {
	CvDetails detailsUpdate = cvDetailsDao.getOne(id);
	detailsUpdate.setDetails(cvDetailsDto.getDetails());
	cvDetailsDao.save(detailsUpdate);
	return new SuccessResult();
	
}

@Override
public Result delete(int id) {
		this.cvDetailsDao.deleteById(id);
	return new SuccessResult();
}

@Override
public DataResult<CvDetails> getById(int id) {
	CvDetails cvDetails = cvDetailsDao.findById(id);
	return new SuccessDataResult<CvDetails>(cvDetails);
}

}
