package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertWorkStyle;

public interface JobAdvertWorkStyleDao extends JpaRepository<JobAdvertWorkStyle,Integer> {
	JobAdvertWorkStyle findByJobAdvertWorkStyleId(int id);

}
