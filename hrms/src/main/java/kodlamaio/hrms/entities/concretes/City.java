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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="city")
//@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","jobAdvert"})
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	@JsonIgnore //
	@OneToMany(mappedBy = "city") 
	private List<JobAdvert> jobAdvert;
}
