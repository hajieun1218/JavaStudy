/*
 *    �ڹ� (Ŭ������ ������) ==> �� ����, ������ ������ ���� ���
 *    �Ѱ��� ���Ͽ��� ���
 *    =============
 *      class A
 *      class C
 *      class D
 *      public class B  ==> public Ŭ������ �Ѱ��� ����
 *    ================ B.java  ==> public �ִ� Ŭ������ �����
 *      class A
 *      class B
 *    ================ A.java / B.java �ƹ��ų� ����
 */

// News ��������
class News {
	String title;
	String content;
	String author;
	String regdata;
//	static String site;
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� => ������ ����
		// �޸� �����
		News n1 = new News();
		n1.title = "\"8��° 1��\"..'��λ�', 450���� ����..'õ��' ���� ù�� 14�� ����";
		n1.content = "[OSEN=�ϼ��� ����] ��ȭ '��λ�'�� ��ź���� �̾� ��ȭ�� ������ ���� ������ ���װ�, 'õ��: �ϴÿ� ���´�'�� ù�� 2���� ������   �ڽ����ǽ� �ǵ��� �� �ٲ����.";
		n1.author = "OSEN";
		n1.regdata = "19.12.27";
		
//		n1 = new News();
//		System.out.println(n1.title);  // => null
		
		News n2 = new News();
		n2.title = "�����ԡ������� ��ȭ 'ī��Ʈ' ĳ����";
		n2.content = "��� �����Կ� �������� ��ȭ ��ī��Ʈ������ ȣ���� ����ٰ� ��޻� CJ�������θ�Ʈ�� 27�� ���ߴ�.";
		n2.author = "�ƽþư���";
		n2.regdata = "19.12.27";
		
		News n3 = new News();
		n3.title = "'��λ�' 450�� ����.. 'õ��' 2�� ���";
		n3.content = "��ȭ ����λꡯ(���� ������, �躴��)�� ������ 500�� ���ĸ� ���տ� �״�.";
		n3.author = "��Ű����";
		n3.regdata = "19.12.27";
		
		// ���
		System.out.println(n1.title);
		System.out.println(n2.title);
		System.out.println(n3.title);
	}

}
