// 5개의 정수를 입력받아서 => 5개 정수를 출력하고 => 합, 평균

import java.util.Scanner;
public class 배열7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int[] num = new int[5];
		int sum = 0;
		
		for(int i=0; i<num.length; i++) {
			System.out.print((i+1) + "번째 정수 입력 : ");
			num[i] = scan.nextInt();
			sum += num[i];
		}
		
		// 출력
		for(int i : num) {
			System.out.print(i + "  ");
		}
		System.out.println("\n총점 : " + sum);
		System.out.printf("평균 : %.2f", sum/(double)num.length);
	}

}
