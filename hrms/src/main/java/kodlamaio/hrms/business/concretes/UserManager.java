package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserManager implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public User add(User user) {
		return userDao.save(user);
	}

}
