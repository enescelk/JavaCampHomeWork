package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobService {
	List<JobPositions> getAll();
	DataResult<JobPositions> add(JobPositions jobPositions);
}
