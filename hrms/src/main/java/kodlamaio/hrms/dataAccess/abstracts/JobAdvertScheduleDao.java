package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertSchedule;

public interface JobAdvertScheduleDao extends JpaRepository<JobAdvertSchedule,Integer> {
	JobAdvertSchedule findByJobAdvertScheduleId(int id);
}
