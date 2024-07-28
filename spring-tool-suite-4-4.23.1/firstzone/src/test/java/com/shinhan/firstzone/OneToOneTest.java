package com.shinhan.firstzone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.firstzone.repository3.PhoneVORepository;
import com.shinhan.firstzone.repository3.PhoneVORepository2;
import com.shinhan.firstzone.repository3.UserVO3Repository;
import com.shinhan.firstzone.repository3.UserVORepository;
import com.shinhan.firstzone.vo3.UserCellPhoneVO;
import com.shinhan.firstzone.vo3.UserCellPhoneVO2;
import com.shinhan.firstzone.vo3.UserCellPhoneVO3;
import com.shinhan.firstzone.vo3.UserVO;
import com.shinhan.firstzone.vo3.UserVO2;
import com.shinhan.firstzone.vo3.UserVO3;

@SpringBootTest
public class OneToOneTest {
	@Autowired
	UserVORepository uRepo;
	@Autowired
	PhoneVORepository pRepo;
	
	@Autowired
	PhoneVORepository2 pRepo2;
	
	
	@Autowired
	UserVO3Repository user3Repo;
	
	@Test
	void f3() {
		UserCellPhoneVO3 phone =  UserCellPhoneVO3.builder()
				.phoneNumber("12345")
				.model("aa")
				.build();
		
		UserVO3 user = UserVO3.builder()
				.userid("옥")
				.username("주현")
				.phone(phone)
				.build();
		
		phone.setUser3(user);
		
		user3Repo.save(user);
		
	}
	
	//@Test
	void f2() {
		UserVO2 user = UserVO2.builder()
				.userid("coffee")
				.username("우지")
				.build();
		
		UserCellPhoneVO2 phone = UserCellPhoneVO2.builder()
				.model("갤럭시")
				.phoneNumber("010-1234-5678")
				.user(user)
				.build();
		
		pRepo2.save(phone);
	}
	
	//@Test
	void f1() {
		UserCellPhoneVO phone = UserCellPhoneVO.builder()
				.phoneNumber("010-1234-5678")
				.model("갤럭시")
				.build();
		
		UserCellPhoneVO newphone = pRepo.save(phone);
		
		//phone이 먼저 저장된 후 user가 phone 이용
		UserVO userVO = UserVO.builder()
				.userid("zzilre")
				.username("jin")
				.phone(phone)
				.build();
	}
}
