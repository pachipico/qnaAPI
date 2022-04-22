package com.bootproject.user.service;

import java.util.List;

import com.bootproject.user.domain.User;
import com.bootproject.user.domain.UserLoginResponseDto;

import lombok.extern.slf4j.Slf4j;


public interface UserService {
	UserLoginResponseDto login(String email, String pwd);
	User findById(String email);
	
	List<String> getRoles(String email);
	
	int register(User user);
	int modifyNickname(User user);
	int modifyLocation(User user);
	int modifyProfileImg(User user);
	int modifyGrade(User user);
	int modifyPoints(User user, int points);
	int removeUser(Long id);

}
