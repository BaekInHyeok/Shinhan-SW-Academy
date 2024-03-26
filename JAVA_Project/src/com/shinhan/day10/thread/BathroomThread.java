package com.shinhan.day10.thread;

public class BathroomThread extends Thread {

	BathRoom room;
	String name;

	BathroomThread(BathRoom room, String name) {
		this.room = room;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			room.use(name);
		}
	}

}
