package com.bootproject.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bootproject.user.domain.User;
import com.bootproject.user.domain.UserLoginResponseDto;

@Mapper
public interface SelectUserMapper {

	UserLoginResponseDto loginUser(String email, String pwd);
	List<User> selectUserList();
	List<String> getRoles(String email);
	Long validNicknameChk(String nickName);
	Long validEmailChk(String nickName);
}
