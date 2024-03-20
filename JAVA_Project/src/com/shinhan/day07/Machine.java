package com.shinhan.day07;

public interface Machine {
	void powerOn(String title);

}

//1.interface 구현 클래스 만들기 ... 만약에 만들어야 하는 경우가 많다면 좋지 않은 방법
//2.익명 구현 class...필요시마다 만들고 제거됨
//3.Interface 내에 메서드가 하나밖에 없다면 람다표현식을 이용한다.
