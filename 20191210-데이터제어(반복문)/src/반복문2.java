/*
 *   while => while(true) : 무한루프
 *   for   => for(;;)     : 무한루프
 *   
 *   반복문 제어
 *    1) continue => 특정 내용을 제외
 *    2) break    => 반복문을 종료
 */

import java.util.Scanner;
public class 반복문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// while  => 1~(사용자입력값)까지의 짝수의 합, 홀수의 합, 총합을 구해서 출력
		
		int even=0, odd=0, total=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		int i = 1;
		while(i<=num) {
			if(i%2==0) {
				even+=i;
			}
			else {
				odd+=i;
			}
			i++;
		}
		System.out.println("짝수의 합 : " + even);
		System.out.println("홀수의 합 : " + odd);
		System.out.println("총합 : " + (even+odd));
		
		
	}

}
