package com.shinhan.day15;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//DTO(Data Transfer Object)
//JavaBeans 기술에서 이용(JSP, String, Mybatis는 javabeans 기술을 이용한다)

@Getter@Setter@ToString
public class EmpDTO {

	// Ctrl+Shift+Y >> 소문자로 만들기
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
}
