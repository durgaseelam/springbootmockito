package com.apex.user;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import com.apex.user.contoller.UserController;
import com.apex.user.dao.UserRepo;
import com.apex.user.model.User;
import com.apex.user.service.UserService;

import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
class SprinbootMockitoApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	@Test
	public void getUsersTest() {
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User(12, "Test1", "lname1", "mname1"), new User(13, "Test2", "lname2", "mname2"),
						new User(14, "Test2", "lname2", "mname2"), new User(15, "Test2", "lname2", "mname2"))
				.collect(Collectors.toList()));
		assertEquals(4, userService.findAll().size());
	}

	@Test
	public void saveTest() {
		User user = new User(20, "Test11", "lname1", "mname1");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.save(user));
	}

	@Test
	public void deleteTest() {
		User user = new User(20, "Test11", "lname1", "mname1");
		userRepo.delete(user);
		verify(userRepo,times(1)).delete(user);
	}
	
	@Test
	public void updateUserTest() {
		User user = new User(21, "Test11", "lname1", "mname1");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.save(user));
	}


//	@Test
//	void contextLoads() {
//	}

}
