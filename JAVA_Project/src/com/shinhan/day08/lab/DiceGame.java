package com.shinhan.day08.lab;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
		System.out.println();

		int result2 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);
		System.out.println();

	}

	int countSameEye(int n) {
		// 구현
		int count = 0;
		try {
			if (n < 0)
				throw new IllegalArgumentException();

			Dice d1 = new Dice(8);
			Dice d2 = new Dice(8);

			for (int i = 1; i <= n; i++) {
				int su1 = d1.play();
				int su2 = d2.play();

				System.out.println(su1 + " :: " + su2);

				if (su1 == su2)
					count++;

			}

		} catch (IllegalArgumentException e) {
			System.out.println("던지는 횟수는 음수가 될 수 없습니다.");
			e.printStackTrace();
			return 0;
		} finally {
			System.out.println("반드시 수행");
		}

		return count;
	}
}
