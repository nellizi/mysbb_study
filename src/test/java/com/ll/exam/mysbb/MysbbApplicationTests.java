package com.ll.exam.mysbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

@Test
	void testJpa2(){
	List<Question> all = this.questionRepository.findAll();
	assertEquals(2,all.size());

	Question question = all.get(0);
	assertEquals("what is sbb",question.getSubject());
}

@Test
	void testJpa3(){
	Optional<Question>oq = questionRepository.findById(1);
	if(oq.isPresent()){
		Question q = oq.get();
		assertEquals("what is sbb",q.getSubject());
	}
}
@Test
	void testJpa4(){
	Question q = this.questionRepository.findBySubject("what is sbb");
	assertEquals(1,q.getId());
}
@Test
		void testJpa5(){
	Question q = this.questionRepository.findBySybjectAndContent("what is sbb","wanna know about sbb");
	assertEquals(1,q.getId());
}

}
