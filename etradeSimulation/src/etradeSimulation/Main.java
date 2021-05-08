package etradeSimulation;

import etradeSimulation.buisness.concretes.UserManager;
import etradeSimulation.core.abstracts.EmailCheckService;
import etradeSimulation.core.abstracts.UserCheckService;
import etradeSimulation.core.concretes.EmailCheckManager;
import etradeSimulation.core.concretes.UserCheckManager;
import etradeSimulation.dataAccess.abstracts.UserDao;
import etradeSimulation.dataAccess.concretes.HibernateUserDao;
import etradeSimulation.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Enes", "Celik", "enesc5741@gmail.com", "1234567");
		
		UserDao userDao = new HibernateUserDao();
		
		EmailCheckService emailCheckService = new EmailCheckManager();
		UserCheckService userCheckService = new UserCheckManager();
		
		UserManager userManager = new UserManager(userDao,emailCheckService,userCheckService);
		
		userManager.register(user1);
		System.out.println("--------------------------------------");
		userManager.login("enesc5741@gmail.com", "1234567");

	}

}
