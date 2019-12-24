/*
 *   �޼ҵ�
 *   1) ���� 
 *   2) ������ : �⺻��, Ŭ����, �迭
 *   3) �Ű����� : ����� ��û��
 *     ==> 3�� �̻��̸� ��� ��û => �迭, Ŭ����
 *         ex. ȸ������(Ŭ����)
 *             �Խ��� �۾���(Ŭ����)
 *   4) �Ű����� ���۹� 
 *      => call by value : �⺻��, String
 *                         �޸𸮸� ���� ����(����(��))
 *      => call by reference : �迭, Ŭ����
 *                             ���� �ּҸ� �̿��ؼ� ���� ����
 *   5) ȣ��
 *   
 *   ** ��� �޼ҵ�� ������ ������ ������ �ٽ� ȣ���� ��ġ�� ���ƿ´�
 *   ** �޼ҵ带 ������ ȣ��� => �Ѱ��� �޼ҵ尡 ������ �����ؾ� ���� �޼ҵ� ȣ��
 */

// �Ű����� ���� -> call by value

public class �޼ҵ� {

	static void swap(String a, String b) {
		System.out.println("������ swap : a = " + a + ", b = " + b);
		// a=10, b=20
		// a=Hello, b=Java
		
		// ����
		String temp = a;
		a = b;
		b = temp;
		
		System.out.println("������ swap : a = " + a + ", b = " + b);
		// a=20, b=10
		// a=Java, b=Hello
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "Hello";
		String b = "Java";
		swap(a,b);  // ����
		System.out.println("main swap : a = " + a + ", b = " + b);
		// a=10, b=20 ===> �ٸ� �޸� call by value
		// a=Hello, b=Java
	}

}
