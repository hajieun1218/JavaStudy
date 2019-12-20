import java.util.Scanner;

public class 메소드3 {

	// 입력
	static int userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = scan.nextInt();
		
		return input;
	}
	
	// 이진법 처리
	static int[] toBinary(int input) {
		int[] binary = new int[16];
		
		// 배열의 위치
		int index = 15;
		
		while(true) {
			binary[index] = input%2;
			input = input/2;
			if(input==0)
				break;
			index--;
		}
		
		return binary;
	}
	
	// 출력
	static void print(int[] binary) {
		for(int i=0; i<16; i++) {
			if(i%4==0 && i!=0) 
				System.out.print(" ");
			System.out.print(binary[i]);
		}
	}
	
	// 조립
	static void process() {
		int input = userInput();
		int[] binary = toBinary(input);
		print(binary);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process();
	}

}
