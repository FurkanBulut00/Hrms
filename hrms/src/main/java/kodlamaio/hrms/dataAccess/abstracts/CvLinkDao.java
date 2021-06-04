package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.CvLink;

public interface CvLinkDao extends JpaRepository<CvLink,Integer> {
		
	List<CvLink> getAllByCandidateId(int id);
}
