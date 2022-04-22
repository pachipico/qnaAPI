package com.bootproject.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bootproject.user.domain.User;
import com.bootproject.user.domain.UserLoginResponseDto;

@Mapper
public interface UserMapper {

	
	UserLoginResponseDto loginUser(@Param("email") String email, @Param("pwd")String pwd);
	User getUserInfo(String email);
	List<User> selectUserList();
	List<String> getRoles(String email);
	Long validNicknameChk(String nickName);
	Long validEmailChk(String nickName);
	
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
	User selectUserByEmail(String email);
}
