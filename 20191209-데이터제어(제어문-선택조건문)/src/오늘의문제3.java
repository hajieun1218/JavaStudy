/* 
 *   1. if ~ else
 *      ������ �Ѱ� �Է¹޾Ƽ� ¦��/Ȧ��
 *   2. ������ ���ĺ��� �޾Ƽ� �빮��/�ҹ��� (if~else)
 *      ====
 *        char a = 'A';
 *   3. ���� 3���� �Է� �޾Ƽ� 
 *       ��� => 90�̻� => 'A'
 *             80�̻� => 'B'
 *             70�̻� => 'C'
 *             60�̻� => 'D'
 *             60�̸� => 'F'
 *   
 */

import java.util.Scanner;
public class �����ǹ���3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = scan.nextInt();
		
		if(num%2 == 0)
			System.out.println(num + "��(��) ¦��");
		else
			System.out.println(num + "��(��) Ȧ��");
		
		System.out.println("--------------------------------");
		
		char ch = 'A';
		
		if(ch>='A' && ch<='Z')
			System.out.println(ch + "��(��) �빮��");
		else
			System.out.println(ch + "��(��) �ҹ���");

			
		System.out.println("--------------------------------");
		
		System.out.print("ù��° ���� �Է� : ");
		int num1 = scan.nextInt();
		System.out.print("�ι��� ���� �Է� : ");
		int num2 = scan.nextInt();
		System.out.print("������ ���� �Է� : ");
		int num3 = scan.nextInt();
		
		int avg = (num1+num2+num3) / 3;
		System.out.println("��� : " + avg);
		
//		if(avg>=90 && avg<=100)
//			System.out.println('A');
//		if(avg>=80 && avg<90)
//			System.out.println('B');
//		if(avg>=70 && avg<80)
//			System.out.println('C');
//		if(avg>=60 && avg<70)
//			System.out.println('D');
//		if(avg<60)
//			System.out.println('F');
		
		
		int res = avg/10;
		
		if(res==10 || res==9)
			System.out.println('A');
		if(res==8)
			System.out.println('B');
		if(res==7)
			System.out.println('C');
		if(res==6)
			System.out.println('D');
		if(res<6)
			System.out.println('F');
		
		
		
	}

}
