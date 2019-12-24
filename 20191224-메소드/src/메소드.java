/*
 *   메소드
 *   1) 형식 
 *   2) 리턴형 : 기본형, 클래스, 배열
 *   3) 매개변수 : 사용자 요청값
 *     ==> 3개 이상이면 묶어서 요청 => 배열, 클래스
 *         ex. 회원가입(클래스)
 *             게시판 글쓰기(클래스)
 *   4) 매개변수 전송법 
 *      => call by value : 기본형, String
 *                         메모리를 따로 생성(복제(값))
 *      => call by reference : 배열, 클래스
 *                             같은 주소를 이용해서 값을 변경
 *   5) 호출
 *   
 *   ** 모든 메소드는 수행이 종료한 다음에 다시 호출한 위치로 돌아온다
 *   ** 메소드를 여러개 호출시 => 한개의 메소드가 수행을 종료해야 다음 메소드 호출
 */

// 매개변수 전송 -> call by value

public class 메소드 {

	static void swap(String a, String b) {
		System.out.println("변경전 swap : a = " + a + ", b = " + b);
		// a=10, b=20
		// a=Hello, b=Java
		
		// 변경
		String temp = a;
		a = b;
		b = temp;
		
		System.out.println("변경후 swap : a = " + a + ", b = " + b);
		// a=20, b=10
		// a=Java, b=Hello
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "Hello";
		String b = "Java";
		swap(a,b);  // 복제
		System.out.println("main swap : a = " + a + ", b = " + b);
		// a=10, b=20 ===> 다른 메모리 call by value
		// a=Hello, b=Java
	}

}
