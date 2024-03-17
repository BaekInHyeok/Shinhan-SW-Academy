package com.shinhan.day04;

public class EmployeeExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee2 emp1 = new Employee2();
		
		emp1.setId("ee18s3");
		emp1.setName("김사원");
		emp1.setBaseSalary(10000000);
		
		double total=emp1.getSalary(0.25);
		
		System.out.println(emp1.toString());
		System.out.println(emp1);
		
		Book book = new Book("자바",30000);
		System.out.println(book);
		System.out.println(book.toString());
	}

}
