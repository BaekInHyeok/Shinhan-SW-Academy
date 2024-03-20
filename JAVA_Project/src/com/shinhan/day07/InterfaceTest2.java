package com.shinhan.day07;

class Window{
	static interface Listener{
		void alert();
	}
	
	Listener listener;
	void setListener(Listener listener) {
		this.listener=listener;
	}
	void execute() {
		listener.alert();
	}
}
//내부 interface를 구현한 class를 만들어야 한다.
class MyListener1 implements Window.Listener{

	@Override
	public void alert() {
		// TODO Auto-generated method stub
		System.out.println("구현 class에서 메서드를 재정의한다.");
	}
	
}
public class InterfaceTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Window win = new Window();
		
		//1.구현class 이용(비슷한 구현 class를 계속 만들어야 한다는 문제)
		MyListener1 my1 = new MyListener1();
		win.setListener(my1);
		
		//2.익명 구현 class를 만든다.
		Window.Listener my2 = new Window.Listener() {
			
			@Override
			public void alert() {
				// TODO Auto-generated method stub
				System.out.println("익명 구현 class 만들기");
			}
		};
		
		win.setListener(my2);
		win.execute();
		
		//3.람다표현식(메서드가 하나 있을 때만 가능)
		win.setListener(()->System.out.println("람다 표현식을 사용"));

	}

}
