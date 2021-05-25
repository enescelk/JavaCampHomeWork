package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.nationalIdValidation;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.User;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class JobSeekersManager implements JobSeekersService{

	private JobSeekersDao jobSeekersDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;
	
	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, EmailVerificationService emailVerificationService, UserService userservice) {
		this.jobSeekersDao = jobSeekersDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userservice;
	}
	
	@Override
	public DataResult<JobSeekers> add(JobSeekers jobSeekers) {
		if(!firstNameChecker(jobSeekers)) {
			return new ErrorDataResult<JobSeekers>(null,"Lutfen adinizi giriniz !");
		}
		else if(!lastNameChecker(jobSeekers)) {
			return new ErrorDataResult<JobSeekers>(null,"Lutfen soyadinizi giriniz !");
		}
		else if(!nationalIdValidation.isRealPerson(jobSeekers.getNationalId())){
			return new ErrorDataResult<JobSeekers>(null,"Kimlik dogrulanamadi !");
		}
		else if(jobSeekers.getNationalId().isBlank()) {
			return new ErrorDataResult<JobSeekers>(null,"Tc Kimlik Alani bos birakilamaz !");
		}
		else if(!birthDateChecker(jobSeekers)) {
			return new ErrorDataResult<JobSeekers>(null,"Lutfen dogum tarihinizi giriniz !");
		}
		else if(!emailNullChecker(jobSeekers)) {
			return new ErrorDataResult<JobSeekers>(null,"Lutfen email alanini giriniz !");
		}
		else if(!isRealEmail(jobSeekers)) {
			return new ErrorDataResult<JobSeekers>(null,"Email adresiniz yalnis !");
		}
		else if(!passwordNullChecker(jobSeekers)) {
			return new ErrorDataResult<JobSeekers>(null,"Lutfen sifrenizi giriniz !");
		}
		else if(jobSeekersDao.findAllByEmail(jobSeekers.getEmail()).stream().count() != 0) {
			return new ErrorDataResult<JobSeekers>(null,"Email Zaten Kayitli");
		}
		else if(jobSeekersDao.findAllByNationalId(jobSeekers.getNationalId()).stream().count() != 0) {
			return new ErrorDataResult<JobSeekers>(null,"Tc numarasi Zaten kayitli");
		}
		User savedUser = this.userService.add(jobSeekers);
		this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
		return new SuccessDataResult<JobSeekers>(this.jobSeekersDao.save(jobSeekers),"Is arayan Hesabi eklendi, Dogrulama kodu gonderildi:"+jobSeekers.getId());
	}

	@Override
	public List<JobSeekers> getAll() {
		return this.jobSeekersDao.findAll();
	}
	
	
	// Business Codes
	
	private boolean firstNameChecker(JobSeekers jobSeekers) {
		if(jobSeekers.getFirstName().isBlank() || jobSeekers.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean lastNameChecker(JobSeekers jobSeekers) {
		if(jobSeekers.getLastName().isBlank() || jobSeekers.getLastName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean birthDateChecker(JobSeekers jobSeekers) {
		if(jobSeekers.getBirthOfDate().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean isRealEmail(JobSeekers jobSeekers) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(jobSeekers.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     return true;
	     
	}

	private boolean emailNullChecker(JobSeekers jobSeekers) {
		if(jobSeekers.getEmail().isBlank() || jobSeekers.getEmail().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean passwordNullChecker(JobSeekers jobSeekers) {
		if(jobSeekers.getPassword().isBlank() || jobSeekers.getPassword().equals(null)) {
			return false;
		}
		return true;
	}
}
