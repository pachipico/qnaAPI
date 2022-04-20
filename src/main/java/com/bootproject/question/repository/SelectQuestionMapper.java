package com.bootproject.question.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import com.bootproject.question.domain.Question;

@Mapper

public interface SelectQuestionMapper {
	List<Question> selectQuestionList(int page, Long location,String field, String query);
	Question selectOneQuestion(Long qid);
	
}
