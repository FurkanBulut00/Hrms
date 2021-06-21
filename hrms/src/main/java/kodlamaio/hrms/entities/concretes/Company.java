package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="companies")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="company_id")
@EqualsAndHashCode(callSuper = true)
//@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","jobAdvert"})
public class Company extends User {
	
	
	@Column(name="company_name")
	private  String companyName;
	
	@Column(name="web_site")
	private  String webSite;
	
	@Column(name="phone_number")
	private  String phoneNumber;
	
	@JsonIgnore //
	@OneToMany(mappedBy = "company")
	private List<JobAdvert> jobAdvert;

	
	
}
