package com.shinhan.day15;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//사용자 요청 -> Controller -> Service
//사용자 Display <- View <-Controller	<- Service
public class EmpController {
	
	static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean isStop = false;
		EmpService empService = new EmpService();
		while(!isStop) {
			int selectJob = menuDisplay();
			
			switch(selectJob) {
			case 0->{isStop=true;}
			case 1->{
				List<EmpDTO> emplist = empService.selectAll();//비즈니스 로직을 수행한 결과 저장 리스트
				EmpView.print(emplist,"모든 직원 조회");
			}
			case 2->{
				System.out.print("조회할 직원번호>>");
				int empId = sc.nextInt();
				EmpView.print(empService.selectById(empId), "특정 직원 조회");
			}
			case 3->{
				System.out.print("조회할 부서번호>>");
				int eId = sc.nextInt();
				EmpView.print(empService.selectByDepId(eId), "특정 부서 직원 조회");
			}
			case 4->{
				System.out.print("조회할 JOB>>");
				String jobId = sc.next();
				EmpView.print(empService.selectByJobId(jobId), "특정 Job 직원 조회");
			}
			default->{}
			}
		}
		
		System.out.println("=============END=============");
	}

	private static int menuDisplay() {
		System.out.println("====================");
		System.out.println("1.모든 직원 정보 조회");
		System.out.println("2.특정 직원 정보 조회");
		System.out.println("3.특정 부서 직원 조회");
		System.out.println("4.특정 JOB 직원 조회");
		System.out.println("0.종료");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		System.out.println("====================");
		
		return job;
	}
}
