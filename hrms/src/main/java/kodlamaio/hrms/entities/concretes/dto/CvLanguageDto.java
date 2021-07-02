package kodlamaio.hrms.entities.concretes.dto;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvLanguageDto {

	private int languageLevel;
	
	private String languageName;
	
	private int cvId;
}
