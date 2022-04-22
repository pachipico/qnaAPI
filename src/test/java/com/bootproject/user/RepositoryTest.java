package com.bootproject.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootproject.user.domain.User;
import com.bootproject.user.repository.UserMapper;



@SpringBootTest
public class RepositoryTest {

	@Autowired
	private UserMapper mapper;

	
	@Test
	public void registerUserTest() {
		User user = new User();
		user.setEmail("123@123.com");
		user.setNickName("123123nickname");
		user.setLocation(1L);
		user.setPwd("123");
		mapper.insertUser(user);
	}
}
