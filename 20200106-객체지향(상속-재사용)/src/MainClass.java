import java.util.*;

class Human {
	String name;
	int age;
	
	public Human() {
		System.out.println("Human() Call...");
	}
}

/*
 *    상위 클래스(상속을 내리는 클래스) : super클래스, 부모클래스, Base클래스
 *    하위 클래스(상속을 받는 클래스)  :  sub클래스,  자식클래스, 파생클래스
 *    
 *    => 기존의 클래스의 모든 내용을 가지고와서 확장하는 내용
 *    => 자바의 클래스는 Object 상속을 가지고 있다 (Object : 자바의 최상위 클래스)
 *    => static, 생성자는 상속할 수 없다
 *    => 목적은 중복된 코딩을 방지
 *       재사용을 목적으로 만든 기능 
 *    => 상속을 내리는 클래스가 항상 크다
 */
class Sawon extends Human {
	/*
	 *   눈에는 안보이지만 상속이 내려옴
	 *   String name;
	 *   int age;
	 */
	String dept;
	String loc;
	
	public Sawon() {
		System.out.println("Sawon() Call...");
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ArrayList<String> list = new ArrayList<String>();
//		list.add("홍길동");
//		
//		String name = list.get(0);
		
		Sawon s = new Sawon();
		s.age = 30;
		s.name = "홍길동";
		s.loc = "서울";
		s.dept = "개발부";
		
		System.out.println("이름 : " + s.name);
		System.out.println("부서 : " + s.dept);
		System.out.println("근무지 : " + s.loc);
		System.out.println("나이 : " + s.age);
		
	}

}
