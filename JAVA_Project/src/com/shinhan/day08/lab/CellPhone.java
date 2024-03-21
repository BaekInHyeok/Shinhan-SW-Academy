package com.shinhan.day08.lab;

public class CellPhone {
	String model;
	double battery;

	public CellPhone(String model) {
		super();
		this.model = model;
	}

	void call(int time) {
		try {
			if (time < 0)
				throw new IllegalArgumentException("통화시간 입력 오류");
			System.out.println("통화시간(분):" + time);
			battery -= time * 0.5;
			if (battery < 0)
				battery = 0;

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	void charge(int time) {
		try {
			if (time < 0)
				throw new IllegalArgumentException("충전시간 입력 오류");
			System.out.println("충전시간(분):" + time);
			battery += time * 3;
			if (battery > 100)
				battery = 100;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	void printBattery() {
		System.out.println("남은 베터리:" + battery);
	}

	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof CellPhone))
			return false;
		CellPhone cp = (CellPhone) otherObject;
		return model.equals(cp.model);
	}
}
