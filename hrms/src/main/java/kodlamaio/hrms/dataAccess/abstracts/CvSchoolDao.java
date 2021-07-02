package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool,Integer> {

	List<CvSchool> getAllByCv_CvId(int cvId);
	List<CvSchool> getAllByCv_CvIdOrderBySchoolGraduationDateDesc(int id);
	CvSchool findById(int id);
}
