package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekers;
public interface JobSeekersService {
	DataResult<JobSeekers> add(JobSeekers jobSeekers);
	List<JobSeekers> getAll();
}
