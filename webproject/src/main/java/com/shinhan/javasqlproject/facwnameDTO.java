package com.shinhan.javasqlproject;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class facwnameDTO {

	private String facility_name;
	private String facility_type;
	private String facility_start_time;
	private String facility_end_time;
	private String worker_name;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("시설명:").append(facility_name)
			   .append(" 시설종류:").append(facility_type)
			   .append(" 운영시작시각:").append(facility_start_time)
			   .append(" 운영종료시각:").append(facility_end_time)
			   .append(" 시설관리자").append(worker_name);
		return builder.toString();
	}
	
	
}
