package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobDao extends JpaRepository<JobPositions, Integer>{
	
	List<JobPositions> findAllByPositionName(String positionName);
	
}
