package com.shinhan.day15;

public class EmpController {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		
		dao.selectAll().stream().forEach(emp->System.out.println(emp));
	}
}
