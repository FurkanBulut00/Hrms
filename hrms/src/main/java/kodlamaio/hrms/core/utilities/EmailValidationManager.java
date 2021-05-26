package kodlamaio.hrms.core.utilities;

import java.util.regex.Pattern;

public class EmailValidationManager implements EmailValidationService {

	@Override
	public boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}

	@Override
	public boolean isEmailValidonClick(String email) {
		
		return true;
	}

}
