package com.shinhan.firstzone.repository4;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo4.WebBoardEntity;

//interface 설계
//1.JpaRepository, QuerydslPredicateExecutor 상속 : 기본 제공 함수들을 사용 가능
//2.규칙이 있는 함수 정의 : findBy~~~
//3.JPQL
//4.Querydsl을 이용한 동적 sql 생성
public interface WebBoardRepository  extends JpaRepository<WebBoardEntity, Long>,
QuerydslPredicateExecutor<WebBoardEntity>{

	Page<WebBoardEntity> findByWriter(MemberEntity member, Pageable paging);
	//Page<WebBoardEntity> -> List<WebBoardDTO>
}
