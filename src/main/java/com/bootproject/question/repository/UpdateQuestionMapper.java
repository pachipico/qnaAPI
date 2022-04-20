package com.bootproject.question.repository;

import org.apache.ibatis.annotations.Mapper;

import com.bootproject.question.domain.LikeQuestionDTO;
import com.bootproject.question.domain.Question;

@Mapper
public interface UpdateQuestionMapper {
	
	int insertQuestion(Question question);
	int updateQuestion(Question question);
	int likeQuestion(LikeQuestionDTO lqdto);
	int deleteQuestion(Long id);
}
