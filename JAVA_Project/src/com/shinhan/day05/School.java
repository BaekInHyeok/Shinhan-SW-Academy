package com.shinhan.day05;

/*패키지 내에 class가 존재하는지 찾아야 함
 * Modifier
 * 1.접근지정자 : public > protected > 생략 > private
 * 2.활용방법 : static, final, abstract, synchronized...
 */
public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student = new Student("홍길동",20,200201);
		Teacher teacher = new Teacher("이순신",30,"JAVA");
		Employee employee = new Employee("유관순",40,"교무과");
		
		student.print();
		teacher.print();
		employee.print();
		

	}

}
