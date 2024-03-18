package com.shinhan.day05;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		method3();
	}

	private static void method3() {
		// TODO Auto-generated method stub
		System.out.println("Car 대수:"+Car.carCount);
		System.out.println("Car 회사:"+Car.company);
		//배열 변수 선언 : 생성
		Car[] arr=new Car[5];
		//객체참조변수선언 + 생성, 사용
		arr[0] = new Car("A모델", 1000);
		arr[1] = new Car("B모델", 2000);
		arr[2] = new Car("C모델", 3000);
		arr[3] = new Car("D모델");
		arr[4] = new Car(4000);
		
		System.out.println("생성 후 Car 대수 "+ Car.carCount);
		
		for(Car cc:arr) {
			cc.carInfoPrint("=========================");
		}
	}

	private static void method1() {
		// TODO Auto-generated method stub
		
		//static은 class 소유이므로 object 생성과 관계 없음.
		System.out.println("Car 대수:"+Car.carCount);
		System.out.println("Car 회사:"+Car.company);
		Car.carInfoPrint2("******");
		int a=100;;
		System.out.println(a);
		method2();
	}
	private static void method2() {
		System.out.println();
	}

}
