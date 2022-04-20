package com.bootproject.user.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserLoginResponseDto {
	private Long uid;
	private String email;
	private String nickName;
	private Long location;
	private int points;
	private String profileImg;
	private String lastLogin;
	private int grade;
	private List<String> role;
}
