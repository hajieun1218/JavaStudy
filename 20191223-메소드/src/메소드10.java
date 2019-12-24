import java.util.Scanner;

// 정수 입력 => 출력
/*
 *   입력
 *   출력
 *   ===
 *   조립
 */
public class 메소드10 {

	static int input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		return num;
	}
	
	static void print(int num) {
		System.out.println(num);
	}
	
	static void process() {
		print(input());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		process();
	}

}
