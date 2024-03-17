package com.shinhan.day04;

public class EmployeeExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("이부장", "부장", 1500000);
		Employee e2 = new Employee("김과장", "과장", 1300000);
		Employee e3 = new Employee("최대리", "대리", 1200000);
		Employee e4 = new Employee("박사원", "사원", 1000000);

		// e1.getTotalSalary();
		e1.print();
		e2.print();
		e3.print();
		e4.print();

		Employee[] arr = new Employee[4];
		arr[0] = new Employee("이부장", "부장", 1500000);
		arr[1] = new Employee("김과장", "과장", 1300000);
		arr[2] = new Employee("최대리", "대리", 1200000);
		arr[3] = new Employee("박사원", "사원", 1000000);

		
		for(Employee emp:arr) {
			emp.print();
		}
	}

}
