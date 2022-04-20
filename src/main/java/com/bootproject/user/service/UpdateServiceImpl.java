package com.bootproject.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.user.domain.User;
import com.bootproject.user.repository.SelectUserMapper;
import com.bootproject.user.repository.UpdateUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UpdateServiceImpl implements UpdateService {
	
	
	@Autowired
	private UpdateUserMapper umapper;
	
	@Autowired
	private SelectUserMapper smapper;
	
	@Override
	public int register(User user) {
		int res = umapper.insertUser(user);
		if(user.getGrade() >= 100) {
			umapper.insertAuthAdmin(user.getEmail());
		} else if(user.getGrade() >= 50) {
			umapper.insertAuthManager(user.getEmail());
		} else {
			umapper.insertAuthInit(user.getEmail());
		}
		return res;
	}

	@Override
	public int modifyNickname(User user) {
		if(smapper.validNicknameChk(user.getNickName()) != null) {
			return -1;
		}else {
			
			return 1;
		}
	}

	@Override
	public int modifyLocation(User user) {

		return umapper.updateUserLocation(user);
	}

	@Override
	public int modifyProfileImg(User user) {

		return umapper.updateUserProfileImg(user);
	}

	@Override
	public int modifyGrade(User user) {

		return umapper.updateUserGrade(user);
	}

	@Override
	public int modifyPoints(User user, int points) {

		return umapper.updateUserPoints(user.getUid(), points);
	}

	@Override
	public int removeUser(Long id) {

		return umapper.deleteUser(id);
	}

}
