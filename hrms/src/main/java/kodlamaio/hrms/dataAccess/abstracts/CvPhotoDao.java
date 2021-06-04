package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto,Integer> {

	
	List<CvPhoto> getAllByCandidateId(int id);
}
