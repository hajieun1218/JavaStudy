import java.util.*;

class Human {
	String name;
	int age;
	
	public Human() {
		System.out.println("Human() Call...");
	}
}

/*
 *    ���� Ŭ����(����� ������ Ŭ����) : superŬ����, �θ�Ŭ����, BaseŬ����
 *    ���� Ŭ����(����� �޴� Ŭ����)  :  subŬ����,  �ڽ�Ŭ����, �Ļ�Ŭ����
 *    
 *    => ������ Ŭ������ ��� ������ ������ͼ� Ȯ���ϴ� ����
 *    => �ڹ��� Ŭ������ Object ����� ������ �ִ� (Object : �ڹ��� �ֻ��� Ŭ����)
 *    => static, �����ڴ� ����� �� ����
 *    => ������ �ߺ��� �ڵ��� ����
 *       ������ �������� ���� ��� 
 *    => ����� ������ Ŭ������ �׻� ũ��
 */
class Sawon extends Human {
	/*
	 *   ������ �Ⱥ������� ����� ������
	 *   String name;
	 *   int age;
	 */
	String dept;
	String loc;
	
	public Sawon() {
		System.out.println("Sawon() Call...");
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ArrayList<String> list = new ArrayList<String>();
//		list.add("ȫ�浿");
//		
//		String name = list.get(0);
		
		Sawon s = new Sawon();
		s.age = 30;
		s.name = "ȫ�浿";
		s.loc = "����";
		s.dept = "���ߺ�";
		
		System.out.println("�̸� : " + s.name);
		System.out.println("�μ� : " + s.dept);
		System.out.println("�ٹ��� : " + s.loc);
		System.out.println("���� : " + s.age);
		
	}

}
