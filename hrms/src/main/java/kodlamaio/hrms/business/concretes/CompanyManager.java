package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.adapters.abstracts.EmployeeValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CompanyManager implements CompanyService {
	
	private CompanyDao companyDao;
	private UserService userService;
	private EmailValidationService emailValidationService;
	private EmployeeValidationService employeeValidationService;

	@Autowired
	public CompanyManager(CompanyDao companyDao,UserService userService,EmailValidationService emailValidationService,EmployeeValidationService employeeValidationService) {
		super();
		this.companyDao = companyDao;
		this.userService=userService;
		this.emailValidationService=emailValidationService;
		this.employeeValidationService=employeeValidationService;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"Şirket listesi ");
	}

	@Override
	public Result add(Company company) {
		if(runAllRules(company)!=null) {
			return runAllRules(company);
		}
	/*
	 * 
	 * 	User user = new User(company.getId(),company.getEmail(),company.getPassword());
		
		Company companyRegister= new Company(user.getId(),user.getEmail(),user.getPassword(),company.getCompanyName(),company.getWebSite(),company.getPhoneNumber());
	 * 
	 * 
	 * 
	 */
		if(!emailValidationService.isEmailValid(company.getEmail())) {
			return new ErrorResult(" Gecersiz email formatı ");
		}
		if(!emailValidationService.isEmailValidonClick(company.getEmail())) {
			return new ErrorResult(" Email dogrulama koduna tıklayınız. ");
		}
		if(!employeeValidationService.isValidateByEmployee(company)) {
			return new ErrorResult("Calısan tarafından onaylanmadınız");
		}
		else {
			this.companyDao.save(company);
			return new SuccessResult("Company eklendi ");
		}
		
	}
	
	public Result runAllRules(Company company) {
		if(fieldController(company)!=null) {
			return fieldController(company);
		}
		if(emailController(company)!=null) {
			return emailController(company);
		}
		if(isEmailandWebSiteDomainSame(company)!=null) {
			return isEmailandWebSiteDomainSame(company);
		}
		return null;
	}
	
	private Result fieldController(Company company) {
		if(company.getCompanyName()==null || company.getWebSite()==null || company.getEmail()==null || company.getPhoneNumber()==null || company.getPassword()==null) {
			return new ErrorResult("Lütfen alanlari doldurunuz.");
		}if(company.getCompanyName().equals("")||company.getWebSite().equals("")||company.getEmail().equals("")||company.getPhoneNumber().equals("")||company.getPassword().equals("")) {
			return new ErrorResult("Lütfen alanlari doldurunuz.");
		}
		return null;
	}
	private Result emailController(Company company) {
		if(userService.getByEmail(company.getEmail()).getData()!=null) {
			return new ErrorResult("Bu email kullanılmaktadır");
		}
		return null;
	}
	private Result isEmailandWebSiteDomainSame(Company company) {
		String email = company.getEmail();
		String[] emailSplit = email.split("@");
		if(!emailSplit[1].equals(company.getWebSite())) {
			return new ErrorResult("E-posta ile web domaininiz ayni olmalidir");
		}
		return null;
	}

	@Override
	public DataResult<Company> getByCompanyId(int id) {
		return new SuccessDataResult<Company>(this.companyDao.findById(id));
		
	}
		
	
}
