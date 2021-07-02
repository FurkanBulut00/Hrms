package kodlamaio.hrms.entities.concretes.dto;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.CvLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvLinkDto {
	
	private String linkName;
	
	private int cvId;

}
