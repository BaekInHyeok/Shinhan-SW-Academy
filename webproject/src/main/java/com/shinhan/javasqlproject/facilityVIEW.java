package com.shinhan.javasqlproject;

import java.util.List;

public class facilityVIEW {

	// 전체 시설 목록 출력
	public static void print(List<facilityDTO> facilitylist, String title) {
		System.out.printf("---------%s---------\n", title);
		if (facilitylist.size() == 0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
		} else
			facilitylist.stream().forEach(wrk -> System.out.println(wrk));
	}

	// 시설 정보 출력
	public static void print(facwnameDTO fac) {
		System.out.printf("-------------------------\n");
		System.out.printf("        <시설 정보>         \n");
		if (fac == null) {
			System.out.println("검색하신 ID로 등록된 시설이 없습니다");
		} else {
			System.out.println("시설명:" + fac.getFacility_name());
			System.out.println("시설종류:" + fac.getFacility_type());
			System.out.println("운영시작시각>>" + fac.getFacility_start_time());
			System.out.println("운영종료시각>>" + fac.getFacility_end_time());
			System.out.println("시설관리자:"+fac.getWorker_name());
		}
		
		System.out.printf("-------------------------\n");
	}

	//시설 이름을 입력하여 해당 시설의 근무자들 목록을 출력
	public static void print(List<wrkINfacDTO> wrkINfaclist) {
		System.out.printf("---------해당 시설의 근로자 목록---------\n");
		if (wrkINfaclist.size() == 0) {
			System.out.println("시설에 등록된 근로자가 없습니다");
		} else
			wrkINfaclist.stream().forEach(wrkINfac -> System.out.println(wrkINfac));
	}

	// 단순 메시지 출력
	public static void print(String message) {
		System.out.printf("---------%s---------\n", message);
	}
}
