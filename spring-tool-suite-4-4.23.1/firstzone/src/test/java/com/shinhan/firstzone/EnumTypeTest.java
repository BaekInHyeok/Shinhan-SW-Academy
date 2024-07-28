package com.shinhan.firstzone;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinhan.firstzone.repository3.EnumTypeVORepository;
import com.shinhan.firstzone.vo2.MemberRole;
import com.shinhan.firstzone.vo3.ENumTypeVO;

public class EnumTypeTest {

	@Autowired
	EnumTypeVORepository repo;
	
	//@Test
	void f1() {
		
		Set<MemberRole> mrole = new HashSet<>();
		mrole.add(MemberRole.ADMIN);
		mrole.add(MemberRole.USER);
		mrole.add(MemberRole.MANAGER);
		
		ENumTypeVO vo = ENumTypeVO.builder()
				.mid("1")
				.mname("현")
				.mpassword("1234")
				.mrole(mrole)
				.build();
		
		
	}
}
