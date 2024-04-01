package com.shinhan.day13.ch18lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class q3 {

	public static void main(String[] args) throws IOException {
		
		String filename1 = "./src/com/shinhan/day13/ch18lab/data4.txt";
		String filename2 = "./src/com/shinhan/day13/ch18lab/data5.txt";
		q3.reverseLine(filename1,filename2);
	}
	
	
	static void reverseLine(String inputFileName, String outputFileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
		List<String> datas = new ArrayList<String>();
		
		String s = null;
		while((s=br.readLine())!=null) {
			datas.add(s);
		}
		for(int i=datas.size()-1;i>=0;i--) {
			bw.write(datas.get(i));
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}
}
