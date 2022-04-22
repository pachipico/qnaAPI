package com.bootproject.user.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private Long uid;
	private String email;
	private String nickName;
	private Long location;
	private String regAt;
	private int points;
	private String pwd;
	private String profile_img;
	private String lastLogin;
	private int grade;
	private String roles;

	public List<String> getRoleList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(roles.split(","));
		}
		return new ArrayList<>();
	}
}
