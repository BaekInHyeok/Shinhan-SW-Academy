package com.shinhan.day04;

public class BookMgr {

	Book2[] booklist;
	
	BookMgr(Book2[] booklist){
		this.booklist=booklist;
	}
	
	void printBookList() {
		System.out.println("===책 목록===");
		//일반 for문
		for(int i=0;i<this.booklist.length;i++) {
			System.out.println(this.booklist[i].getTitle());
		}
		
		//확장 for문
		for(Book2 b:booklist) {
			System.out.println(b.getTitle());
		}
	}
	
	void printTotalPrice() {
		System.out.println("===책 가격의 총합===");
		int sum=0;
		for(int i=0;i<this.booklist.length;i++) {
			sum+=this.booklist[i].getPrice();
		}
		System.out.println("전체 책 가격의 합 : "+sum);
	}
}
