package com.shinhan.javaGrammer;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class facilityDTO {

	private int facility_id;
	private String facility_name;
	private Date facility_date;
	private String facility_type;
	private String facility_start_time;
	private String facility_end_time;
	private int facility_manager_id;
	
	
}
