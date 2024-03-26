package com.shinhan.day10.thread;

//공유영역
public class BathRoom {

	//synchronized : 하나의 thread가 이 메서드를 수행 중이면 Lock을 검
	//다른 thread가 접근 불가, 하나의 thread가 메서드를 벗어나면 다른 대기 thread가 들어온다.
	synchronized void use(String name) {
		System.out.println("==========");
		System.out.println(name+"입장");
		System.out.println(name+"사용중");
		System.out.println(name+"퇴장");
		System.out.println("==========");

	}
	
}
