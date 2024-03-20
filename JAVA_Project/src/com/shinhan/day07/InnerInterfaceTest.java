package com.shinhan.day07;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.구현 class 이용
		OKButtonListener ok1 = new OKButtonListener();
		OKButtonListener2 ok2 = new OKButtonListener2();
		
		Button button = new Button();
		button.setListener(ok2);
		button.click();
		
		//익명 구현 class 만들기
		Button.ClickListener ok3 = new Button.ClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("익명 구현 class 만들기");
			}
		};
		
		button.setListener(ok3);
		button.click();
		
		//3.람다표현식(메서드가 하나 있을 때만 가능)
		button.setListener(()->System.out.println("람다 표현식 사용"));
		button.click();

	}

}
