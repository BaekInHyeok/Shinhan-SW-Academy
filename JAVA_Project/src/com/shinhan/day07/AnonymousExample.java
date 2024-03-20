package com.shinhan.day07;

interface Vehicle{
	public void run();
}

class Annonymous{
	
	//1.익명구현 클래스를 필드로
	Vehicle field=new Vehicle() {
		
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
			
		}
	};
	Vehicle field2 = ()->System.out.println("자전거가 달립니다.");
	
	void method1() {
		Vehicle localVar=new Vehicle() {
			//2.익명 구현 class를 지역변수로 사용
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
				
			}
		};
		Vehicle localVar2 = ()->System.out.println("자전거가 달립니다.");
		localVar.run();
		localVar2.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}


public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Annonymous anony = new Annonymous();
		anony.field.run();
		anony.method1();
		//3.익명구현class를 parameter로 사용
		anony.method2(new Vehicle() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("트럭이 달립니다.");
			}
			
		});
		
		anony.method2(()->System.out.println("트럭이 달립니다."));

	}

}
