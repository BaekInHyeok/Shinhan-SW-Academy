package com.shinhan.firstzone;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.GuestBookRepository;
import com.shinhan.firstzone.service.GuestBookService;
import com.shinhan.firstzone.vo2.GuestBookDTO;
import com.shinhan.firstzone.vo2.GuestBookEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class GuestBookTest {

	@Autowired
	GuestBookRepository gRepo;
	
	
	@Autowired
	GuestBookService gService;
	
	
	@Test
	void f3() {
		List<GuestBookDTO> list = gService.readAll();
		list.forEach(dto->log.info(dto));
	}
	
	
	//@Test
	void f2() {
		//Entity->DTO
		GuestBookEntity entity = gRepo.findById(10L).orElse(null);
		if(entity!=null) {
			GuestBookDTO dto = GuestBookDTO.builder()
					.gno(entity.getGno())
					.title(entity.getTitle())
					.content(entity.getContent())
					.writer(entity.getWriter())
					.regDate(entity.getRegDate())
					.modDate(entity.getModDate())
					.build();
			log.info(dto);
		}
	}
	
	//@Test
	void f1() {
		//DTO->Entity
		GuestBookDTO dto = GuestBookDTO.builder()
				.gno(1L)
				.title("타이틀")
				.content("내용")
				.writer("작성자")
				.build();
		
		GuestBookEntity entity = GuestBookEntity.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		gRepo.save(entity);
		
	}
	
	
	
	//등록일이 null인 data조회 
	
	//@Test
	void select5() {
		gRepo.findByRegDateIsNull4(10L).forEach(entity->{
			log.info(entity);
		});
	}
	
	//@Test
	void select4() {
		gRepo.findByRegDateIsNull3().forEach(entity->{
			log.info(entity);
		});
	}
	
	//@Test
	void select3() {
		gRepo.findByRegDateIsNull2().forEach(entity->{
			log.info(entity);
		});
	}
	
	//@Test
	void select2() {
		gRepo.findByRegDateIsNull().forEach(entity->{
			log.info(entity);
		});
	}
	
	//@Test
	void select() {
		gRepo.findAll().forEach(entity->{
			log.info(entity);
		});
	}
	
	//@Test
	void insert() {
		IntStream.rangeClosed(16, 20).forEach(i->{
			GuestBookEntity entity = GuestBookEntity.builder()
					.title("화요일%%"+i)
					.content("배고파##")
					.writer("사용자"+i)
					.build(); 
			gRepo.save(entity);
		});
	}
}