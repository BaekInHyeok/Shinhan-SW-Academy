package com.shinhan.day05;

public class PlayBird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duck duck = new Duck(2,15);
		Sparrow sparrow = new Sparrow(2,10);
		duck.setName("꽥꽥이");
		sparrow.setName("짹짹");

		duck.fly();
		sparrow.sing();
		
		System.out.println(duck.toString());
		System.out.println(sparrow.toString());
		
	}

}
