package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_adverts_id")
	private int jobAdvertId;
	
	@Column(name="job_description")
	private String jobDesription;
	
	@Column(name="salary_min")
	private int salaryMin;
	
	@Column(name="salary_max")
	private int salaryMax;
	
	@Column(name="open_position_count")
	private int openPositon;
	
	@Column(name="last_apply_date")
	private LocalDate lastApplyDate;
	
	@Column(name="posted_date")
	private LocalDate postedDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirm_request")
	private boolean confirmRequest;
	
	@ManyToOne()
	//@JsonIgnore 
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne()
	//@JsonIgnore 
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	//@JsonIgnore 
	@JoinColumn(name="company_id")
	private Company company;
	
	@ManyToOne()
	//@JsonIgnore 
	@JoinColumn(name="job_advert_schedule_id")
	private JobAdvertSchedule jobAdvertSchedule;
	
	@ManyToOne()
	//@JsonIgnore 
	@JoinColumn(name="job_advert_work_style_id")
	private JobAdvertWorkStyle jobAdvertWorkStyle;
	
}
