package com.shinhan.day06;

//Object는 최상위 class
class Parent2 extends Object {
	int score = 100;

	void show() {
		System.out.println("부모에서 score접근:"+score);
	}
	
	void show2() {
		System.out.println("부모에서 score접근:"+score);
	}
}

class Child2 extends Parent2 {

	//override(덮어쓰기) : 이름,매개변수,return타입,modifier 확인 필
	@Override
	protected void show() {
		System.out.println("자식에서 score접근:"+score);
	}
	
	//overloading(추가하기)
	void show2(String a) {
		show();//자신의 class에 재정의되어 있는 메서드 수행
		super.show2();//부모의 메서드 호출
		System.out.println("자식에서 score접근:"+score);
	}
	
	void print() {
		String scroe="A학점";
		System.out.println("자식이 score 접근:"+score); //>>A학점이 나옴
		show();
	}
	
	void f() {
		
	}
}

public class InheritenceTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child2 aa = new Child2();// object 생성, Parent2 생성, Child2 생성
		System.out.println(aa.score);
		aa.print();
		aa.show();
		aa.show2("hi");

	}

}
