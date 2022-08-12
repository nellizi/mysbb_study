package com.ll.exam.mysbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MysbbApplicationTests {

@Autowired
	private QuestionRepository questionRepository;

@Test
	void testJpa(){
	Question q1 = new Question();
	q1.setSubject("what is sbb");
	q1.setContent("wanna know about sbb");
	q1.setCreateDate(LocalDateTime.now());
	questionRepository.save(q1);

	Question q2 = new Question();
	q2.setSubject("Q about sbb model");
	q2.setContent("does id create automatically?");
	q2.setCreateDate(LocalDateTime.now());
	questionRepository.save(q2);
}



}
