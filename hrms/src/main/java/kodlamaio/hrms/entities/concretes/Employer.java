package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employers")
public class Employer extends User{

	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "webSites")
	private String webSites;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
}
