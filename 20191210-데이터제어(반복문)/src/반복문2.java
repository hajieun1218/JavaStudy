/*
 *   while => while(true) : ���ѷ���
 *   for   => for(;;)     : ���ѷ���
 *   
 *   �ݺ��� ����
 *    1) continue => Ư�� ������ ����
 *    2) break    => �ݺ����� ����
 */

import java.util.Scanner;
public class �ݺ���2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// while  => 1~(������Է°�)������ ¦���� ��, Ȧ���� ��, ������ ���ؼ� ���
		
		int even=0, odd=0, total=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int num = scan.nextInt();
		
		int i = 1;
		while(i<=num) {
			if(i%2==0) {
				even+=i;
			}
			else {
				odd+=i;
			}
			i++;
		}
		System.out.println("¦���� �� : " + even);
		System.out.println("Ȧ���� �� : " + odd);
		System.out.println("���� : " + (even+odd));
		
		
	}

}
