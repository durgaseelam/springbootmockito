package com.apex.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.user.dao.UserRepo;
import com.apex.user.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public List<User> findAll(){
		List<User> users=userRepo.findAll();
		System.out.println("getting data from DB "+users);
		return users;
	}

	public Optional<User> findOne(int id){
		Optional<User> user=userRepo.findById(id);
		System.out.println("getting user from DB "+user);
		return user;
	}

	public User save(User user){
		user=userRepo.save(user);
		System.out.println("saving data to DB "+user);
		return user;
	}

	public void delete(User user){
		userRepo.delete(user);
		System.out.println("deleting data from DB "+user);
		
	}
}
