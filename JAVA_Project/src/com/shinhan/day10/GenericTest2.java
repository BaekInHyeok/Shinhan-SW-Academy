package com.shinhan.day10;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
class Student implements Comparable<Student> {
	String name;
	int score;

	// 점수 정렬
//	@Override
//	public int compareTo(Student obj) {
//		// TODO Auto-generated method stub
//		return score - obj.score;// 오름차순 정렬
//	}

	// 이름 정렬
//	@Override
//	public int compareTo(Student obj) {
//		// TODO Auto-generated method stub
//		return name.compareTo(obj.name);
//	}

	public int compareTo(Student obj) {
		// 점수로 desc, 같은 점수는 이름으로 asc

		if (obj.score == score)
			return name.compareTo(obj.name);
		return obj.score - score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", score=").append(score).append("]");
		return builder.toString();
	}

}

public class GenericTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// f1();
		// f2();
		// f4();
		f5();

	}

	private static void f5() {
		// TODO Auto-generated method stub
		Car[] arr = { new Car("A", 100, "black"), new Car("C", 200, "white"), new Car("B", 100, "red"),
				new Car("D", 300, "black"), new Car("B", 500, "blue") };

		print2(arr, "Original");

		Arrays.sort(arr);

		print2(arr, "Sort");

		Arrays.sort(arr, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {

				int result1 = o2.price - o1.price;
				if (result1 == 0) {
					int result2 = o2.model.compareTo(o1.model);
					if (result2 == 0) {
						return o1.color.compareTo(o2.color);
					}
					return result2;
				}
				return result1;
			}
		});

		// 가격 asc 람다식
		Arrays.sort(arr, (obj1, obj2) -> {

			int result=obj1.price - obj2.price;
			if(result==0) {
				int result2 = obj2.
			}
		});
	}

	static void print2(Car[] arr, String title) {
		System.out.println("=======" + title + "=========");
		for (Car st : arr) {
			System.out.println(st.toString());
		}
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Student[] arr = { new Student("A", 80), new Student("C", 10), new Student("D", 60), new Student("B", 50),
				new Student("E", 30) };

		print(arr, "Original");

		// Comparable interface를 구현해야 sort 가능
		Arrays.sort(arr);

		print(arr, "Score Descending, 이름 Ascending");

		// 이미 구현된
		Arrays.sort(arr, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int result = o2.name.compareTo(o1.name);
				if (result == 0)
					return o1.score - o2.score;
				return result;
			}

		});

		Arrays.sort(arr, (o1, o2) -> {
			int result = o2.name.compareTo(o1.name);
			if (result == 0)
				return o1.score - o2.score;
			return result;
		});

		print(arr, "Score Descending, 이름 Ascending");
	}

	static void print(Student[] arr, String title) {
		System.out.println("=======" + title + "=========");
		for (Student st : arr) {
			System.out.println(st.toString());
		}
	}

	private static void f2() {
		// TODO Auto-generated method stub
		String[] arr = { "Hello", "Coffee", "Computer", "java", "JAVA" };
		System.out.println("original:" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending Sort:" + Arrays.toString(arr));

		// 2.익명 구현 클래스
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				// return o2.compareTo(o1);// 뒤.compareTo(앞) 순서로 >> 내림차순
				return o2.compareToIgnoreCase(o1);// 뒤.compareTo(앞) 순서로 >> 내림차순
			}
		});
		System.out.println("Descending Sort : " + arr.toString());

		// 3.람다표현식
		Arrays.sort(arr, (o1, o2) -> o2.compareToIgnoreCase(o1));
	}

	private static void f1() {

		Integer[] arr = { 1, 5, 2, 91, 20, 39, 55, 24 };

		System.out.println("original:" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending Sort:" + Arrays.toString(arr));

		// Descending Sort
		// 1.구현 클래스
		Arrays.sort(arr, new MyDscendingSort());
		// 2.익명 클래스

		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}

		});
		// 3.람다표현식
		Arrays.sort(arr, (o1, o2) -> o2 - o1);

		System.out.println("Descending Sort : " + Arrays.toString(arr));

	}

}
