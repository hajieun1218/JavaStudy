/* 
 *   1. if ~ else
 *      정수를 한개 입력받아서 짝수/홀수
 *   2. 임의의 알파벳을 받아서 대문자/소문자 (if~else)
 *      ====
 *        char a = 'A';
 *   3. 정수 3개를 입력 받아서 
 *       평균 => 90이상 => 'A'
 *             80이상 => 'B'
 *             70이상 => 'C'
 *             60이상 => 'D'
 *             60미만 => 'F'
 *   
 */

import java.util.Scanner;
public class 오늘의문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		if(num%2 == 0)
			System.out.println(num + "은(는) 짝수");
		else
			System.out.println(num + "은(는) 홀수");
		
		System.out.println("--------------------------------");
		
		char ch = 'A';
		
		if(ch>='A' && ch<='Z')
			System.out.println(ch + "은(는) 대문자");
		else
			System.out.println(ch + "은(는) 소문자");

			
		System.out.println("--------------------------------");
		
		System.out.print("첫번째 정수 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("두번쨰 정수 입력 : ");
		int num2 = scan.nextInt();
		System.out.print("세번쨰 정수 입력 : ");
		int num3 = scan.nextInt();
		
		int avg = (num1+num2+num3) / 3;
		System.out.println("평균 : " + avg);
		
//		if(avg>=90 && avg<=100)
//			System.out.println('A');
//		if(avg>=80 && avg<90)
//			System.out.println('B');
//		if(avg>=70 && avg<80)
//			System.out.println('C');
//		if(avg>=60 && avg<70)
//			System.out.println('D');
//		if(avg<60)
//			System.out.println('F');
		
		
		int res = avg/10;
		
		if(res==10 || res==9)
			System.out.println('A');
		if(res==8)
			System.out.println('B');
		if(res==7)
			System.out.println('C');
		if(res==6)
			System.out.println('D');
		if(res<6)
			System.out.println('F');
		
		
		
	}

}
