package etradeSimulation.core.concretes;

import etradeSimulation.core.abstracts.UserCheckService;

public class UserCheckManager implements UserCheckService{

	@Override
	public boolean checkName(String firstName, String lastName) {
		if(firstName.length()< 2 || lastName.length() < 2) {
			System.out.println("FirstName ve LastName en az 2 karekterden olusmalidir.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		if(password.length() < 6 ) {
			System.out.println("Parola en az 6 karekter olmalidir.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkVerify() {
		System.out.println("Dogrulama e-postasi gönderildi..");

		System.out.println("E-posta dogrulandi.");
		return true;
	}

}
