package com.shinhan.javaGrammer;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class residentDTO {
	private int resident_id;
	private String resident_name;
	private String resident_phone;
	private int resident_dong;
	private int resident_ho;
	private Date resident_date;
	private String resident_car;
	private String resident_fee;
	private int resident_owner;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("이름:").append(resident_name)
			   .append(" H.P:").append(resident_phone)
			   .append(" 호:").append(resident_ho)
			   .append(" 관리비:").append(resident_fee);
		return builder.toString();
	}
	
	
}
