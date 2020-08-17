package com.apex.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.apex.user.model.*;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByName(int id,String fName,String lName,String mName);
}
