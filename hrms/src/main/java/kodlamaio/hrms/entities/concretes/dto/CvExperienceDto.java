package kodlamaio.hrms.entities.concretes.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperienceDto {
	
	private String otherCompany;
	
	private LocalDate beginingDate;
	
	private LocalDate endDate;
	
	private String cvExperienceName;
	
	private int cvId;

}
