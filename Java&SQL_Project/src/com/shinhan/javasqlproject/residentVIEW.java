package com.shinhan.javasqlproject;

import java.util.List;

public class residentVIEW {

	// 주민 목록 출력(동별 주민 목록 출력용)
	public static void print(List<residentDTO> residentlist, String title) {
		System.out.printf("---------%s---------\n", title);
		if (residentlist.size() == 0) {
			System.out.println("검색하신 아파트동에 거주자가 없습니다");
		} else
			residentlist.stream().forEach(res -> System.out.println(res));
	}

	// 주민 정보 출력
	public static void print(residentDTO res, String title) {
		System.out.printf("-------------------------\n");
		System.out.printf("        <주민 정보>         \n");
		if (res == null) {
			System.out.println("검색하신 ID로 등록된 주민이 없습니다");
		} else {
			System.out.println("주민ID:" + res.getResident_id());
			System.out.println("주민이름:" + res.getResident_name());
			System.out.println("주민H.P:" + res.getResident_phone());
			System.out.println("동:" + res.getResident_dong());
			System.out.println("호:" + res.getResident_ho());
			System.out.println("세대주여부:" + res.getResident_owner());
			System.out.println("보유차량 수:" + res.getResident_car());
			System.out.println("관리비:" + res.getResident_fee());
		}

		System.out.printf("-------------------------\n");
	}

	// 단순 메시지 출력
	public static void print(String message) {
		System.out.printf("---------%s---------\n", message);
		
	}

}
