/*
 *   ��ǻ�� => 1~100������ ������ ���� ����
 *   
 *   ��Ʈ => UP / DOWN
 */
import java.util.Scanner;
public class ���ٿ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ����(������ ��)
		int com = (int)(Math.random()*100)+1; // 1~100
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("1~100������ ���� �Է� : ");
			int user = scan.nextInt();
			// ����ó��
			if(user<1 || user>100) {
				System.out.println("�߸��� �Է��Դϴ�!!");
				continue;
			}
			
			// ó��
			if(com>user) { 
				System.out.println("�Է°����� ū ���� �Է��ϼ���");
			}
			else if(com<user) {
				System.out.println("�Է°����� ���� ���� �Է��ϼ���");
			}
			else {
				System.out.println("Game Over!!!");
				// ����
//				break;            // => while�� ����
				System.exit(0);   // => main ����
			}
		}
		
		
		
		
		
	}

}
