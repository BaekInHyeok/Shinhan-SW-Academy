package com.shinhan.day05;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		Account2[] accArr = new Account2[2];
		int index = 0;

		aa: while (true) {

			menuPrint();

			String cmd = scanner.nextLine();
			int i = 0;

			switch (cmd) {

			case "1":

				i = 0;

				while (accArr[i] != null) {
					i++;
				}
				
				

				if (index == accArr.length) {
					System.out.println("계좌 생성 상한 초과");
					break;
				} else {
					System.out.println("------");
					System.out.println("계좌생성");
					System.out.println("------");

					System.out.print("계좌번호:");
					String accNum = scanner.nextLine();

					System.out.print("계좌주:");
					String name = scanner.nextLine();

					System.out.print("초기입금액:");
					String bal1 = scanner.nextLine();
					int bal2 = Integer.valueOf(bal1);

					Account2 acc = new Account2(accNum, name, bal2);
					accArr[index] = acc;
					index++;
					break;
				}

			case "2":
				System.out.println("------");
				System.out.println("계좌목록");
				System.out.println("------");

				i = 0;

				while (accArr[i] != null) {
					System.out.printf("%s %s %d", accArr[i].getAccount(), accArr[i].getName(), accArr[i].getBalance());
					System.out.println();
					i++;
				}
				break;

			case "3":
				System.out.print("계좌번호:");
				String accN1 = scanner.nextLine();

				System.out.print("예금액:");
				String dep1 = scanner.nextLine();
				int dep2 = Integer.valueOf(dep1);

				i = 0;
				while (accArr[i] != null) {
					if (accArr[i].getAccount().equals(accN1))
						accArr[i].deposit(dep2);
					i++;
				}
				break;

			case "4":
				System.out.print("계좌번호:");
				String accN2 = scanner.nextLine();

				System.out.print("출금액:");
				String with1 = scanner.nextLine();
				int with2 = Integer.valueOf(with1);

				i = 0;
				while (accArr[i] != null) {
					if (accArr[i].getAccount().equals(accN2))
						accArr[i].withdraw(with2);
					i++;
				}
				break;

			case "5":
				System.out.println("프로그램 종료");
				break aa;
			}
		}

		scanner.close();
	}

	private static void menuPrint() {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------");
		System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
		System.out.println("--------------------------------");
		System.out.print("선택>");
	}

}
