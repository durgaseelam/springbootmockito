package com.apex.user.contoller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apex.user.dao.UserRepo;
import com.apex.user.model.User;
import com.apex.user.service.UserService;
import com.apex.user.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/test")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(path = "/users", produces = { "application/json" })
	public List<User> getUsers() {

		return userService.findAll();
	}

	@GetMapping(path = "/user/{id}", produces = { "application/json" })
	public Optional<User> getUser(int id) {

		return userService.findOne(id);
	}

	@PutMapping(path = "/user", consumes = { "application/json" })
	public User updateUser(@Valid @RequestBody User user) {
		userService.save(user);
		return user;
	}
}
