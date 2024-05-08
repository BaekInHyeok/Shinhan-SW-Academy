package com.shinhan.job;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class JobDTO {

	 private String JOB_ID;
	 private String JOB_TITLE;
	 private int MIN_SALARY;
	 private int MAX_SALARY;
}
