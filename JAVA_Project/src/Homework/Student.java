package Homework;

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}
}

public class Student {

	public static void main(String[] args) {
		Person p1 = new Person("수지");
		Person p2 = new Person("은우");
		p1 = p2;
		System.out.println(p1.name);
	}

}
