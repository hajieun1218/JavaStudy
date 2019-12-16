/*
 *   �迭(Array)
 *   1) ���� �����͸� ������ ��Ƽ� �Ѱ��� ���������� ����
 *   2) �迭 ����ÿ� �ڵ����� �������� �޸𸮸� ����
 *                     ===========
 *                     => ���۰� ���� �ϰ������� ������ �ִ�
 *                     => 0 ~ �迭 ����(�ݺ��� ����)
 *   3) ���� : ������
 *   4) ���ó => ���õ� �����Ͱ� 3�� �̻��̸� => �迭
 *   5) ���
 *       1. ����
 *          ��������[] �迭��;   // �ڹ� ���� ����
 *          �������� �迭��[];   // C/C++
 *       2. �ʱⰪ ����
 *           int[] arr = {10, 20, 30, 40, 50};
 *           int[] arr = new int[5];    // new �ʱⰪ ==> ��ü�� 0
 *                                         double[] arr = new double[3]; 0.0
 *                                         String[] arr = new String[3]; null
 *                                         char[] arr = new char[3]; '\0'
 *                                         boolean[] arr = new boolean[3]; false
 *       3. Ȱ��
 *          => ���� ����
 *             ÷��(�ε���)�� �̿� ==> arr[0] = 100;
 *          => ��� ==> �迭�� ��� ÷�ڴ� 0���� ���� ==> 
 *                    for(int i=0; ...)
 *       4. �ʰ��ϰų� ���� �� ���� => �����߻�
 *          ArrayIndexOfBoundsException => �迭�� ������ �ʰ�
 *       5. �迭�� ���� ==> �迭��.length
 *                           
 *    6) �ּҸ� �����ؼ� �����͸� ���� ==> ��������
 *        (�迭,Ŭ����)
 */ 


// ���� 3�� �Է� => �Է¹��� �����͸� ���
import java.util.Scanner;
public class �迭1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a,b,c;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� : ");
		a = scan.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		b = scan.nextInt();
		System.out.print("������ ���� �Է� : ");
		c = scan.nextInt();
		
		// ���� => a,b,c �߿� ���� ū ���� ���
		int max = 0;
		if(a>max)
			max = a;
		if(b>max)
			max = b;
		if(c>max)
			max = c;
		
		System.out.println("���� ū �� : " + max);
		
		
		
	}

}
