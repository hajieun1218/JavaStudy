import java.util.Scanner;

/*
 *   ���ĺ� �빮�ڷ� �Է�
 *     DDD  ==> AAA
 *     ZZZ  ==> WWW
 */
public class �ݺ���5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("���ĺ� �빮�� ������ �Է� : ");
		String alpha = scan.next();
		
		for(int i=0;i<alpha.length();i++) {
			char c = alpha.charAt(i);
			System.out.print((char)(c-3));
		}
		
	}

}
