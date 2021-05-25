package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.JobPositions;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public List<JobPositions> getAll() {
		return this.jobDao.findAll();
	}

	@Override
	public DataResult<JobPositions> add(JobPositions jobPositions) {
		if(jobDao.findAllByPositionName(jobPositions.getPositionName()).stream().count() !=0) {
			return new ErrorDataResult<JobPositions>(null,"Boyler bir is pozisyonu kayitli");
		}
		return new SuccessDataResult<JobPositions>(this.jobDao.save(jobPositions),"Basariyla is pozisyonu eklendi");
	}
	
	
	
	
}