package com.shinhan.day11.ch15;

import java.util.Objects;

public class Student {
	public int studentNum;
	public String name;

	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	// 여기에 코드를 작성하세요.

	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}

	@Override
	public boolean equals(Object obj) {
		Student st = (Student) obj;
		if (studentNum == st.studentNum)
			return true;
		return false;
	}

}
