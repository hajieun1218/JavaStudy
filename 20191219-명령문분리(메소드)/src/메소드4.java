/*
 *   �Խ���
 *     ������ (�Ű����� : ������, ������ : (�迭))
 *     ���뺸�� (�Ű����� : �Խù���ȣ, ������ : (Ŭ����))
 *     ã��(�Ű����� : ����ڰ˻���, ������ : (�迭))
 *     �۾���
 *     �����ϱ�
 *     �亯�ϱ�
 *     �����ϱ�
 */

import java.util.Scanner;

public class �޼ҵ�4 {

	static void gugudan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.printf("%d*%d=%d\n",dan, i, dan*i);
		}
	}
	
	static String gugudan2(int dan) {
		String result = "";
		for(int i=1; i<=9; i++) {
			result += dan + "*" + i + "=" + (dan*i) + "\n";
		}
		return result;
	}
	
	static void process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�� �Է� : ");
		int dan = scan.nextInt();
		
		// ������ ���
//		gugudan(dan);
		String res = gugudan2(dan);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process();
		
	}

}
