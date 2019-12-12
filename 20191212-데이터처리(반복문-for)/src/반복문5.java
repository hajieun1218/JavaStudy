import java.util.Scanner;

/*
 *   알파벳 대문자로 입력
 *     DDD  ==> AAA
 *     ZZZ  ==> WWW
 */
public class 반복문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("알파벳 대문자 여러개 입력 : ");
		String alpha = scan.next();
		
		for(int i=0;i<alpha.length();i++) {
			char c = alpha.charAt(i);
			System.out.print((char)(c-3));
		}
		
	}

}
