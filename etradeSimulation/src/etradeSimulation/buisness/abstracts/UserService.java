package etradeSimulation.buisness.abstracts;

import java.util.List;

import etradeSimulation.entities.concretes.User;

public interface UserService {
	
	void delete(User user);
	void login(String email,String password);
	void register(User user);
	User get(int id);
	List<User> getAll();
}
