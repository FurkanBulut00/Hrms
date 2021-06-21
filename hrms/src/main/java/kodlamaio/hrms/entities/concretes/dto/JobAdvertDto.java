package kodlamaio.hrms.entities.concretes.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private boolean isActive = false;
	@JsonIgnore
	private boolean isConfirmed = false;
	@JsonIgnore
	private boolean confirmRequest = true;
	private int cityId;
	private int jobId;
	private int companyId;
	private int jobAdvertScheduleId;
	private int jobAdvertWorkStyleId;
	
	
	

}
