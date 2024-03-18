package com.shinhan.day05;

public class MemberSevice {

	boolean login(String id, String pw) {
		if (id.equals("hong") && pw.equals("12345"))
			return true;
		else
			return false;
	};

	boolean login2(String id, String pw) {
		return id.equals("admin") && pw.equals("1234");
	}

	void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}

}
