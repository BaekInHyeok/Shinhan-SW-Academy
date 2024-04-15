package com.shinhan.emp;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

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
			case 5->{
				System.out.print("조회 부서/직책/입사일(0000-00-00)/급여>>");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				Date hdate = DateUtil.getSQLDate(sc.next());
				int salary = sc.nextInt();
				
				EmpView.print(empService.selectByCondition(deptid, jobid, hdate, salary),"조건에 따른 직원 조회");
			}
			case 6->{
				EmpDTO emp =  insertMenu();
				int result = empService.empInsert(emp);
				EmpView.print(result>0?"입력성공":"입력실패");
			}
			case 7->{
				EmpDTO emp =  insertMenu();
				int result = empService.empUpdate(emp);
				EmpView.print(result>0?"수정성공":"수정실패");
			}
			case 8->{
				System.out.print("삭제할 직원의 번호>>");
				int empid = sc.nextInt();
				int result = empService.empDelete(empid);
				EmpView.print(result>0?"삭제성공":"삭제실패");
			}
			case 9->{
				System.out.println("조회할 직원번호>>");
				int empid=sc.nextInt();
				//모든 칼럼이면 DTO, 칼럼 일부만(이름,job,salary) 갖고 오면 Map
				Map<String,Object>emp= empService.empInfo(empid);
				EmpView.print(emp);
			}
			case 10->{
				System.out.println("조회할 직원번호>>");
				int empid=sc.nextInt();
				double result = empService.callFunction(empid);
				EmpView.print("직원의 보너스:"+result);
			}
			default->{}
			}
		}
		
		System.out.println("=============END=============");
	}

	private static EmpDTO insertMenu() {
		 System.out.print("EMPLOYEE_ID>>");
		 int empid = sc.nextInt();
		 
		 System.out.print("FIRST_NAME>>");
		 String fname = sc.next();
		 
		 System.out.print("LAST_NAME>>");
		 String lname = sc.next();

		 System.out.print("EMAIL>>");
		 String email = sc.next();

		 System.out.print("PHONE_NUMBER>>");
		 String phone = sc.next();

		 System.out.print("HIRE_DATE>>");
		 Date hdate = DateUtil.getSQLDate(sc.next());

		 System.out.print("JOB_ID>>");
		 String job_id = sc.next();

		 System.out.print("SALARY>>");
		 int sal = sc.nextInt();
		 
		 System.out.print("COMMISSION_PCT>>");
		 double comm = sc.nextDouble();
		 
		 System.out.print("MANAGER_ID>>");
		 int mid=sc.nextInt();
		 
		 System.out.print("DEPARTMENT_ID>>");
		 int deptid = sc.nextInt();
		 
		 EmpDTO emp = new EmpDTO();
		 emp.setCommission_pct(comm);
		 emp.setDepartment_id(deptid);
		 emp.setEmail(email);
		 emp.setEmployee_id(empid);
		 emp.setFirst_name(fname);
		 emp.setHire_date(hdate);
		 emp.setJob_id(job_id);
		 emp.setLast_name(lname);
		 emp.setManager_id(mid);
		 emp.setSalary(sal);
		 emp.setPhone_number(phone);
		 
		return emp;
	}

	private static int menuDisplay() {
		System.out.println("====================");
		System.out.println("1.모든 직원 정보 조회");
		System.out.println("2.특정 직원 정보 조회");
		System.out.println("3.특정 부서 직원 조회");
		System.out.println("4.특정 JOB 직원 조회");
		System.out.println("5.조건(부서/직책/입사일/급여) 기반 직원 조회");
		System.out.println("6.직원 입력");		
		System.out.println("7.직원 수정");		
		System.out.println("8.직원 삭제");		
		System.out.println("9.Procedure 호출(직원번호 IN > 정보 OUT");
		System.out.println("10.Function 호출(보너스)");
		System.out.println("0.종료");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		System.out.println("====================");
		
		return job;
	}
}
