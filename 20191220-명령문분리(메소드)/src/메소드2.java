// 정수 1개 입력을 받아서 => 2진법 출력
// 10 ==> 16bit
// 0000 0000 0000 1010

import java.util.Scanner;

public class 메소드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		
		// 변수
		int input = scan.nextInt();  // 사용자 입력값
		int[] binary = new int[16];
		
//		System.out.println(Integer.toBinaryString(input));
		
		// 배열의 위치
		int index = 15;
		
		while(true) {
			binary[index] = input%2;
			input = input/2;
			if(input==0)
				break;
			index--;
		}
		
		// 출력
		for(int i=0; i<16; i++) {
			if(i%4==0 && i!=0) 
				System.out.print(" ");
			System.out.print(binary[i]);
		}
		
	}

}
