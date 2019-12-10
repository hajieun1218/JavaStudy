// 사용자의 입력값을 받아서 (짝수, 홀수)

import java.util.Scanner;

public class 이항연산자_비교연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		String result = num%2==0 ? "짝수" : "홀수";
		System.out.println(num + "은(는) " + result + "입니다");
	}

}
