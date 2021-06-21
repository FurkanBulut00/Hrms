package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyService {
	DataResult<List<Company>> getAll();
	DataResult<Company> getByCompanyId(int id);
	
	Result add(Company company);
}
