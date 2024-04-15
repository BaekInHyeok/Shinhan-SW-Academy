package com.shinhan.day15;

import java.util.List;

//View : 사용자에게 어떻게 보여줄지 담당, JSP로 작성할 예정
public class EmpView {

	// 직원 목록 출력
	public static void print(List<EmpDTO> emplist, String title) {
		System.out.printf("=========%s=========\n", title);
		if (emplist.size() == 0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
		} else
			emplist.stream().forEach(emp -> System.out.println(emp));

	}

	// 직원 한 명 출력
	public static void print(EmpDTO emp, String title) {
		System.out.printf("=========%s=========\n", title);
		if (emp == null) {
			System.out.println("존재하지 않는 직원");
		} else {
			System.out.println("직원번호:" + emp.getEmployee_id());
			System.out.println("이름:" + emp.getFirst_name());
			System.out.println("성:" + emp.getLast_name());
			System.out.println("급여:" + emp.getSalary());
			System.out.println("이메일:" + emp.getEmail());
			System.out.println("입사일:" + emp.getHire_date());
			System.out.println("커미션:" + emp.getCommission_pct());
			System.out.println("매니저:" + emp.getManager_id());
			System.out.println("전화번호:" + emp.getPhone_number());
		}
	}

	// 단순 메시지 출력
	public static void print(String message) {
		System.out.printf("=========%s=========\n", message);
	}

}
