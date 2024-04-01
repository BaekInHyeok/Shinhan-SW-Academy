package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import com.shinhan.day12.Product;
import com.shinhan.day12.Student;

public class IOTest {

	static String path="./src/com/shinhan/day13/";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		

		// f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
		f9();
	}

	private static void f9() {
		File f = new File(path+"Review.java");
		System.out.println(f.exists());
		System.out.println(f.length());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.isDirectory());
		
		
		
	}

	private static void f8() throws IOException, ClassNotFoundException {
		Student st1 = new Student("홍길동", 100, "남자");
		Student st2 = new Student("장길산", 88, "남자");
		Product p = new Product(1,"TV","S",1000);
		
		String path="./src/com/shinhan/day13";
		FileOutputStream fos = new FileOutputStream(path+"data.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.writeObject(p);
		
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(path+"data.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Student st3 = (Student)ois.readObject();
		Student st4 = (Student)ois.readObject();
		Product p2 = (Product)ois.readObject();
		
		System.out.println(st3);
		System.out.println(st4);
		System.out.println(p2);
		
		ois.close();
		fis.close();

	}

	private static void f7() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileReader fr;
		BufferedReader br;

		fr = new FileReader(filename);// 파일 열기...2byte씩 처리
		String i;
		br = new BufferedReader(fr);
		while ((i = br.readLine()) != null) {
			System.out.println(i);
		}

		fr.close();

	}

	private static void f6() throws IOException {
		String fileName = "aa.txt";
		FileOutputStream fos = new FileOutputStream(fileName);

		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(10);
		dos.write(20);
		dos.writeDouble(10.5);
		dos.writeDouble(20.5);
		dos.writeUTF("문자");

		fos.write(10);
		fos.write(20);
		fos.flush();

		fos.close();

		FileInputStream fis = new FileInputStream(fileName);

		DataInputStream dis = new DataInputStream(fis);

//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		System.out.println(fis.read()+fis.read());
		int a = fis.read();
		int b = fis.read();
		double c = dis.readDouble();
		double d = dis.readDouble();
		String s = dis.readUTF();

		System.out.println(a + b + c + d);
		System.out.println(s);

		fis.close();

	}

	private static void f5() throws IOException {
		// 파일 출력
		String fileName = "aa.txt";
		FileWriter fw = new FileWriter(fileName);
		fw.write("java\n");
		fw.write("자바끝");
		fw.close();// close(자원 반납)를 해야 파일 생성이 완료됨. 안 하면 다른 곳에서 파일 접근 및 사용 불가

	}

	private static void f4() {
		// 모니터 출력(sysout)
		PrintStream monitor = System.out;
		monitor.println("모니터 출력");

	}

	private static void f3() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileReader fr;
		fr = new FileReader(filename);// 파일 열기
		int i;
		while ((i = fr.read()) == -1) {
			System.out.print((char) i);
		}

		fr.close();
	}

	private static void f2() throws IOException {
		// 파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileInputStream fis;
		fis = new FileInputStream(filename);// 파일 열기
		int i;
		while ((i = fis.read()) == -1) {
			System.out.print((char) i);
		}

		fis.close();

	}

	private static void f1() throws IOException {
		InputStream is = System.in;// 이걸로 읽으면 2바이트 단위로 읽어야 하는 한글은 깨지게 됨
		InputStreamReader isr = new InputStreamReader(is);
		int i;

		while ((i = isr.read()) != 13) {// 13:enter키의 ASCII값
			System.out.println((char) i);
		}

	}

}
