// 5���� ������ �Է¹޾Ƽ� => 5�� ������ ����ϰ� => ��, ���

import java.util.Scanner;
public class �迭7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int[] num = new int[5];
		int sum = 0;
		
		for(int i=0; i<num.length; i++) {
			System.out.print((i+1) + "��° ���� �Է� : ");
			num[i] = scan.nextInt();
			sum += num[i];
		}
		
		// ���
		for(int i : num) {
			System.out.print(i + "  ");
		}
		System.out.println("\n���� : " + sum);
		System.out.printf("��� : %.2f", sum/(double)num.length);
	}

}
