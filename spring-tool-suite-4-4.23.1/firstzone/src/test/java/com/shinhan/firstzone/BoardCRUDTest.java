package com.shinhan.firstzone;

import static org.mockito.ArgumentMatchers.longThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.shinhan.firstzone.repository.BoardRepository;
import com.shinhan.firstzone.vo.BoardEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardCRUDTest {

	@Autowired
	BoardRepository bRepo;
	
	@Test
	void f9() {
		bRepo.jpqlTest1("요일","짝수").forEach(b->log.info(b));
		bRepo.jpqlTest2("요일","짝수").forEach(b->log.info(b));
		bRepo.jpqlTest3("요일","짝수").forEach(b->log.info(b));
		bRepo.jpqlTest4("요일","짝수").forEach(arr->log.info(Arrays.toString(arr)));
		bRepo.jpqlTest5("%요일%","%맑음%").forEach(b->log.info(b));
	}
	
	//@Test
	void f8() {
		//Pageable pageable = PageRequest.of(0, 5);
		//Pageable pageable = PageRequest.of(0, 5, Sort.by("bno").descending());
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC,new String[]{"writer","bno"});
		//order by writer desc, bno desc limit ?,?
		//Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC,"bno");
		
		Page<BoardEntity> result = bRepo.findAll(pageable);
		
		List<BoardEntity> blist = result.getContent();
		
		log.info("getNumber:"+result.getNumber());
		log.info("getSize:"+result.getSize());
		log.info("getTotalElements:"+result.getTotalElements());
		log.info("getTotalPages:"+result.getTotalPages());
		
		blist.forEach(board->log.info(board));
	}
	
	
	//@Test
	void f7() {
		Pageable pageable = PageRequest.of(0, 5);
		bRepo.findByBnoGreaterThanOrderByBnoDesc(10L, pageable).forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f6() {
		bRepo.findByContentLikeAndBnoBetweenOrderByBnoDesc("%짝%", 1L, 15L).forEach(b->{
			log.info(b);
		});
	}
	
	//@Test
	void f5() {
		bRepo.findByBnoBetween(10L, 15L).forEach(b->{
			log.info(b);
		});
	}
	
	
	//@Test
	void f1() {
		bRepo.findByWriter("user1").forEach(b->{
			log.info(b);
		});
	}
	
	//건수 확인
	//@Test
	void boardCount() {
		Long cnt = bRepo.count();
		log.info(cnt+"건");
	}
	
	//삭제
	//@Test
	void delete() {
		bRepo.deleteById(2L);
		bRepo.findById(2L).ifPresentOrElse(b->{
			log.info(b);
		}, ()->{
			log.info("Not Found");
		});
	}
	
	//수정
	//@Test
	void update() {
		bRepo.findById(1L).ifPresent(board->{
			log.info("before:"+board);
			board.setContent("~~~수정~~~");
			board.setTitle("springboot");
			board.setWriter("manager");
			
			BoardEntity updateBoard = bRepo.save(board);
			log.info("after:"+updateBoard);
		});
	}
	
	//@Test
	void select() {
		bRepo.findAll().forEach(board->{
			log.info(board);
		});
	}
	
//	@Test
//	void insert() {
//		IntStream.rangeClosed(11, 20).forEach(i->{
//			BoardEntity entity = BoardEntity.builder()
//					.title("토요일")
//					.content("맑음."+(i%2==0?"짝수":"홀수"))
//					.writer("user"+i%5)
//					.build();
//			bRepo.save(entity);
//		});
//	}
}
