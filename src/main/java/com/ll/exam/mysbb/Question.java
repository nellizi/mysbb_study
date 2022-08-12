package com.ll.exam.mysbb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
public class Question {
    @Id  //기본키로 지정. 중복값 불허
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gener~따로 값을 세팅하지 않아도 1씩 증가, strategy : 고유번호 생성, 독립적인 시퀀스 생성하여 번호 증가
    private Integer id;                                 // strategy 생략하면 진짜 걍 기준 없는 랜덤으로 독립적인 번호로 증가.


    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)  //질문 삭제시 답변도 삭제하기 위해 caascade 설정.
    private List<Answer>answerList;
}
