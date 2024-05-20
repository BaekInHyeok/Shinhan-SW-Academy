package org.firstzone.section6;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("myPhone2")
@Data
public class PhoneDTO {

	String model;
	String color;
}
