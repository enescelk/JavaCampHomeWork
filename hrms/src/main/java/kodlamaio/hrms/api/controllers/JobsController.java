package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPositions;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/jobs")
@NoArgsConstructor
public class JobsController {
	
	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getAll")
	public List<JobPositions> getAll(){
		return this.jobService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<JobPositions> add(@RequestBody JobPositions jobPositions){
		return this.jobService.add(jobPositions);
	}
}
