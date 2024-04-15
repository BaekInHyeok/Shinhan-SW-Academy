package com.shinhan.javasqlproject;

import java.util.List;

public class workerVIEW {

	// 전체 근로자 목록 출력
	public static void print(List<workerDTO> workerlist, String title) {
		System.out.printf("---------%s---------\n", title);
		if (workerlist.size() == 0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
		} else
			workerlist.stream().forEach(wrk -> System.out.println(wrk));
	}

	// 근로자 정보 출력
	public static void print(workerDTO wkr, String title) {
		System.out.printf("---------------------------\n");
		System.out.printf("         <근로자 정보>         \n");
		if (wkr == null) {
			System.out.println("검색하신 ID로 등록된 근로자가 없습니다");
		} else {
			System.out.println("근로자ID:" + wkr.getWORKER_ID());
			System.out.println("근로자명:" + wkr.getWORKER_NAME());
			System.out.println("나이:" + wkr.getWORKER_AGE());
			System.out.println("H.P:" + wkr.getWORKER_PHONE());
			System.out.println("근무시작일:" + wkr.getWORKER_HIREDATE());
			System.out.println("담당시설ID:" + wkr.getWORKER_WORKPLACE_ID());
			System.out.println("급여:" + wkr.getWORKER_SALARY());
		}
		System.out.printf("---------------------------\n");

	}
	
	//업무명을 입력하여 해당 업무의 근무자들 목록 출력
	public static void print(List<wrkINworkDTO> byWork) {
		System.out.printf("---------해당 업무의 근로자 목록---------\n");
		if (byWork.size() == 0) {
			System.out.println("해당 업무에 등록된 근로자가 없습니다");
		} else
			byWork.stream().forEach(wrk -> System.out.println(wrk));
	}

	// 단순 메시지 출력
	public static void print(String message) {
		System.out.printf("---------%s---------\n", message);
	}

	

	
}
