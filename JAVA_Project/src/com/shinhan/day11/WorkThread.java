package com.shinhan.day11;

public class WorkThread extends Thread{

	boolean work = true;
	
	WorkThread(String name){
		super(name);
	}
}
