	package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvExperienceDao extends JpaRepository<CvExperience,Integer> {
	
	List<CvExperience> getAllByCv_CvId(int cvId);
	List<CvExperience> getAllByCv_CvIdOrderByEndDateDesc(int id);
	CvExperience findById(int id);
}
