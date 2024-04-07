package com.shinhan.dept;

import java.util.List;

public class DepView {

	public static void print(DepDTO dep, String title) {
		System.out.printf("=========%s=========\n", title);
		if (dep == null) {
			System.out.println("존재하지 않는 부서");
		} else {
			System.out.println("부서ID:" + dep.getDEPARTMENT_ID());
			System.out.println("부서명:" + dep.getDEPARTMENT_NAME());
			System.out.println("메니저ID:" + dep.getMANAGER_ID());
			System.out.println("위치ID:" + dep.getLOCATION_ID());
		}
	}

	public static void print(List<DepDTO> deplist, String title) {
		System.out.printf("=========%s=========\n", title);
		if (deplist == null) {
			System.out.println("조건에 해당하는 데이터 없음");
		} else
			deplist.stream().forEach(dep -> System.out.println(dep));
	}

	// 단순 메시지 출력
	public static void print(String message) {
		System.out.printf("=========%s=========\n", message);
	}
}
