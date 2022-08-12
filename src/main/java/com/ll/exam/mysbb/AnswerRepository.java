package com.ll.exam.mysbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {    //< 엔티티타입, 엔티티의 pk속성의 타입>
}
