package com.bootproject.question.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Question {
	private Long qid;
	private String title;
	private String content;
	private String regAt;
	private String modAt;
	private String userName;
	private Long writerId;
	private int location;
	private int reward;
}
