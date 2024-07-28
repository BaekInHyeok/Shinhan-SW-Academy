package com.shinhan.firstzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shinhan.firstzone.vo2.GuestBookEntity;

public interface GuestBookRepository 
      extends CrudRepository<GuestBookEntity, Long>, 
              PagingAndSortingRepository<GuestBookEntity, Long>{

	//1.기본CRUD함수제공, PagingAndSorting가능
	//2.규칙에 맞는 함수 추가가능
	List<GuestBookEntity> findByRegDateIsNull();
	//3.@Query : JPQL
	//@Query("select b from GuestBookEntity b where b.regDate is null")
	@Query("select b from #{#entityName} b where b.regDate is null")
	List<GuestBookEntity> findByRegDateIsNull2();
	
	@Query("select b from #{#entityName} b where b.regDate is null and b.gno > ?1")
	List<GuestBookEntity> findByRegDateIsNull4(Long bno);
	
	//4.@Query, nativeQuery 가능 
	@Query(value = "select * from t_guestbook b where b.regDate is null", nativeQuery = true)
	List<GuestBookEntity> findByRegDateIsNull3();
}







