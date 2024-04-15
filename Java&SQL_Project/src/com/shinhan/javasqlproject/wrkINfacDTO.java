package com.shinhan.javasqlproject;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class wrkINfacDTO {
	private String WORKER_NAME;
	private int WORKER_AGE;
	private String WORKER_GENDER;
	private String WORKER_PHONE;
	private String WORKER_WORK;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("근로자명:").append(WORKER_NAME)
			   .append(" 나이:").append(WORKER_AGE)
			   .append(" 성별:").append(WORKER_GENDER)
			   .append(" 전화번호:").append(WORKER_PHONE)
			   .append(" 담당업무:").append(WORKER_WORK);
		return builder.toString();
	}
	
	

}
