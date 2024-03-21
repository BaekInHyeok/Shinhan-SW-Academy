package com.shinhan.day08;

//interface : 규격서
@FunctionalInterface // 람다 표현식이 가능한지 체크함
interface JDBCInterface {
	// 1.상수
	// 2.추상메서드...구현class가 반드시 구현해야 함
	void connection();// public abstract가 생략되어 있음
	// 3.default메서드:구현 가능, 구현 class가 공통적으로 쓰는 기능. 재정의 가능함
	// 4.static method:구현 가능, 구현 class가 공통적으로 쓰는 기능, 재정의 불가능
	// 5.private method : default method에서만 호출 가능
}

//구현 class
class OracleDB implements JDBCInterface {

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("Oracle DB 연결");
	}

}

//구현 class
class MySQLDB implements JDBCInterface {

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("MySQL DB 연결");
	}

}

public class Review {

	public static void main(String[] args) {
		work(new OracleDB());
		work(new MySQLDB());

		// 익명 구현 class
		work(new JDBCInterface() {

			@Override
			public void connection() {
				System.out.println("익명구현 class에서 메서드 재정의");
				method();
			}

			void method() {
				System.out.println("메서드 추가함");
			}
		});

		// 람다표현식
		work(() -> System.out.println("람다 표현식으로 메서드 재정의"));

	}

	private static void work(JDBCInterface db) {
		// TODO Auto-generated method stub
		db.connection();
		// db.method(); >> connection 내에서만 호출 가능

	}

}
