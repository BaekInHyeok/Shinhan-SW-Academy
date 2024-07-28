package com.shinhan.firstzone.repository3;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.firstzone.vo3.FreeBoardEntity;

public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Long>,QuerydslPredicateExecutor<FreeBoardEntity>{

	@Query("select b.title, count(reply) from #{#entityName} b "
			+ " left outer join b.replies reply group by b.title order by 1 ")
	public List<Object[]> getFreeBoardReplyCount();
	
	Page<FreeBoardEntity> findByBnoBetween(Long bno1, Long bno2, Pageable pageable);
	
	@Query("select b from #{#entityName} b join b.replies ")
	List<FreeBoardEntity> findAllWithReplyUsingJoin();
	
	@Query("select b from #{#entityName} b join fetch b.replies ")
	List<FreeBoardEntity> findAllWithReplyUsingJoinFetch();
	
}
