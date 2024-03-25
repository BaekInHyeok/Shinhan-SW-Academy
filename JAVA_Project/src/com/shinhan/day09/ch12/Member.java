package com.shinhan.day09.ch12;

public class Member {

	private String id;
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	// 여기에 코드를 작성하세요.

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		

		builder.append(id).append(":").append(name);
		return builder.toString();
	}

}
