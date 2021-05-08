package etradeSimulation.core.concretes;

import java.util.regex.Pattern;

import etradeSimulation.core.abstracts.EmailCheckService;

public class EmailCheckManager implements EmailCheckService{

	@Override
	public boolean isValid(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return Pattern.matches(regex, email);
	}

}
