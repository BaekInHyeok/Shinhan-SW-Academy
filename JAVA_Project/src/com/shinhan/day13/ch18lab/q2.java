package com.shinhan.day13.ch18lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class q2 {

	public static void main(String[] args) {
		
		String filename = "./src/com/shinhan/day13/ch18lab/data3.txt";
		
		new q2().printScore(filename);

	}
	
	public void printScore(String fileName) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			
			line=br.readLine();
			System.out.println(line.replaceAll("/", "\t")+"\t총점");
								
			while((line=br.readLine())!=null) {
				
				String[] arr = line.split("/");
				int total=0;
				for(int i=1;i<arr.length;i++) {
					total+=Integer.parseInt(arr[i]);
				}
				
				System.out.println(line.replaceAll("/", "\t")+"\t"+total);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
