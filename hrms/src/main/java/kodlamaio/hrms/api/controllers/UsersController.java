package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.entities.concretes.User;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/users")
@NoArgsConstructor
public class UsersController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<User> getAll(){
		return this.userService.getAll();
	}
	
}
