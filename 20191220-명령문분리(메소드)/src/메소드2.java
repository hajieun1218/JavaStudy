// ���� 1�� �Է��� �޾Ƽ� => 2���� ���
// 10 ==> 16bit
// 0000 0000 0000 1010

import java.util.Scanner;

public class �޼ҵ�2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		
		// ����
		int input = scan.nextInt();  // ����� �Է°�
		int[] binary = new int[16];
		
//		System.out.println(Integer.toBinaryString(input));
		
		// �迭�� ��ġ
		int index = 15;
		
		while(true) {
			binary[index] = input%2;
			input = input/2;
			if(input==0)
				break;
			index--;
		}
		
		// ���
		for(int i=0; i<16; i++) {
			if(i%4==0 && i!=0) 
				System.out.print(" ");
			System.out.print(binary[i]);
		}
		
	}

}
