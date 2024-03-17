package com.shinhan.day04;

public class Employee {

	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		getTotalSalary();//여기서 미리 처리해놓으면 EmployeeExam에서 굳이 할 필요 없음
	}

	public void getTotalSalary() {
		if (title.equals("부장")) {//문자열 비교는 equals를 쓰는 게 좋다는 걸 잊지 말자!
			totalSalary = (int) (baseSalary * 1.25);
		} else if (title.equals("과장")) {
			totalSalary = (int) (baseSalary * 1.15);
		}else
			totalSalary = (int) (baseSalary * 1.05);
	}
	
	public void print() {
		System.out.println(this.title+" 직급의 "+this.name+"씨의"
				+ " 본봉은 "+this.baseSalary+"원이고"
				+ " 총급여는 "+this.totalSalary+"원입니다."
				);
	}

}
