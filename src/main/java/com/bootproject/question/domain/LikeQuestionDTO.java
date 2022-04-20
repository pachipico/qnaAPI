package com.bootproject.question.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LikeQuestionDTO {
	private Long uid;
	private Long qid;
}
