package com.shinhan.day11;

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}

	//동기화 메서드
	public synchronized void setMemory3(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}

		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}
	
	//동기화블럭
	public void setMemory1(int memory) {
		this.memory = memory;

		synchronized (this) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}

			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		}

	}

	public void setMemory2(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}

		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

}
