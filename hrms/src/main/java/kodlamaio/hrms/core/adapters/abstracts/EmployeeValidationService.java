package kodlamaio.hrms.core.adapters.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Company;

@Service
public interface EmployeeValidationService {
 public boolean isValidateByEmployee(Company company);
}
