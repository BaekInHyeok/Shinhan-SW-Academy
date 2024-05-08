package com.shinhan.javaGrammer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class wrkINworkDTO {
	private String WORKER_NAME;
	private int WORKER_AGE;
	private String WORKER_GENDER;
	private String WORKER_PHONE;
	private String FACILITY_NAME;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("이름:").append(WORKER_NAME)
			   .append(" 나이:").append(WORKER_AGE)
			   .append(" 성별:").append(WORKER_GENDER)
			   .append(" 전화번호:").append(WORKER_PHONE)
			   .append(" 담당시설:").append(FACILITY_NAME);
		return builder.toString();
	}

}
