package com.bootproject.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.user.domain.User;
import com.bootproject.user.domain.UserLoginResponseDto;
import com.bootproject.user.repository.SelectUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SelectServiceImpl implements SelectService {
	
	@Autowired
	private SelectUserMapper smapper;
	
	@Override
	public UserLoginResponseDto login(String email, String pwd) {

		return smapper.loginUser(email, pwd);
	}

	@Override
	public List<String> getRoles(String email) {
		
		return smapper.getRoles(email);
	}
	
	

}
