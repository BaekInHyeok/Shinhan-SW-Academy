package com.shinhan.javasqlproject;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class storeDTO {
	private int STORE_ID;
	private String STORE_BUSSINESS_NUMBER;
	private String STORE_NAME;
	private String STORE_OWNER;
	private String STORE_PHONE;
	private String STORE_TYPE;
	private Date STORE_STARTDATE;
	private String STORE_START_TIME;
	private String STORE_END_TIME;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("상점명:").append(STORE_NAME)
			   .append(" 점주명:").append(STORE_OWNER)
			   .append(" H.P:").append(STORE_PHONE)
			   .append(" 영업시작시각>>").append(STORE_START_TIME)
			   .append(" 영업종료시각>>").append(STORE_END_TIME);
		return builder.toString();
	}
	
	
	
	
}
