package com.shinhan.firstzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository.MemberRepository;
import com.shinhan.firstzone.repository.PDSBoardRepository;
import com.shinhan.firstzone.repository.PDSFileRepository;
import com.shinhan.firstzone.repository.ProfileRepository;
import com.shinhan.firstzone.vo2.PDSBoardEntity;

import jakarta.transaction.Transactional;

@SpringBootTest
public class Review {

	//ManyToOne Test
	@Autowired
	MemberRepository mRepo;
	@Autowired
	ProfileRepository pRepo;
	
	//OneToMany Test
	@Autowired
	PDSBoardRepository boardRepo;
	@Autowired
	PDSFileRepository fileRepo;
	
	
	//OneToManyTest
	//@Transactional//lazy이더라도 같은 Tr
	
	//ManyToOne Test
	//select test
	
	
}
