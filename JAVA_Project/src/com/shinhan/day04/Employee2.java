package com.shinhan.day04;

public class Employee2 {
	private String id;
	private String name;
	private int baseSalary;

	Employee2() {
	}

	Employee2(String id, String name, int baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getSalary(double bonus) {
		return this.baseSalary + this.baseSalary * bonus;
	}
	// 부모가 물려준 함수 재정의 : Override(덮어쓰기)
	// 이름 같고 매개변수 같고 return 같고, 접근제한자가 동일하거나 범위가 더 넓어져야 함

	@Override
	public String toString() {//toString은 원래 해쉬값을 가져옴
		// TODO Auto-generated method stub
		return "name"
				+"("
				+id
				+") 사원의 기본급은 "
				+baseSalary
				+"원 입니다.";
	}

//	public String toString() {
//		return (this.name+"("+this.id+") 사원의 기본급은 "+this.baseSalary+"원 입니다." );
//	}

}
