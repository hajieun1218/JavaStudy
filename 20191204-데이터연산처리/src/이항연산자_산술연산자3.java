// % => ������ ������
/*
 *    ������ => ����ȯ
 *            ��� : / , %
 *                 / => 0���� ���� �� ����
 *                      ���� / ���� = ����
 *                      ���� / �Ǽ� = �Ǽ�
 *                 % => ������ ���� ��ȣ�� ���󰣴�
 *                      ��� % ���(����) => ���
 *                      ���� % ���� (���) => ����
 *                      
 *                      5 % 2 => 1
 *                      5 % -2 => 1
 *                      -5 % 2 => -1
 *                      -5 % -2 => -1
 *                      
 */
public class ���׿�����_���������3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 30;
		double b = 4.0;
		double c = a / b;
		System.out.println("c : " + c);
		
		
		
		// ������
		int d1 = 5 % 2;
		int d2 = -5 % 2;
		int d3 = -5 % -2;
		int d4 = 5 % -2;
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		System.out.println("d4 = " + d4);
		
		
		
		int e = 369;
		
		int h100 = e / 100;
		int h10 = (e % 100) / 10;
		int h1 = e % 10;
		
		System.out.println("100�ڸ� : " + h100);
		System.out.println("10�ڸ� : " + h10);
		System.out.println("1�ڸ� : " + h1);
		
		
		
		
		
		int money = 65430;
		System.out.println("���� = " + money / 10000);
		System.out.println("õ�� = " + money % 10000 / 1000);
		System.out.println("��� = " + money % 1000 / 100);
		System.out.println("�ʿ� = " + money % 100 / 10);
		
//		int won = 65430;
//		String s = String.valueOf(won);
//		System.out.println("���� = " + s.substring(0, 1));
//		System.out.println("õ�� = " + s.substring(1, 2));
//		System.out.println("��� = " + s.substring(2, 3));
//		System.out.println("�ʿ� = " + s.substring(3, 4));
		
		
		String s = 100 + 10.5 + "" + 'A' + 10f + 100L;
		System.out.println(s);
		
		
	}

}
