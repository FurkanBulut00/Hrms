package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
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
			System.out.println("İsim 2 haneden kücük olamaz");
			return false;
		}
		if(lastName.length()<2) {
			System.out.println("Soyisim 2 haneden kücük olamaz");
			return false;
		}
		if(birthYear.length()<4) {
			return false;
		}
		return true;
	}

	

}
