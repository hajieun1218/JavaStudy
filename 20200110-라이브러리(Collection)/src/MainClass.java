/*
 *    �÷��� : �����͸� �޸𸮿� �����ϴ� ��� (���� �����ϰ� ���� ���), ǥ��ȭ�� �Ǵ� ����
 *          ������ �����͸� ���� ��� ����
 *          ���� �迭 => ������ ������ Ŭ�������� ����
 *          
 *          * ���� : ���� �ٸ� ������Ÿ���� ������ �� �ִ� => ������Ÿ�� ���� => ���׸��� Ÿ�� <������Ÿ��>
 *                 ���׸� ������Ÿ�� => Ŭ���������� ������ => <int>(X) <Integer>(O)
 *                 ������ �� ���� ���������� �����ϴ� ���� �����ϱ� ���ϴ�
 *                 
 *                 
 *    ����
 *                     Collection
 *                         |
 *       ------------------------------------
 *       |                  |                |
 *     List                Set              Map                        => �������̽�
 *     ====               =====            =====                       => �������̽��� ������ Ŭ����
 *   ArrayList           HashSet          Hashtable
 *   Vector              TreeSet          HashMap : Hashtable�� ����
 *   LinkedList
 *   *������ ������ �ִ�           *������ �������� �ʴ´�          *key,value => ������ ����
 *   *�ߺ������͸� ���            *�ߺ������͸� ��� X      *key => �ߺ� ������� �ʴ´�
 *                                        *value => �ߺ��� ���
 *     
 *   ===============================================================
 *   
 *      �ڷᱸ�� => �޸𸮿� ����� ������ ����
 *                         =======
 *                          �б�, ����, �˻�, ����, ����
 *                          ======================
 *                          �޼ҵ� => ���� => add(������)
 *                                       add(index,������)
 *                                  �б� => get(index)
 *                                  ���� => set(index,������)
 *                                  ���� => remove(index)  => �ϳ��� ����
 *                                        remove(������)   => �ߺ��� ������ ��� ����
 */

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList list=new ArrayList();
		// �߰�
		list.add("ȫ�浿");
		list.add(30);
		list.add("����");
		list.add("1111-1111");
		list.add(180.5);
		list.add("A");
		
		// ������ �б�
		String name=(String)list.get(0);
		int age=(int)list.get(1);
		String addr=(String)list.get(2);
		String tel=(String)list.get(3);
		Double ki=(Double)list.get(4);
		String aa=(String)list.get(5);
		
		// ���
		System.out.println("�̸�:"+name);
		System.out.println("����:"+age);
		System.out.println("�ּ�:"+addr);
		System.out.println("��ȭ:"+tel);
		System.out.println("Ű:"+ki);
		System.out.println("������:"+aa);
		
		
		
		
		
	}

}
