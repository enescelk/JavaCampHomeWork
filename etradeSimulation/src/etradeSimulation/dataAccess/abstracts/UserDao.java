package etradeSimulation.dataAccess.abstracts;

import java.util.List;

import etradeSimulation.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	void update(User user);
	User get(int id);
	User getByUserId(String email);
	List<User> getAll();
}
