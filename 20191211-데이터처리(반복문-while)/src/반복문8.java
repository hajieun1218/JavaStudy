// 구구단 => dan을 입력 받아서 출력
/*
 *   프로그램
 *   ======
 *      사용자정의 + java라이브러리 + 외부오픈소스(mvnrepository.com)
 *      ===================================================
 *                            조립
 */
import java.util.Scanner;

import javax.swing.JOptionPane;
public class 반복문8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = scan.nextInt();
//		String s = JOptionPane.showInputDialog("정수 입력");  // 입력창
		
		// 처리
		int i = 1;
		while(i<=9) {
			System.out.printf("%2d * %2d = %2d\n", dan, i, dan*i);
			i++;
		}
		
	}

}
