package com.shinhan.day03;

public class Spliting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Spliting p = new Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for (int i = 0; i < addrArr.length; i++) {
			System.out.print(addrArr[i] + " ");
		}

	}

	private String[] split(String addr, char c) {
		// TODO Auto-generated method stub
		int count = 0;
		String newstring = "";

		for (int i = 0; i < addr.length(); i++) {
			if (addr.charAt(i) == c) {
				count++;
			}
		}

		String[] stringArr = new String[count + 1];
		count = 0;

		for (int i = 0; i < addr.length(); i++) {
			if (addr.charAt(i) != c) {
				if (i == (addr.length() - 1)) {//마지막 단어를 위한 분기점
					newstring = newstring + addr.charAt(i);
					stringArr[count] = newstring;
				} else
					newstring = newstring + addr.charAt(i);

			} else {
				stringArr[count] = newstring;
				newstring = "";
				count++;
			}
		}

		return stringArr;
	}

}
