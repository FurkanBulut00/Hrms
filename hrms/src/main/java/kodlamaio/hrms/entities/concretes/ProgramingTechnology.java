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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="programing_technologies")
public class ProgramingTechnology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programing_id")
	private int programingId;
	
//	@Column(name="cv_id")
//	private int cvId;
//	
	@Column(name="programing_technology_name")
	private String programingTechnology;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
// 2	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore()
//	@JoinColumn(name="user_id")
//	private Candidate candidate;
}
