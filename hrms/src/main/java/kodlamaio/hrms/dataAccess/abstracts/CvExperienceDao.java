	package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvExperienceDao extends JpaRepository<CvExperience,Integer> {
	
	List<CvExperience> getAllByCandidateId(int id);
	List<CvExperience> getAllByCandidateIdOrderByEndDateDesc(int id);
}
