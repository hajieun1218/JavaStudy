// 1,2 => 난수 발생 => 홀(1),짝(2)

import java.util.Scanner;;
public class 이항연산자_비교연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Math.random() => 0.0 ~ 0.99 => 0.0 ~ 1.999 => 0 ~ 1
		int com = (int)(Math.random() * 2) + 1;  // 1~2
		
		Scanner scan = new Scanner(System.in);
		System.out.print("입력(홀,짝) : ");
		String input = scan.next();
		
		String result = com%2==0 ? "짝" : "홀";
		
		// 문자열 비교 : equals 사용 , ==(X)
		String dap = input.equals(result) ? "정답" : "오답";
		
		System.out.println("com = " + com);
		System.out.println("dap = " + dap);
		
		
	}

}
