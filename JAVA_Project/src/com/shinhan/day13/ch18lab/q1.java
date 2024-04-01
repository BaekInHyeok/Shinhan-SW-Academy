package com.shinhan.day13.ch18lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class q1 {

	public static void main(String[] args) throws Exception {

		String filename1 = "./src/com/shinhan/day13/ch18lab/data1.txt";
		String filename2 = "./src/com/shinhan/day13/ch18lab/data2.txt";

		ArrayList<String> datas = new q1().compareFile(filename1, filename2);
		datas.stream().forEach(data -> System.out.println(data));

	}

	ArrayList<String> compareFile(String fstFileName, String scdFileName) throws Exception {

		ArrayList<String> result = new ArrayList<String>();

		// FileReader fr1 = new FileReader(fstFileName);
		// FileReader fr2 = new FileReader(scdFileName);

		BufferedReader br1 = new BufferedReader(new FileReader(fstFileName));
		BufferedReader br2 = new BufferedReader(new FileReader(scdFileName));

		LineNumberReader lineReader = new LineNumberReader(br2);

		String s1, s2;


		while ((s1 = br1.readLine()) != null) {
			
			s2 = br2.readLine();
			if (!(s1.equals(s2))) {
				result.add("Line " + lineReader.getLineNumber() + ":" + s2);
			}
		}

		br1.close();
		br2.close();

//		fr1.close();
//		fr2.close();
		return result;
	}

}
