package com.bootproject.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.user.domain.User;
import com.bootproject.user.domain.UserLoginResponseDto;
import com.bootproject.user.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public UserLoginResponseDto login(String email, String pwd) {

		return mapper.loginUser(email, pwd);
	}

	@Override
	public List<String> getRoles(String email) {

		return mapper.getRoles(email);
	}

	@Override
	public int register(User user) {

		if(user.getGrade() >= 100) {
			user.setRoles("ROLE_ADMIN");
		} else if (user.getGrade() >= 50) {
			user.setRoles("ROLE_MANAGER");
		} else {
			user.setRoles("ROLE_USER");
		}
		return mapper.insertUser(user);
	}

	@Override
	public int modifyNickname(User user) {

		return mapper.updateUserNickname(user);
	}

	@Override
	public int modifyLocation(User user) {

		return mapper.updateUserLocation(user);
	}

	@Override
	public int modifyProfileImg(User user) {

		return mapper.updateUserProfileImg(user);
	}

	@Override
	public int modifyGrade(User user) {

		return mapper.updateUserGrade(user);
	}

	@Override
	public int modifyPoints(User user, int points) {

		return mapper.updateUserPoints(user.getUid(), points);
	}

	@Override
	public int removeUser(Long id) {

		return mapper.deleteUser(id);
	}

	@Override
	public User findById(String email) {
		
		return mapper.selectUserByEmail(email);
	}

}
