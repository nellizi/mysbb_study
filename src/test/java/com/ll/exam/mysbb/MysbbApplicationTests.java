package com.ll.exam.mysbb;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import org.apache.catalina.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MysbbApplicationTests {

@Autowired
	private QuestionRepository questionRepository;
@Autowired
	private AnswerRepository answerRepository;
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
	Optional<Question>oq = questionRepository.findById(7);
	if(oq.isPresent()){
		Question q = oq.get();
		assertEquals("what is sbb",q.getSubject());
	}
}
@Test
	void testJpa4(){
	Question q = this.questionRepository.findBySubject("what is sbb");
	assertEquals(7,q.getId());
}
@Test
		void testJpa5(){
	Question q = this.questionRepository.findBySubjectAndContent("what is sbb","wanna know about sbb");
	assertEquals(1,q.getId());
}
@Test
	void testJpa6(){
	List<Question>qList = questionRepository.findBySubjectLike("what%");
	Question question = qList.get(0);
	assertEquals("what is sbb",question.getSubject());
}

@Test
	void testJpa7(){
	Optional <Question> oq = questionRepository.findById(7);
	assertTrue(oq.isPresent());
	Question question =oq.get();
	question.setSubject("modified title");
	questionRepository.save(question);
}
@Test
	void testJpa8(){
	assertEquals(2,questionRepository.count());
	Optional<Question> oq = questionRepository.findById(7);
	assertTrue(oq.isPresent());
	Question question =oq.get();
	questionRepository.delete(question);
	assertEquals(1,questionRepository.count());
}
@Test
	void testJpa9(){
	Optional<Question> oq= questionRepository.findById(8);
	assertTrue(oq.isPresent());
	Question question = oq.get();

	Answer answer = new Answer();
	answer.setContent("Yes it creates automatically");
	answer.setQuestion(question);
	answer.setCreateDate(LocalDateTime.now());
	answerRepository.save(answer);
}

@Test
	void testJpa10(){
	Optional<Answer> oa=answerRepository.findById(1);
	assertTrue(oa.isPresent());
	Answer answer = oa.get();

	assertEquals(8,answer.getQuestion().getId());
}
@Transactional
@Test
	void testJpa11(){
	Optional<Question> oq= questionRepository.findById(8);
	assertTrue(oq.isPresent());
Question question = oq.get();

List<Answer>answerList = question.getAnswerList();
assertEquals(1,answerList.size());
assertEquals("Yes it creates automatically", answerList.get(0).getContent());
}
}
