package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv,Integer> {
	
	Cv findById(int id);
	List<Cv> getAllBycvId(int id);
	List<Cv> getAllByCandidateId(int id);

}
