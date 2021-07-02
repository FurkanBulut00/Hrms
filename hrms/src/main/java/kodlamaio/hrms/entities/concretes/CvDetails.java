package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv_details")
public class CvDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_details_id")
	private int cvDetailsId;

//	@Column(name = "candidate_id")
//	private int candidateId;

	@Column(name = "details")
	private String details;	
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;

// 2	@Column(name = "is_active")
//	private boolean isActive=true;
//
// 2	 @Column(name = "last_update_date")
//	private LocalDate lastUpdateDate;
//
// 2	 @Column(name = "made_date")
//	private LocalDate madeDate;

//	@OneToMany(mappedBy = "cv")
//	private List<CvLanguage> cvLanguage;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvExperience> cvExperience;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvLink> cvLink;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvPhoto> cvPhoto;
//
//	@OneToMany(mappedBy = "cv")
//	private List<CvSchool> cvSchool;
//
//	@OneToMany(mappedBy = "cv")
//	private List<ProgramingTechnology> programingTechnology;
//
	
// 2	@ManyToOne
//	@JsonIgnore()
//	@JoinColumn(name = "user_id")
//	private Candidate candidate;

}
