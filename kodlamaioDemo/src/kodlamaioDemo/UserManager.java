package kodlamaioDemo;

public class UserManager {
	
	public void add(User user) {
		System.out.println("Kullanici eklendi "+ user.getFirstName() + " " + user.getLastName());
	}
	
	public void delete(User user) {
		System.out.println("Kullanici silindi "+ user.getFirstName() + " " + user.getLastName());
	}
	
	public void update(User user) {
		System.out.println("Kullanici guncellendi "+ user.getFirstName() + " " + user.getLastName());
	}

}
