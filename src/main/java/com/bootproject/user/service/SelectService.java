package com.bootproject.user.service;

import java.util.List;

import com.bootproject.user.domain.User;
import com.bootproject.user.domain.UserLoginResponseDto;

public interface SelectService {
	UserLoginResponseDto login(String email, String pwd);
	
	List<String> getRoles(String email);
}
