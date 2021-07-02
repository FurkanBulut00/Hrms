package kodlamaio.hrms.entities.concretes.dto;

import java.time.LocalDate;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.CvSchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvSchoolDto {
	
	private LocalDate schoolBeginDate;
	
	private LocalDate schoolGraduationDate;
	
	private String schoolType;
	
	private String schoolName;
	
	private String schoolDepartment;
	
	private int cvId;

}
