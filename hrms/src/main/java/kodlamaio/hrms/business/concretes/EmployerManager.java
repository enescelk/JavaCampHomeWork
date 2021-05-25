package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.EmailVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserService userService;
	private EmailVerificationService emailVerificationService;
	
	public EmployerManager(EmployerDao employerDao, UserService userService, EmailVerificationService emailVerificationService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailVerificationService = emailVerificationService;
	}
	
	@Override
	public DataResult<Employer> add(Employer employer) {
		if(!companyNameChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"Sirket adi doldurmak zorunludur.");
		}
		else if(!webSiteChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"WebSitet adresi doldurmak zorunludur.");
		}
		else if(!isRealEmployer(employer)) {
			return new ErrorDataResult<Employer>(null,"Gecersiz email Adresi.");
		}
		else if(!passwordNullChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"Sifre bilgisi doldurmak zorunludur.");
		}
		else if(!isRealPhoneNumber(employer)) {
			return new ErrorDataResult<Employer>(null,"Telefon Numarası Geçersiz.");
		}
		else if(!isEmailAlreadyRegistered(employer)) {
			return new ErrorDataResult<Employer>(null,"Email zaten kayıtlı.");
		}
		User savedUser = this.userService.add(employer);
		this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"Is veren Hesaba eklendi, Dogrulama kodu gonderildi ID: "+ employer.getId());
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}
	
	
	// Buisness Code
	
	private boolean companyNameChecker(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return false;
		}
		return true;
	}
	
	private boolean webSiteChecker(Employer employer) {
		if(employer.getWebSites().isBlank() || employer.getWebSites() == null) {
			return false;
		}
		return true;
	}
	
	private boolean isRealEmployer(Employer employer) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     else if(!employer.getEmail().contains(employer.getWebSites())) {
	    	return false; 
	     }
	     return true;
	     
	}

	private boolean passwordNullChecker(Employer employer) {
		if(employer.getPassword().isBlank() || employer.getPassword() == null) {
			return false;
		}
		return true;
	}
	

	private boolean isRealPhoneNumber(Employer employer) {
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		/*
		 * ÖRNEK TELEFON NUMARALARI
		 * String[] validPhoneNumbers 
      = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125", 
      "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
		 */
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if(!matcher.matches()) {
			return false;
		}
		return true;
		
	}

	private boolean isEmailAlreadyRegistered(Employer employer) {
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return false;
		}
		return true;
	}
}
