package com.bootproject.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootproject.question.domain.LikeQuestionDTO;
import com.bootproject.question.domain.Question;
import com.bootproject.question.repository.UpdateQuestionMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private UpdateQuestionMapper umapper;
	
	@Test
	public void insertQuestionTest() {
		Question question = new Question();
		question.setTitle("title");
		question.setContent("content");
		question.setReward(10);
		question.setWriterId(0L);
		question.setLocation(1);
		umapper.insertQuestion(question);
	}
	
	@Test
	public void updateQuestionTest() {
		Question question = new Question();
		question.setQid(1L);
		question.setTitle("new title");
		question.setContent("new Content");
		question.setReward(100);
		umapper.updateQuestion(question);
	}
	
	@Test
	public void likeQuestionTest() {
		LikeQuestionDTO dto = new LikeQuestionDTO();
		dto.setQid(1L);
		dto.setUid(1L);
		umapper.likeQuestion(dto);
	}
}
