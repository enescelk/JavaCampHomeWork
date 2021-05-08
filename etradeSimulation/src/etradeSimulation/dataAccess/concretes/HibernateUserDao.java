package etradeSimulation.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import etradeSimulation.dataAccess.abstracts.UserDao;
import etradeSimulation.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile silindi " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile guncellendi " + user.getFirstName() + " " + user.getLastName());
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

	@Override
	public User getByUserId(String email) {
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

}
