package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URL;

public class ObjectTest4 {

	public static void main(String[] args) throws IOException {
		// f1();
		try {
			f2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void f2() throws IOException {
		// TODO Auto-generated method stub
		// new FileReader("src/com/shinhan/day09/ComputerVO.java");// 2바이트 씩 읽음

		Class<?> cls = ObjectTest4.class;

		URL url = cls.getResource("반명함.jpg");

		System.out.println(url.getPath());

		InputStream fis = cls.getResourceAsStream("반명함.jpg");

		int i;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}

		InputStream fis2 = cls.getResourceAsStream("aa.xml");
		InputStreamReader isr = new InputStreamReader(fis2);

		int j;
		while ((j = isr.read()) != -1) {
			System.out.print((char) j);
		}

		InputStream fis3 = cls.getResourceAsStream("oracleinfo.properties");
		InputStreamReader isr2 = new InputStreamReader(fis2);

		int k;
		while ((k = isr.read()) != -1) {
			System.out.print((char) k);
		}

	}

	private static void f1() {
		// 리플렉션
		Class<ComputerVO> cls = ComputerVO.class;

		Constructor<?>[] con = cls.getDeclaredConstructors();

		for (Constructor<?> cc : con) {
			System.out.println(cc.getName());
			System.out.println(cc.getParameterCount());

			for (Parameter param : cc.getParameters()) {
				System.out.println(param.getName());
			}
			System.out.println("---------------");
		}

	}

}
