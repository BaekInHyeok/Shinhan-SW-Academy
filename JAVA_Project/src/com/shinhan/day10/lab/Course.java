package com.shinhan.day10.lab;

public class Course {

	//모두 가능
	public static void registerCourse1(Applicant<?> applicant){//? : 모든 타입을 수용함
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	
	//Student, HighStudent, MiddleStudent 가능
	public static void registerCourse2(Applicant<? extends Student> applicant){//? : 모든 타입을 수용함
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	
	//Student, Person, Object 가능
	public static void registerCourse3(Applicant<? super Student> applicant){//? : 모든 타입을 수용함
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	
	//Worker, Person, Object 가능
	public static void registerCourse4(Applicant<? super Worker> applicant){//? : 모든 타입을 수용함
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
}
