package kodlamaio.hrms.core.adapters.concretes;

import kodlamaio.hrms.core.adapters.abstracts.EmployeeValidationService;
import kodlamaio.hrms.entities.concretes.Company;

public class EmployeeValidationManager implements EmployeeValidationService {

	@Override
	public boolean isValidateByEmployee(Company company) {
		System.out.println("Calısan tarafından onaylandınız.");
		return true;
	}

}
