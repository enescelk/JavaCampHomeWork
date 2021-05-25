package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "verificationStatus")
public class EmailVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "userId")
	private int userId;

	@Column(name = "code")
	private String code;
	
	@Column(name = "emailVerifaction")
	private boolean emailVerification;
	
	@Column(name = "systemVerification")
	private boolean systemVerification;
}