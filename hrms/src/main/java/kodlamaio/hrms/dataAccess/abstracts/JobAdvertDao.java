package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dto.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

		
	List<JobAdvert> findByIsActiveTrue();
	
	List<JobAdvert> findByIsActiveTrueOrderByPostedDate();
	
	@Query("From JobAdvert where isActive = true and company_id=:id")
	List<JobAdvert> getAllActiveJobAdvertByCompany(int id);
	
	//@Query("Select new kodlamaio.hrms.entities.concretes.dto.JobAdvertDto() From JobAdvert ja Inner Join ja.jobAdvert")
	//List<JobAdvertDto> findJobAdvertDtoDetails();
	
}
