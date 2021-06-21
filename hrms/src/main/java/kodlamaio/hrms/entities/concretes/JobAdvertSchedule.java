package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advert_schedule")
//@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","jobAdvert"})
public class JobAdvertSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advert_schedule_id")
	private int jobAdvertScheduleId;
	
	@Column(name="job_advert_schedule_name")
	private String jobAdvertScheduleName;
	
	@JsonIgnore //
	@OneToMany(mappedBy = "jobAdvertSchedule") 
	private List<JobAdvert> jobAdvert;

}
