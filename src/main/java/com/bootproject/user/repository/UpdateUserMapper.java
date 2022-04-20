package com.bootproject.user.repository;

import org.apache.ibatis.annotations.Mapper;

import com.bootproject.user.domain.User;


@Mapper
public interface UpdateUserMapper {
	
	int insertUser(User user);
	int insertAuthInit(String email);
	int insertAuthManager(String email);
	int insertAuthAdmin(String email);
	int updateUserNickname(User user);
	int updateUserLocation(User user);
	int updateUserProfileImg(User user);
	int updateUserLastLogin(User user);
	int updateUserGrade(User user);
	int updateUserPoints(Long id, int points);
	
	int deleteUser(Long id);
}
