package com.education.controller;

import com.education.domain.User;
import com.education.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/", produces = "application/json")
public class UserController {

	@Autowired
	private IUserService iUserService;


	@GetMapping("/simple/{id}")
	public User findUserById(@PathVariable Long id) {
		return this.iUserService.findUserById(id);
	}

	@GetMapping("/simple/list")
	public List<User> findUserList() {
		return this.iUserService.findAllUsers();
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}

	/**
	 * 添加一个student,使用postMapping接收post请求
	 * <p>
	 * http://localhost:8310/simple/addUser?username=user11&age=11&balance=11
	 *
	 * @return
	 */
	@PostMapping("/simple/addUser")
	public User addUser(@RequestParam(value = "username", required = false) String username) {
		User user = new User();

		user.setUsername(username);

		int result = iUserService.insertUser(user);
		if (result > 0) {
			return user;
		}

		return user;
	}
}
