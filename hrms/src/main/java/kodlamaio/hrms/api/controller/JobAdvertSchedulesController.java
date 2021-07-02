package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertScheduleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertSchedule;

@RestController
@RequestMapping("/api/jobAdvertSchedules")
@CrossOrigin
public class JobAdvertSchedulesController {

	
	private JobAdvertScheduleService jobAdvertScheduleService;

	@Autowired
	public JobAdvertSchedulesController(JobAdvertScheduleService jobAdvertScheduleService) {
		super();
		this.jobAdvertScheduleService = jobAdvertScheduleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertSchedule>> getAll(){
		return this.jobAdvertScheduleService.getAll();
	}
	
	
	
}
