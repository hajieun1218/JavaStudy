/*
 *   5���� ������ �޾Ƽ� 
 *   �ִ밪, �ּҰ� ���
 */

import java.util.Scanner;
public class �迭9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int[] num = new int[5];
		
		for(int i=0; i<num.length; i++) {
//			System.out.print((i+1) + "��° ���� �Է� : ");
//			num[i] = scan.nextInt();
			num[i] = (int)(Math.random()*100) + 1;
		}
		
		int max = num[0];
		int min = num[0];
		for(int i : num) {
			if(i>max)
				max = i;
			if(i<min)
				min = i;
		}
		
		for(int i:num) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
		
	}

}
