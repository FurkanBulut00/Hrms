package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgramingTechnology;

public interface ProgramingTechnologyDao extends JpaRepository<ProgramingTechnology,Integer> {

	List<ProgramingTechnology> getAllByCv_CvId(int cvId);
	ProgramingTechnology findById(int id);
}
