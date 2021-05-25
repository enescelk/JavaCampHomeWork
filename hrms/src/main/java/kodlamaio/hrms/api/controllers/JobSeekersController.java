package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/jobSeekers")
@NoArgsConstructor
public class JobSeekersController {
	private JobSeekersService jobSeekersService;
	
	@Autowired
	public JobSeekersController(JobSeekersService jobSeekersService) {
		this.jobSeekersService = jobSeekersService;
	}
	
	@GetMapping("/getAll")
	public List<JobSeekers> getAll(){
		return this.jobSeekersService.getAll();
		
	}
	
	@PostMapping("/add")
	public DataResult<JobSeekers> add(@RequestBody JobSeekers jobSeekers){
		return this.jobSeekersService.add(jobSeekers);
	}
}
