/* 
 *    조건문
 *      = 단일 조건문
 *        1) 형식
 *        
 *           if(조건문)
 *           	실행문장
 *           
 *           if(조건문)  ===> 1개이상의 실행문장이 있는 겨우
 *           {
 *           	실행문장1
 *           	실행문장2
 *           }
 *           
 *           if(조건문)
 *           	실행문장1  ===> if소속문장
 *           	실행문장2  ===> if와 관련없는 문장
 *           
 *         2) 조건문 처리 방법
 *            ====
 *             true/false => 부정연산자, 비교연산자, 논리연산자
 *             
 *         3) 실행 => 조건 true => 문장 실행
 *                  조건 false => 문장 수행을 하지 않는다
 *                  
 *                  
 *         
 *      = 선택 조건문
 *      = 다중 조건문
 *      
 */


/*
 *   1) 자바에서 생략이 가능
 *   	1. import : 라이브러리 클래스를 불러온다
 *                  java.lang만 생략 가능  - System, String, Math ...
 *                 
 *   	2. return : 모든 메소드는 return을 가지고 있다
 *   	3. 상속 : 모든 클래스(사용자 정의)는 Object 상속    (extends Object 생략)
 *   	4. 예외처리 : 모든 클래스는 예외처리를 가지고 있다
 *         ======
 *          비정상종료를 방지하고 정상상태를 유지 (미리 에러를 방지하는 프로그램)
 */


// 정수를 입력받아서 => 홀수/짝수

import java.util.Scanner;
// import => 이미 만들어진 클래스를 불러올 때 사용
// CBD => 컴포넌트 베이스
// 조립식 프로그램
public class 제어문_조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		if(num%2==0)
		{
			System.out.println(num + "는(은) 짝수입니다.");
		}
		if(num%2!=0)
		{
			System.out.println(num + "는(은) 홀수입니다.");
		}
		
	}

}
