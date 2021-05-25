package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<Employer> add(Employer employer);
	List<Employer> getAll();
}