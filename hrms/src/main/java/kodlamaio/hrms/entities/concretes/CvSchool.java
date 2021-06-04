package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="cv_schools")
public class CvSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_school_id")
	private int cvSchoolId;
	
//	@Column(name="cv_id")
//	private int cvId;
//	
//	@Column(name="school_id")
//	private int schoolId;
//	
	@Column(name="school_begining_date")
	private LocalDate schoolBeginDate;
	
	@Column(name="school_graduation_date")
	private LocalDate schoolGraduationDate;
	
	@Column(name="school_type")
	private String schoolType;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="school_department")
	private String schoolDepartment;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name="user_id")
	private Candidate candidate;
	
	
}
