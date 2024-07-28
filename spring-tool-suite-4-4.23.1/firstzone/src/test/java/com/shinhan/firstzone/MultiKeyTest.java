package com.shinhan.firstzone;

import org.springframework.beans.factory.annotation.Autowired;

import com.shinhan.firstzone.repository3.MultiKeyARepository;
import com.shinhan.firstzone.repository3.MultiKeyBRepository;
import com.shinhan.firstzone.vo3.MultiKeyAClass;
import com.shinhan.firstzone.vo3.MultiKeyB;

public class MultiKeyTest {

	@Autowired
	MultiKeyARepository aRepo;
	@Autowired
	MultiKeyBRepository bRepo;
	
	void insertB() {
		MultiKeyB id = MultiKeyB.builder().id1(2).id2(3).build();
	
	
	}
	
	void insertA() {
		MultiKeyAClass a = MultiKeyAClass.builder()
				.id1(1)
				.id2(2)
				.productName("커피")
				.price(100)
				.build();
		
		aRepo.save(a);
	}
}
