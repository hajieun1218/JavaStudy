// ������ => dan�� �Է� �޾Ƽ� ���
/*
 *   ���α׷�
 *   ======
 *      ��������� + java���̺귯�� + �ܺο��¼ҽ�(mvnrepository.com)
 *      ===================================================
 *                            ����
 */
import java.util.Scanner;

import javax.swing.JOptionPane;
public class �ݺ���8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("�� �Է� : ");
		int dan = scan.nextInt();
//		String s = JOptionPane.showInputDialog("���� �Է�");  // �Է�â
		
		// ó��
		int i = 1;
		while(i<=9) {
			System.out.printf("%2d * %2d = %2d\n", dan, i, dan*i);
			i++;
		}
		
	}

}
