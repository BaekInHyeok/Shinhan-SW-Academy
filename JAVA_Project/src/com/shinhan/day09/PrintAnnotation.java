package com.shinhan.day09;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target((ElementType.METHOD))//어디서 가져다 쓸 것인가 >> method(메서드)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {

	String value() default "-";
	int number() default 7;
	String subject1() default "자바1";
	String subject2() default "자바2";
	
}
