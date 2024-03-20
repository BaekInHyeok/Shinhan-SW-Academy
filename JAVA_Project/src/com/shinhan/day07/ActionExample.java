package com.shinhan.day07;

interface Action {
	public void work();
}

public class ActionExample {
	public static void main(String[] args) {
		Action action = new Action() {

			@Override
			public void work() {
				// TODO Auto-generated method stub
				System.out.println("복사를 합니다.");
			}
		};

		Action action2 = ()->System.out.println("복사를 합니다.");

		action.work();
		action2.work();
	}

}
