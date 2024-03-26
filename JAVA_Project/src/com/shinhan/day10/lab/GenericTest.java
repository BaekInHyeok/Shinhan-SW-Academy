package com.shinhan.day10.lab;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Applicant<Person> applicant1 = new Applicant<>(new Person());
		Applicant<Worker> applicant2 = new Applicant<>(new Worker());
		Applicant<Student> applicant3 = new Applicant<>(new Student());
		Applicant<HighStudent> applicant4 = new Applicant<>(new HighStudent());
		Applicant<MiddleStudent> applicant5 = new Applicant<>(new MiddleStudent());
		Course.registerCourse1(applicant1);
		Course.registerCourse1(applicant2);
		Course.registerCourse1(applicant3);
		Course.registerCourse1(applicant4);
		Course.registerCourse1(applicant5);
		
		//Extends Student
		//Course.registerCourse2(applicant1);
		//Course.registerCourse2(applicant2);
		Course.registerCourse2(applicant3);
		Course.registerCourse2(applicant4);
		Course.registerCourse2(applicant5);
		
		//Super Student
		Course.registerCourse3(applicant1);
		//Course.registerCourse3(applicant2);
		Course.registerCourse3(applicant3);
		//Course.registerCourse3(applicant4);
		//Course.registerCourse3(applicant5);
		
		//Super Worker
		Course.registerCourse4(applicant1);
		Course.registerCourse4(applicant2);
		//Course.registerCourse4(applicant3);
		//Course.registerCourse4(applicant4);
		//Course.registerCourse4(applicant5);
		
	}

}
