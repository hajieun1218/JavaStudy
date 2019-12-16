/*
 *   5개의 정수를 받아서 
 *   최대값, 최소값 출력
 */

import java.util.Scanner;
public class 배열9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int[] num = new int[5];
		
		for(int i=0; i<num.length; i++) {
//			System.out.print((i+1) + "번째 정수 입력 : ");
//			num[i] = scan.nextInt();
			num[i] = (int)(Math.random()*100) + 1;
		}
		
		int max = num[0];
		int min = num[0];
		for(int i : num) {
			if(i>max)
				max = i;
			if(i<min)
				min = i;
		}
		
		for(int i:num) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}

}
