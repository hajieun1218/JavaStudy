// ���� 2���� �Է� �޾Ƽ�  ==> ������ 1�� �Է� ==> ��Ģ����
// �ڹ� => �Է� �޴� ��쿡 => char(X), String���� �޾ƾ���
// String => ==(X), equals���  (==�� �ּ� ��, equals�� �� ��)

import java.util.Scanner;
public class �������ǹ�3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���� : ");
		int num1 = scan.nextInt();
		System.out.print("�ι�° ���� : ");
		int num2 = scan.nextInt();
		
		System.out.print("������(+,-,*,/) : ");
		String op = scan.next();
		
		if(op.equals("+")) {
			System.out.printf("%d+%d=%d\n", num1, num2, num1+num2);
		}
		else if(op.equals("-")) {
			System.out.printf("%d-%d=%d\n", num1, num2, num1-num2);
		}
		else if(op.equals("*")) {
			System.out.printf("%d*%d=%d\n", num1, num2, num1*num2);
		}
		else if(op.equals("/")) {
			if(num2==0)
				System.out.println("0���� ���� �� �����ϴ�");
			else
				System.out.printf("%d/%d=%.2f\n", num1, num2, num1/(double)num2);
		}
		else { 
			System.out.println("�߸��� �������Դϴ�!!");
		}
		
	}

}
