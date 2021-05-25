package kodlamaio.hrms.core.utilities.results;

import kodlamaio.hrms.services.FakeMernis;

public class nationalIdValidation {
	public static boolean isRealPerson(String tcno) {
		FakeMernis mernis = new FakeMernis();
		return mernis.validate(tcno);
	}
}
