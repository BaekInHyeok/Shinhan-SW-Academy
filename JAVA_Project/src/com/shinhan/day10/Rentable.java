package com.shinhan.day10;

//타입 파라메터 영문자 대문자나 : ex) <A>
public interface Rentable<P> {

	void method1();
	P rent();
}
