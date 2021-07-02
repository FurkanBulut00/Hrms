package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.concretes.dto.CvDto;
import kodlamaio.hrms.entities.concretes.dto.CvLinkDto;

public interface CvLinkService {
	
	DataResult<List<CvLink>> getAllByCv_CvId(int cvId);
	
	Result add(CvLinkDto cvLinkDto);
	
	Result addAll(List<CvLink> cvLinks);
	
	Result update(CvLinkDto cvLinkDto,int id);
	
	Result delete(int id);
	
	DataResult<CvLink> getById(int id);
}
