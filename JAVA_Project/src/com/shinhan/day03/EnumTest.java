package com.shinhan.day03;

public class EnumTest {

	// 상수 : 변하지 않는 값
	final static int SUCCESS = 1;
	final static int FAIL = 0;
	final static int PLAY = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
		f2();
		f3(Week.MONDAY);
		
		//배열임을 이용한 요일 무작위 뽑기
		int su=(int)(Math.random()*7);
		f4(su);
	}

	private static void f4(int su) {
		// TODO Auto-generated method stub
		for(Week we : Week.values()) {
			if(su==we.ordinal()) {
				System.out.println(we);
				break;
			}
		}
	}

	private static void f3(Week aa) {
		// TODO Auto-generated method stub
		String message = "";

		for (Week we : Week.values()) {
			System.out.println(we + "--" + we.name() + "--" + we.ordinal());
		}
		switch (aa) {

		case FRIDAY -> {
			message = "금";
		}
		case SATURDAY -> {
			message = "토";
		}
		case SUNDAY -> {
			message = "일";
		}
		case MONDAY -> {
			message = "월";
		}
		case TUESDAY -> {
			message = "화";
		}
		case WEDNESDAY -> {
			message = "수";
		}
		case THURSDAY -> {
			message = "목";
		}
		}

		System.out.println(aa + ":" + message);
	}

	// Work.java, Week.java에 저장되어 있는 enum 타입 값을 사용
	private static void f2() {
		// TODO Auto-generated method stub
		Week[] arr = Week.values();
		for (Week week : arr) {
			System.out.println(week + "--" + week.ordinal() + "--" + week.name());
		}

		call2(Week.FRIDAY);
		call2(Week.SUNDAY);
	}

	private static void call2(Week aa) {
		// TODO Auto-generated method stub
		switch (aa) {
		case FRIDAY:
			System.out.println("금요일입니다.");
			break;
		case SATURDAY:
			System.out.println("토요일입니다.");
			break;
		case SUNDAY:
			System.out.println("일요일입니다.");
			break;
		case MONDAY:
			System.out.println("월요일입니다.");
			break;
		case TUESDAY:
			System.out.println("화요일입니다.");
			break;
		case WEDNESDAY:
			System.out.println("수요일입니다.");
			break;
		case THURSDAY:
			System.out.println("목요일입니다.");
			break;
		default:
			break;
		}

	}

	private static void f1() {
		// TODO Auto-generated method stub
		int score = 100;
		Work result;
		if (score >= 90) {
			result = Work.SUCCESS;
		} else {
			result = Work.FAIL;
		}

		System.out.println(result);
	}

}
