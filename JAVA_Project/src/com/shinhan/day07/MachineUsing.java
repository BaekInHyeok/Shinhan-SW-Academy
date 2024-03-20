//익명class

package com.shinhan.day07;

public class MachineUsing {

	//1.field
	Machine v1 = new Machine() {

		@Override
		public void powerOn(String title) {
			// TODO Auto-generated method stub
			System.out.println("2.익명구현class로 만든다.");
		}
		
	};
	public static void main(String[] args) {
		
		/*구현 class 사용*/
		Machine v3 = new MachineImpl();
		call(v3);
		
		//2.local 변수 
		Machine v2 = new Machine() {
			
			@Override
			public void powerOn(String title) {
				System.out.println("2.익명구현class로 만든다.");
				
			}
		};
		call(v2);
		
		//3.함수의 매개변수 이용
		call(new Machine() {
			
			@Override
			public void powerOn(String title) {
				System.out.println("2.익명구현class로 만든다.");
				
			}
		});
		
		call((s)->System.out.println(s+"람다표현식"));

	}
	private static void call(Machine machine) {
		// TODO Auto-generated method stub
		machine.powerOn("***");
	}

}
