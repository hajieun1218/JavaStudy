/*
 *    �������̵�
 *    ======= �߻�Ŭ����,�������̽����� ���� ���
 *    
 *     ����� ����
 *     �޼ҵ�� ����
 *     �Ű����� ����
 *     ������ ����
 *     ������������ Ȯ��
 *     
 *       ==> interface I
 *           {
 *               int a;  ==> ���� ===> public static final ==> int a=10;
 *               void display();  ===> public abstract void display()
 *           }
 *           public A implements I
 *           {
 *               void display() {  ===> ����  ==> ���������� ����  ==> public void display()
 *               }
 *           }
 */
/*
 *    ����� �ȵǴ� Ŭ���� : ���� Ŭ����  (public final class)
 *    ��� ���� : static, ������
 */


class Super {
	public void display() {
		System.out.println("Super : display() Call");
	}
}

// Super�κ��� ��� �ޱ�
class Sub extends Super {
	// �������̵�
	public void display() {
		System.out.println("Sub : display() Call");
	}
}

class Sub2 {
	Super su = new Super() {
		// ����� �ȹ޾Ƶ� �������̵� ����
		public void display() {
			System.out.println("Sub2 : display() Call");
		}
	};
}

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sub sub = new Sub();
		sub.display();
		
		Sub2 s = new Sub2();
		s.su.display();
		
	}

}
