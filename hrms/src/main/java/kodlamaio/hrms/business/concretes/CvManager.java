package kodlamaio.hrms.business.concretes;

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
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

@Service
public class CvManager implements CvService {

	private CandidateService candidateService;
	private CvDetailsService cvDetailsService;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	private ProgramingTechnologyService programingTechnologyService;

	@Autowired
	public CvManager(CandidateService candidateService, CvDetailsService cvDetailsService,
			CvExperienceService cvExperienceService, CvLanguageService cvLanguageService, CvLinkService cvLinkService,
			CvPhotoService cvPhotoService, CvSchoolService cvSchoolService,
			ProgramingTechnologyService programingTechnologyService) {
		super();
		this.candidateService = candidateService;
		this.cvDetailsService = cvDetailsService;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
		this.programingTechnologyService = programingTechnologyService;
	}

	@Override
	public Result add(CvDto cvDto, int id) {
		
	Candidate candidate = candidateService.getById(id).getData();
	cvDto.setCandidate(candidate);
	
	cvDto.getCvDetails().forEach(cvDetails -> cvDetails.setCandidate(candidate));
	cvDetailsService.addAll(cvDto.getCvDetails());
	
	cvDto.getCvExperience().forEach(cvExperince -> cvExperince.setCandidate(candidate));
	cvExperienceService.addAll(cvDto.getCvExperience());
	
	cvDto.getCvLanguage().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
	cvLanguageService.addAll(cvDto.getCvLanguage());
	
	cvDto.getCvLink().forEach(cvLink -> cvLink.setCandidate(candidate));
	cvLinkService.addAll(cvDto.getCvLink());
	
	cvDto.getCvPhoto().forEach(cvPhoto -> cvPhoto.setCandidate(candidate));
	cvPhotoService.addAll(cvDto.getCvPhoto());
	
	cvDto.getCvSchool().forEach(cvSchool -> cvSchool.setCandidate(candidate));
	cvSchoolService.addAll(cvDto.getCvSchool());
	
	cvDto.getProgramingTechnology().forEach(programingTechnology -> programingTechnology.setCandidate(candidate));
	programingTechnologyService.addAll(cvDto.getProgramingTechnology());
		
			return new SuccessResult("Cv eklendi");
	}

}
