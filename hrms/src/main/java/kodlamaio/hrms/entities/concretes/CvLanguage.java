package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv_languages")
@JsonIgnoreProperties ({"hibernateLazyInitializer","handler","cvLanguage"})
public class CvLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_language_id")
	private int cvLanguageId;
	
	@Min(value = 1)
	@Max(value = 5)
	@Column(name="language_level")
	private int languageLevel;
	
	@Column(name="language_name")
	private String languageName;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	
	
	//@Column(name="languages_id")
	//private int languageId;
	
//	@Column(name="language_level_id")
//	private int languageLevelId;
//	
//	@Column(name="cv_id")
//	private int cvId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="languages_id")
//	private Language language;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="languages_level_id")
//	private LanguageLevel languageLevel;
	
// 2	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore()
//	@JoinColumn(name="user_id")
//	private Candidate candidate;
//	
	
	
	
	
}
