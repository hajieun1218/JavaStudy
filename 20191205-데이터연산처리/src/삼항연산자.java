import java.util.Scanner;

/*
 *   ����, ����, ���� ������ �Է� �޾Ƽ� ���
 *     => ��� 60 �̻��̸� pass, nopass
 *     
 *     
 *     
 *   ���̸� �Է� ==> 15�� �̻��̸� (��ȭ��������) / ����(��ȭ�����Ұ�)
 *   
 *   
 *   �¼� => 1 2 3 4 5 => 1,2,4 �¼����� �Ұ��� / 3,5 �¼����� ����
 *    
 */
public class ���׿����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("���� ���� : ");
//		int kor = scan.nextInt();
//		
//		System.out.print("���� ���� : ");
//		int eng = scan.nextInt();
//		
//		System.out.print("���� ���� : ");
//		int math = scan.nextInt();
//		
//		int avg = (kor + eng + math) / 3;
//		
//		String result = avg>=60 ? "Pass" : "NonPass";
//		
//		System.out.println("��� : " + result);
		
		
		
		
		
		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("���� �Է� : ");
//		int age = scan.nextInt();
//		
//		String result = age>=15 ? "��ȭ��������" : "��ȭ�����Ұ�";
//		System.out.println(result);
		
		
		
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�¼� �Է�(1~5) : ");
		int seat = scan.nextInt();
		
		String result = (seat==3 || seat==5) ? "�¼����� ����" : "�¼����� �Ұ���";
		System.out.println(result);
		
	}

}
