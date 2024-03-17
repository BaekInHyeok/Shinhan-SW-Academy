package com.shinhan.day04;

public class BookTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book2[] b = new Book2[5];
		b[0] = new Book2("Java Program", 30000);
		b[1] = new Book2("JSP Program", 25000);
		b[2] = new Book2("SQL Fundamentals", 20000);
		b[3] = new Book2("JDBC Program", 32000);
		b[4] = new Book2("EJB Program", 25000);

		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();

	}

}
