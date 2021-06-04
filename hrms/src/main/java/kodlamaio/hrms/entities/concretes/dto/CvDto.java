package kodlamaio.hrms.entities.concretes.dto;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvDetails;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.concretes.CvPhoto;
import kodlamaio.hrms.entities.concretes.CvSchool;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private Candidate candidate;
	private List<CvSchool> cvSchool ;
	private List<CvExperience>  cvExperience;
	private List<CvDetails> cvDetails;
	private List<CvLanguage> cvLanguage;
	private List<CvPhoto> cvPhoto;
	private List<CvLink> cvLink;
	private List<ProgramingTechnology> programingTechnology;
}
