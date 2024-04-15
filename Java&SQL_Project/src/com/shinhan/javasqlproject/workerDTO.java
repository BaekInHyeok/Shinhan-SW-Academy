package com.shinhan.javasqlproject;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class workerDTO {
	private int WORKER_ID;
	private String WORKER_NAME;
	private int WORKER_AGE;
	private String WORKER_GENDER;
	private String WORKER_PHONE;
	private Date WORKER_HIREDATE;
	private int WORKER_WORKPLACE_ID;
	private String WORKER_WORK;
	private int WORKER_SALARY;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("근무자명:").append(WORKER_NAME)
			   .append(" 나이:").append(WORKER_AGE)
			   .append(" 성별:").append(WORKER_GENDER)
			   .append(" H.P:").append(WORKER_PHONE)
			   .append(" 근무시작일:").append(WORKER_HIREDATE)
			   .append(" 업무:").append(WORKER_WORK);
		return builder.toString();
	}
	
	
}
