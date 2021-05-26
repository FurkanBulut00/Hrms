package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
public class Company extends User {
	
	
	@Column(name="company_name")
	public String companyName;
	
	@Column(name="web_site")
	public String webSite;
	
	@Column(name="phone_number")
	public String phoneNumber;

	
	
}
