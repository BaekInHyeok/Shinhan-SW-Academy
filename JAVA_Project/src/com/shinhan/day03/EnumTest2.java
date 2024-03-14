package com.shinhan.day03;

import java.util.Calendar;
import java.util.Scanner;

public class EnumTest2 {

	final static String SUCCESS="성공";
	final static String FAIL="실패";

	public static void main(String[] args) {
		LoginCheck();
		getWeek();

	}

	private static void getWeek() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();//객체가 생성된 것을 얻기
		//System.out.println(cal);
		int yy=cal.get(Calendar.YEAR);
		int MM=cal.get(Calendar.MONTH)+1;//0~11>>1 더해줘야 함
		int dd=cal.get(Calendar.DAY_OF_WEEK);//일요일~토요일
		
		System.out.println("년도:"+yy);
		System.out.println("월:"+MM);
		System.out.println("이번 주의 몇 번재 요일?:"+dd);
		
		Week week=null;
		switch(dd) {
		case 1:
			week=Week.SUNDAY;
			break;
		case 2:
			week=Week.MONDAY;
			break;
		case 3:
			week=Week.TUESDAY;
			break;
		case 4:
			week=Week.WEDNESDAY;
			break;
		case 5:
			week=Week.THURSDAY;
			break;
		case 6:
			week=Week.FRIDAY;
			break;
		case 7:
			week=Week.SUNDAY;
			break;
		default:
			break;
		}
		
	}

	private static void LoginCheck() {
		// TODO Auto-generated method stub
		Work result;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID PW>>");
		
		String id=scanner.next();
		String pw=scanner.next();
		
		if(id.equals("firstzone")&&pw.equals("1234")) {
			result=Work.SUCCESS;
		}else {
			result=Work.FAIL;
		}
		
		System.out.println(result);
		scanner.close();

	}

}
