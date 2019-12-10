// 월을 입력 => 마지막 날이 몇일인지 확인
/* 
 *   31 28(29) 31 30 31 30
 *   31  31    30 31 30 31
 *   
 *   ===> 1 3 5 7 8 10 12 ==> 31 ==> else
 *   ===> 4 6 9 11        ==> 30
 *   ===> 2 (28,29)
 */

import java.util.Scanner;
public class 다중조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		
		int lastDay = 0;
		
		if(month==4 || month==6 || month==9 || month==11) {
			lastDay = 30;
		}
		else if(month==2) {
			if((year%4==0 && year%100!=0) || (year%400==0))
				lastDay = 29;
			else
				lastDay = 28;
		}
		else {
			lastDay = 31;
		}
		
		System.out.println(year + "년 " + month + "월은 " + lastDay + "일이 있습니다");
		
	}

}
