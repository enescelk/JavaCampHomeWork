package etradeSimulation.buisness.concretes;

import java.util.List;

import etradeSimulation.buisness.abstracts.UserService;
import etradeSimulation.core.abstracts.EmailCheckService;
import etradeSimulation.core.abstracts.UserCheckService;
import etradeSimulation.dataAccess.abstracts.UserDao;
import etradeSimulation.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private EmailCheckService emailCheckService;
	private UserCheckService userCheckService;
	
	public UserManager(UserDao userDao, EmailCheckService emailCheckService, UserCheckService userCheckService) {
		this.userDao = userDao;
		this.emailCheckService = emailCheckService;
		this.userCheckService = userCheckService;
	}

	@Override
	public void login(String email, String password) {
		if(userDao.getByUserId(email)!=null) {
			User user = userDao.getByUserId(email);
			if(user.getPassword().equals(password)) {
				System.out.println("Giris yapildi");
			}else {
				System.out.println("Sifrenizi kontrol ediniz");
			}
		}else {
			System.out.println("Gecersiz e-posta");
		}
		
	}


	@Override
	public void register(User user) {
		if(userDao.getByUserId(user.getEmail()) !=null) {
			System.out.println("Bu email adresi kullaniliyor");
			return;
		}
		if(!emailCheckService.isValid(user.getEmail())) {
			System.out.println("Gecersiz email");
		}else if(userCheckService.checkName(user.getFirstName(), user.getLastName()) && userCheckService.checkPassword(user.getPassword())) {
			if(userCheckService.checkVerify()) {
				userDao.add(user);
			}else {
				System.out.println("E-posta adresinizi dogrulayin..");
			}
		}
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
