/*
 *   1~100������ ��
 *   ¦�� / Ȧ�� �� ���
 *   for�� ���
 *   
 *    ���
 *    1~100������ �� : 5050
 *    1~100������ ¦���� �� : 
 *    1~100������ Ȧ���� �� :
 */
public class �ݺ���4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum=0, even=0, odd=0;
		
		for(int i=1; i<=100; i++) {
			sum+=i;
			if(i%2==0)
				even+=i;
			else
				odd+=i;
		}
		System.out.println("1~100������ �� : " + sum);
		System.out.println("1~100������ ¦���� �� : " + even);
		System.out.println("1~100������ Ȧ���� �� : " + odd);
		
		
	}

}
