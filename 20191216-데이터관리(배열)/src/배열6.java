// 5���� �̸��� �Է¹޾Ƽ� ���� => ����ϴ� ���α׷��� �ۼ�

import java.util.Scanner;
public class �迭6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] names = new String[5];
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<names.length; i++) {
			System.out.print((i+1) + "��° �̸� �Է� : ");
			names[i] = scan.next();
		}
		
		// ���
		for(String name: names) {
			System.out.println(name);
		}
		
		
		// for-each => �迭, ����ü(Collection)
		/*
		 *   int[] data = {1,2,3,4,5};
		 *   for(int i=0; i<data.length; i++) {
		 *      System.out.println(data[i]);
		 *   }
		 *   
		 *   for(int i:data) {
		 *      System.out.println(i);
		 *   }
		 */
		
		
	}

}
