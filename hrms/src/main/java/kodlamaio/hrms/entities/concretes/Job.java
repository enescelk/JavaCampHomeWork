package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobPositions")
public class Job {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="positionName")
	private String positionName;
	
	public Job() {}

	public Job(int id, String positionName) {
		super();
		this.id = id;
		this.positionName = positionName;
	}
}
