package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvDetailsService;
import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.business.abstracts.CvPhotoService;
import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.ProgramingTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.dto.CvAddDto;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CandidateService candidateService;
	
	@Autowired
	public CvManager(CvDao cvDao, CandidateService candidateService) {
		super();
		this.cvDao = cvDao;
		this.candidateService = candidateService;
	}

	@Override
	public Result add(CvAddDto cvAddDto) {
		Cv cvAdd = new Cv();
		cvAdd.setCvName(cvAddDto.getCvName());
		cvAdd.setCandidate(candidateService.getById(cvAddDto.getId()).getData());
		cvDao.save(cvAdd);
		return new SuccessResult();
	}

	@Override
	public DataResult<Cv> getById(int id) {
		Cv cv = cvDao.findById(id);
		return new SuccessDataResult<Cv>(cv);
	}

	@Override
	public DataResult<List<Cv>> getAllBycvId(int id) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getAllBycvId(id));
		
	}

	@Override
	public DataResult<List<Cv>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getAllByCandidateId(id));
	}
	
	
	



//	@Override
//	public Result add(CvDto cvDto, int id) {
//		
//	Candidate candidate = candidateService.getById(id).getData();
//	cvDto.setCandidate(candidate);
	
//	cvDto.getCvDetails().forEach(cvDetails -> cvDetails.setCandidate(candidate));
//	cvDetailsService.addAll(cvDto.getCvDetails());
//	
//	cvDto.getCvExperience().forEach(cvExperince -> cvExperince.setCandidate(candidate));
//	cvExperienceService.addAll(cvDto.getCvExperience());
//	
//	cvDto.getCvLanguage().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
//	cvLanguageService.addAll(cvDto.getCvLanguage());
//	
//	cvDto.getCvLink().forEach(cvLink -> cvLink.setCandidate(candidate));
//	cvLinkService.addAll(cvDto.getCvLink());
//	
//	cvDto.getCvPhoto().forEach(cvPhoto -> cvPhoto.setCandidate(candidate));
//	cvPhotoService.addAll(cvDto.getCvPhoto());
//	
//	cvDto.getCvSchool().forEach(cvSchool -> cvSchool.setCandidate(candidate));
//	cvSchoolService.addAll(cvDto.getCvSchool());
//	
//	cvDto.getProgramingTechnology().forEach(programingTechnology -> programingTechnology.setCandidate(candidate));
//	programingTechnologyService.addAll(cvDto.getProgramingTechnology());
		
//			return new SuccessResult("Cv eklendi");
//	}

	

}
