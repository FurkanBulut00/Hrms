package kodlamaio.hrms.core.utilities;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class FakeMernisManager implements FakeMernisService {

	@Override
	public boolean isNationalityIdValid(String nationalityId, String firstName, String lastName, String birthYear) {
		if(nationalityId.length()!=11) {
			System.out.println("TCKN 11 haneden kücük olamaz");
			return false;
		}
		if(firstName.length()<2) {
			return false;
		}
		if(birthYear.length()<4) {
			return false;
		}
		return true;
	}

	

}
