package com.shinhan.day08;

public class ScoreException extends Exception{
	
	String message;
	ScoreException(String message){
		//this.message=message;
		super(message);
	}
	
	void print() {
		System.out.println("score는 70 이상이어야 합니다.");
	}

}
