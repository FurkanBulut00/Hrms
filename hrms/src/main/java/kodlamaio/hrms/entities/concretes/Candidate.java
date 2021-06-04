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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "national_id")
	public String nationalityId;

	@Column(name = "birth_year")
	public String birthYear;

	public Candidate(int id, String email, String password, String firstName, String lastName, String nationalityId,
			String birthYear) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthYear = birthYear;
	}

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvLanguage> cvLanguage;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvExperience> cvExperience;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvLink> cvLink;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvPhoto> cvPhoto;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvSchool> cvSchool;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<ProgramingTechnology> programingTechnology;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CvDetails> cvDetails;

}
