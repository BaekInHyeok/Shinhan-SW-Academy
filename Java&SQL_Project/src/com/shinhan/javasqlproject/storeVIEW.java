package com.shinhan.javasqlproject;

import java.util.List;

public class storeVIEW {

	// 상가 목록 출력
	public static void print(List<storeDTO> storelist, String title) {
		System.out.printf("---------%s---------\n", title);
		if (storelist.size() == 0) {
			System.out.println("조건에 맞는 상가 목록이 없습니다");
		} else
			storelist.stream().forEach(res -> System.out.println(res));

	}

	// 상가 정보 출력
	public static void print(storeDTO str, String title) {
		System.out.printf("---------------------------\n");
		System.out.printf("         <상점 정보>         \n");
		if (str == null) {
			System.out.println("검색하신 ID의 상점이 없습니다");
		} else {
			System.out.println("상점ID:" + str.getSTORE_ID());
			System.out.println("사업자번호:" + str.getSTORE_BUSSINESS_NUMBER());
			System.out.println("상점명:" + str.getSTORE_NAME());
			System.out.println("점주명:" + str.getSTORE_OWNER());
			System.out.println("전화번호:" + str.getSTORE_PHONE());
			System.out.println("업종:" + str.getSTORE_TYPE());
			System.out.println("개업일:" + str.getSTORE_STARTDATE());
			System.out.println("영업시작시각>>" + str.getSTORE_START_TIME());
			System.out.println("영업종료시각>>" + str.getSTORE_END_TIME());
		}
		System.out.printf("---------------------------\n");
	}

	// 단순 메시지 출력
	public static void print(String message) {
		System.out.printf("---------%s---------\n", message);
	}
}
