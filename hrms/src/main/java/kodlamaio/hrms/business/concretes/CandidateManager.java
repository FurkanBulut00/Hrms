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
import kodlamaio.hrms.business.abstracts.ProgramingTechnologyService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.adapters.concretes.FakeMernisManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.dto.CvDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserService userService;
	private UserDao userDao;
	private EmailValidationService emailValidationService;
	private FakeMernisService fakeMernisService;
	private CvDetailsService cvDetailsService;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	private ProgramingTechnologyService programingTechnologyService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserService userService, UserDao userDao,
			EmailValidationService emailValidationService, FakeMernisService fakeMernisService,CvDetailsService cvDetailsService,
			CvExperienceService cvExperienceService, CvLanguageService cvLanguageService, CvLinkService cvLinkService,
			CvPhotoService cvPhotoService, CvSchoolService cvSchoolService,
			ProgramingTechnologyService programingTechnologyService) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.userDao = userDao;
		this.emailValidationService = emailValidationService;
		this.cvDetailsService = cvDetailsService;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
		this.programingTechnologyService = programingTechnologyService;

		this.fakeMernisService = fakeMernisService;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if (runAllRules(candidate) != null)
			return runAllRules(candidate);

		if (!fakeMernisService.isNationalityIdValid(candidate.getNationalityId(), candidate.firstName,
				candidate.lastName, candidate.getBirthYear())) {
			return new ErrorResult("Gecersiz TCK numarası.");
		}

		if (!emailValidationService.isEmailValid(candidate.getEmail())) {
			return new ErrorResult(" Gecersiz email formatı ");
		}
		if (!emailValidationService.isEmailValidonClick(candidate.getEmail())) {

			return new ErrorResult(" Email dogrulama koduna tıklayınız. ");
		} else {
			this.candidateDao.save(candidate);

			return new SuccessResult("Candidate eklendi : ");
		}

	}

	private Result runAllRules(Candidate candidate) {
		if (fieldController(candidate) != null) {
			return fieldController(candidate);
		}
		if (emailController(candidate) != null) {
			return emailController(candidate);
		}
		if (nationalIdController(candidate) != null) {
			return nationalIdController(candidate);
		}
		return null;
	}

	private Result fieldController(Candidate candidate) {
		if (candidate.getFirstName() == null || candidate.getLastName() == null || candidate.getEmail() == null
				|| candidate.getBirthYear() == null || candidate.getPassword() == null
				|| candidate.getNationalityId() == null) {
			return new ErrorResult(" Lütfen alanlari doldurunuz. ");
		}

		if (candidate.getFirstName().equals("") || candidate.getLastName().equals("") || candidate.getEmail().equals("")
				|| candidate.getBirthYear().equals(""))
			return new ErrorResult(" Lütfen alanlari doldurunuz. ");

		return null;
	}

	private Result emailController(Candidate candidate) {
		if (userDao.findByEmail(candidate.getEmail()) != null) {
			return new ErrorResult("Bu email adresi kullanılmaktadır.");
		}
		return null;
	}

	private Result nationalIdController(Candidate candidate) {
		if (candidateDao.findByNationalityId(candidate.getNationalityId()) != null) {
			return new ErrorResult("Bu Tc kimlik no kullanılmaktadır. ");
		}
		return null;

	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get(), "Success");
	}

	@Override
	public DataResult<CvDto> getByCandidateId(int id) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.getById(id).getData());
		cvDto.setCvDetails(this.cvDetailsService.getAllByCandidateId(id).getData());
		cvDto.setCvExperience(this.cvExperienceService.getAllByCandidateIdOrderByEndDateDesc(id).getData());
		cvDto.setCvLanguage(this.cvLanguageService.getAllByCandidateId(id).getData());
		cvDto.setCvLink(this.cvLinkService.getAllByCandidateId(id).getData());
		cvDto.setCvPhoto(this.cvPhotoService.getAllByCandidateId(id).getData());
		cvDto.setCvSchool(this.cvSchoolService.getAllByCandidateIdOrderBySchoolGraduationDateDesc(id).getData());
		cvDto.setProgramingTechnology(this.programingTechnologyService.getAllByCandidateId(id).getData());
		return new SuccessDataResult<>(cvDto,"Success");
	}

}
