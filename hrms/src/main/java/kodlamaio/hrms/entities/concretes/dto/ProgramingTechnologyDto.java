package kodlamaio.hrms.entities.concretes.dto;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.ProgramingTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramingTechnologyDto {
	
	private String programingTechnology;
	
	private int cvId;

}
