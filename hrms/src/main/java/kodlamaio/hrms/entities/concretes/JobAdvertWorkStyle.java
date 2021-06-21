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
@Table(name="job_advert_work_style")
//@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","jobAdvert"})
public class JobAdvertWorkStyle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advert_work_style_id")
	private int jobAdvertWorkStyleId;
	
	@Column(name="job_advert_work_style_name")
	private String jobAdvertWorkStyleName;
	
	@JsonIgnore //
	@OneToMany(mappedBy = "jobAdvertWorkStyle") 
	private List<JobAdvert> jobAdvert;

}
