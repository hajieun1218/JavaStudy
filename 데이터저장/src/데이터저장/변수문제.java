package ����������;

/*
 *   �̸�, ����, ����, ���� ������ ������ ��
 *   �̸�, ����, ����, ����, ����, ����� ���
 */

public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ������ ����
		String name = "ȫ�浿";
		int kor = 80;
		int eng = 85;
		int math = 91;
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;  //  ����/���� = ���� �̹Ƿ� 3(X) => 3.0(O)
		
		// ���
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("���� : " + math);
		System.out.println("���� : " + sum);
		System.out.println("��� : " + avg + "\n");
		
		System.out.print("��� ; " + avg);
		System.out.printf("��� : %.2f", avg);
		
		
		
	}

}
