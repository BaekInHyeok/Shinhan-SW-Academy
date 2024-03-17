package com.shinhan.day04;

public class NoteBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NoteBook note1 = new NoteBook("A",100);
		NoteBook note2 = new NoteBook("B",200);
		NoteBook note3 = new NoteBook("C",300);
		NoteBook note4 = new NoteBook("D",400);

		
//		System.out.println(note1.count);
//		System.out.println(note2.count);
//		System.out.println(note3.count);
//		System.out.println(note4.count);
		System.out.println(NoteBook.count);//클래스 차원에서 접근하는 게 바람직하다
	}

}
