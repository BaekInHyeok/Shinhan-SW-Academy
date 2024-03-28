package com.shinhan.day12;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StreamTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub

//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();

	}

	//파일로부터 스트림을 얻는 방법
	private static void f6() throws URISyntaxException, IOException {
		URI uri = StreamTest.class.getResource("data.txt").toURI();
		Path path = Paths.get(uri);

		//Stream : Files.lines(path)
		Files.lines(path).forEach(line -> {
			System.out.println(line);
		});
	}

	private static void f5() {
		IntStream.range(1, 6).forEach(i -> System.out.println(i));
		System.out.println("-----------------");
		IntStream.rangeClosed(1, 6).forEach(i -> System.out.println(i));
	}

	private static void f4() {
		String[] arr = { "홍길동", "심은정", "정민교" };
		int[] scores = { 100, 99, 88, 77 };
		Arrays.stream(arr).forEach(name -> System.out.println(name));
		double result = Arrays.stream(scores).average().getAsDouble();
		System.out.println(result);
	}

	private static void f3() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		// 1<= <6
		IntStream.range(1, 6).forEach(i -> {
			Product p = new Product(i, "상품" + i, "xx상사", (int) (Math.random() * 10000));
			list.add(p);
		});

		// 내부반복자를 이용한 출력
		list.stream().forEach(p -> System.out.println(p));

		// 내부반복자를 이용하여 가격합계 구하기
		int total = list.stream().mapToInt(p -> p.getPrice()).sum();
		System.out.println(total);
	}

	private static void f2() {
		// TODO Auto-generated method stub
		List<Student> data = new ArrayList<>();
		data.add(new Student("A", 100));
		data.add(new Student("C", 400));
		data.add(new Student("A", 100));
		data.add(new Student("D", 200));
		data.add(new Student("B", 123));

		// map:변형하다
		double avg = data.stream().mapToInt(s -> s.getScore()).average().getAsDouble();
		System.out.println(avg);
		System.out.println(923 / 5.0);
	}

	private static void f1() {
		List<String> data = new ArrayList<>();
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");

		// 외부반복자(Iterator) : 중간에 나올 수 있음
		for (String s : data) {
			System.out.println(s);
		}

		// 내부반복자(Stream) : 중간에 나오지 못함
		data.stream().forEach(a -> {
			System.out.println(a + "===thread 이름:" + Thread.currentThread().getName());
		});

		// 병렬처리
		data.parallelStream().forEach(a -> {
			System.out.println(a + "===thread 이름:" + Thread.currentThread().getName());
		});
	}

}
