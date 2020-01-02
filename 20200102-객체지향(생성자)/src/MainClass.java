/*
 *   Ŭ������ �������
 *   =========================
 *     ����(��������, �������)
 *     => �ٸ� Ŭ�������� ����� ����
 *     => �޸𸮿��� �����Ǵ� ������ ���α׷� ���� �� 
 *        (�޸� => heap)
 *   =========================
 *     ������ : ��������� ���� �ʱ�ȭ ���
 *     Ư¡)
 *         1. Ŭ������� ����
 *         2. �������� ���� (void�� ������)
 *         3. �����ڴ� �������� ���� �� �ְ�
 *            ������� ���� ���� �ִ� ==> JVM�� �ڵ����� �����ڸ� ����
 *         4. �����ε��� �����Ѵ�
 *            ======
 *             1) �Ѱ��� Ŭ�����ȿ��� ���� �̸��� �޼ҵ带 ������ ���
 *             2) �Ű������� �ٸ��� (�Ű������� ���������� �ٸ��ų� ������ �ٸ��� �ٸ� �޼ҵ�� �ν�)
 *             3) �������� �������
 *             4) ����� ����
 *         5. ��� ���� ���� (������, static)
 *   ========================= 
 *      ==> ��ɹ��� ���� => ���õ� ����� ��Ƽ� ó��(������ ���α׷�)
 *     �޼ҵ� : ��������� Ȱ�� => ���
 *            ����ó�� = ��� ó��
 *            => ����� ��û�� ó��
 *   =========================
 */
public class MainClass {

	String name;
	String sex;
	int age;
	
	// �ʱ�ȭ
	public MainClass() {
		// �ʱ�ȭ ==> ������, ��Ʈ��ũ, �����ͺ��̽�
		name = "��û��";
		sex = "����";
		age = 25;
	}
	
	public MainClass(String name, String sex, int age) {
		
		// this�� static
		System.out.println("this = " + this);
		
		// �������� ������� �̸� ���� ==> ���������� �켱 ����
		this.name = name;
		this.sex = sex;
		this.age = age;
		// �ڽ��� ��ü �ּ� => this => �ݵ�� �޼ҵ� �ȿ����� ��� ����
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// static�� �ƴ� ������ ��������� ������ ���� �����ؾ� �Ѵ�(new)
		// �����ڴ� ȣ��ÿ� �ݵ�� new�� �����Ѵ�
//		MainClass mc = new MainClass();
//		
//		System.out.println(mc.name);
//		System.out.println(mc.sex);
//		System.out.println(mc.age);
		
		
		MainClass mc1 = new MainClass("�̼���", "����", 30);
		// MainClass.this = mc1
		System.out.println("mc1 = " + mc1);
		System.out.println(mc1.name);
		System.out.println(mc1.sex);
		System.out.println(mc1.age);
		
		MainClass mc2 = new MainClass("��û��", "����", 20);
		System.out.println("mc2 = " + mc2);
		System.out.println(mc2.name);
		System.out.println(mc2.sex);
		System.out.println(mc2.age);
		
		MainClass mc3 = new MainClass("������", "����", 35);
		System.out.println("mc3 = " + mc3);
		System.out.println(mc3.name);
		System.out.println(mc3.sex);
		System.out.println(mc3.age);
		
		
		// �ּҰ� �ٸ���
		System.out.println(new MainClass("�ڹ���", "����", 10).name);
		System.out.println(new MainClass("�ڹ���", "����", 10).sex);
		System.out.println(new MainClass("�ڹ���", "����", 10).age);
		
		
	}

}
