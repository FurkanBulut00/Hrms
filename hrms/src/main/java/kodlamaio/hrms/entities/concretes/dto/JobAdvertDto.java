package kodlamaio.hrms.entities.concretes.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
	
	private String jobDesription;
	private int salaryMin;
	private int salaryMax;
	private int openPositon;
	private LocalDate lastApplyDate;
	private LocalDate postedDate;
	private boolean isActive;
	private int cityId;
	private int jobId;
	private int companyId;
	
	
	

}
