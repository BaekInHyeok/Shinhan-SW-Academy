package com.shinhan.dept;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.shinhan.day15.EmpView;

public class DepController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean isStop = false;
		DepService depService = new DepService();
		while (!isStop) {
			int selectDep = menuDisplay();

			switch (selectDep) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<DepDTO> deplist = depService.selectAll();// 비즈니스 로직을 수행한 결과 저장 리스트
				DepView.print(deplist, "전체 부서 조회");
			}
			case 2 -> {
				System.out.print("조회할 부서ID>>");
				int depId = sc.nextInt();
				DepView.print(depService.selectById(depId), "특정 부서 조회");
			}
			case 3 -> {
				System.out.print("매니저ID>>");
				int mId = sc.nextInt();
				DepView.print(depService.selectByMId(mId), "매니저 ID로 부서 조회");
			}
			case 4 -> {
				DepDTO dep = insertMenu();
				int result = depService.depInsert(dep);
				DepView.print(result > 0 ? "입력성공" : "입력실패");
			}
			case 5 -> {
				DepDTO dep = insertMenu();
				int result = depService.depUpdate(dep);
				DepView.print(result > 0 ? "수정성공" : "수정실패");
			}
			case 6 -> {
				System.out.print("삭제할 직원의 번호>>");
				int depid = sc.nextInt();
				int result = depService.depDelete(depid);
				DepView.print(result > 0 ? "삭제성공" : "삭제실패");
			}
			default -> {
			}
			}
		}

		System.out.println("=============END=============");
	}

	private static DepDTO insertMenu() {
		System.out.print("DEPARTMENT_ID>>");
		int depId = sc.nextInt();

		System.out.print("DEPARTMENT_NAME>>");
		String depName = sc.next();

		System.out.print("MANAGER_ID>>");
		int mId = sc.nextInt();

		System.out.print("LOCATION_ID>>");
		int lId = sc.nextInt();
		
		DepDTO dep = new DepDTO();
		dep.setDEPARTMENT_ID(depId);
		dep.setDEPARTMENT_NAME(depName);
		dep.setLOCATION_ID(lId);
		dep.setMANAGER_ID(mId);
		
		return dep;
	}

	private static int menuDisplay() {
		System.out.println("====================");
		System.out.println("1.모든 부서 정보 조회");
		System.out.println("2.부서ID 기반 부서 조회");
		System.out.println("3.매니저 ID 기반 부서 조회");
		System.out.println("4.부서 추가");
		System.out.println("5.부서 수정");
		System.out.println("6.부서 삭제");
		System.out.println("0.종료");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		System.out.println("====================");

		return job;
	}
}
