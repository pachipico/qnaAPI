package com.bootproject.user.service;

import com.bootproject.user.domain.User;

public interface UpdateService {
	int register(User user);
	int modifyNickname(User user);
	int modifyLocation(User user);
	int modifyProfileImg(User user);
	int modifyGrade(User user);
	int modifyPoints(User user, int points);
	int removeUser(Long id);

}
