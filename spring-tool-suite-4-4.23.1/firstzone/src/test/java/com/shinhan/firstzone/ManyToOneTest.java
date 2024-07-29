package com.shinhan.firstzone;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shinhan.firstzone.repository.MemberRepository;
import com.shinhan.firstzone.repository.ProfileRepository;

@SpringBootTest
public class ManyToOneTest {

	@Autowired
	MemberRepository mRepo;
	
	@Autowired
	ProfileRepository pRepo;
	
	//Spring Securtiy는 비밀번호가 반드시 암호화 되어있어야 한다.
	@Autowired
	PasswordEncoder passEncoder;
	
	//@Test
	void makePass() {
		//user >> user4
		
		//manager >> user2
		
		//admin >> user1
		
		List<String> ids = new ArrayList<>();
		ids.add("user1");
		ids.add("user2");
		ids.add("user4");
		mRepo.findAllById(ids).forEach(member->{
			member.setMpassword(passEncoder.encode("1234"));
			mRepo.save(member);
		});
		
	}
	
	
	
}
