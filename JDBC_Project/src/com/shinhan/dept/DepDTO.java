package com.shinhan.dept;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class DepDTO {
	private int DEPARTMENT_ID;
	private String DEPARTMENT_NAME;
	private int MANAGER_ID;
	private int LOCATION_ID;
}
