package com.shinhan.day08.ch11;

import java.lang.invoke.WrongMethodTypeException;

class NotExistIDException extends Exception {
	public NotExistIDException() {

	}

	public NotExistIDException(String message) {
		super(message);
	}
}

class WrongPasswordException extends Exception {
	public WrongPasswordException() {

	}

	public WrongPasswordException(String message) {
		super(message);
	}
}

public class LoginExample {

	public static void main(String[] args) {

		try {
			login("white", "12345");
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		try {
			login("blue", "54321");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	}

	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {

		if (!id.equals("blue")) {
			throw new NotExistIDException("ID 입력 오류");
		}
		if (!id.equals("12345")) {
			throw new WrongPasswordException("PW 입력 오류");
		}
	}

}
