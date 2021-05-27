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
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
@EqualsAndHashCode(callSuper = true)
public class Candidate extends User {

	
	@Column(name="first_name")
	public String firstName;
	
	
	@Column(name="last_name")
	public String lastName;
	
	
	@Column(name="national_id")
	public String nationalityId;
	
	@Column(name="birth_year")
	public String birthYear;

	
//.
	
	
}
