/* 
 *   변수 : 한개의 데이터를 저장
 *   
 *   1. 변수 선언
 *   2. 선언과 동시에 값을 입력
 *   
 *   ============
 *   변수가 여러개 일 때
 *   int kor;
 *   int eng;
 *   int math;
 *   ======> int kor, eng, math;
 *   
 *   초기값
 *   int kor = 100;
 *   int eng = 100;
 *   int math = 100;
 *   ======> int kor = 100, eng = 100, math = 100;
 *   
 *   int kor, eng, math;
 *   kor = eng = math = 100;
 *   
 *   
 */
public class 일주차정리1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int kor, eng, math;
		kor = eng = math = 100;
		
		System.out.println("kor = " + kor);
		System.out.println("eng = " + eng);
		System.out.println("math = " + math);
		
		
		
		/*
		 *  <<자바 개발자들의 약속>>
		 *   1. 클래스명 ==> 대문자 시작
		 *   2. 메소드명, 변수명 ==> 소문자 시작    firstName(헝거리언식)
		 *   3. 상수 ==> 전체 대문자
		 *   4. 들여쓰기   
		 */
		
		String first_name = "홍";
		String last_name = "길동";
		
		// 문자열 결합
		System.out.println("이름 : " + first_name + last_name);
		
		
		
		
	}

}
