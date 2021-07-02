package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvDetails","cvExperience","cvLanguage","cvLink","cvSchool","programingTechnology"})
@Table(name="cv")
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name="cv_name")
	private String cvName;
	
	@OneToMany(mappedBy="cv")
	private List<CvDetails> cvDetails;
	
	@OneToMany(mappedBy="cv")
	private List<CvExperience> cvExperience;
	
	@OneToMany(mappedBy="cv")
	private List<CvLanguage> cvLanguage;
	
	@OneToMany(mappedBy="cv")
	private List<CvLink> cvLink;
	
	@OneToMany(mappedBy="cv")
	private List<CvSchool> cvSchool;
	
	@OneToMany(mappedBy="cv")
	private List<ProgramingTechnology> programingTechnology;
	
	@ManyToOne(targetEntity = Candidate.class , fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Candidate candidate;

}
