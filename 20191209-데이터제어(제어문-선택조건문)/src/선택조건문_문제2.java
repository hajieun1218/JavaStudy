import java.util.Scanner;

/*
 *  <정수 두개와 연산자를 받아서 사칙연산>
 * 
 *   첫번째 정수 입력 : 10
 *   두번째 정수 입력 : 20
 *   연산자 입력 : +  ==> 조건) String op = scan.next()
 *                         char c = op.charAt(0)
 *   
 *   결과값
 *   10 + 20 = 30
 */


public class 선택조건문_문제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = scan.nextInt();
		System.out.print("연산자(+,-,*,/) 입력 : ");
		String op = scan.next();
		
		// 연산자 변환
		char c = op.charAt(0);
//		if(op.equals("+"))
		
		if(c=='+') { 
			System.out.println("결과값 : " + num1 + '+' + num2 + "=" + (num1+num2));
		}
		if(c=='-') {
			System.out.println("결과값 : " + num1 + '-' + num2 + "=" + (num1-num2));
		}
		if(c=='*') {
			System.out.println("결과값 : " + num1 + '*' + num2 + "=" + (num1*num2));
		}
		if(c=='/') {
			if(num2 == 0)
				System.out.println("0으로 나눌 수 없습니다");
			else
				System.out.println("결과값 : " + num1 + '/' + num2 + "=" + (num1/num2));
		}
		
		
	}

}
