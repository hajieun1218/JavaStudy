/*
 *   do~while: �ѹ� �̻��� �����ϴ� �ݺ��� (���� ���� ����)
 *   ����) 
 *       // C,C++,C#,Java => �ʱⰪ 0���� ���� (���ڿ�, �ڷᱸ��(List,Set,Map), �迭)
 *       // ����Ŭ, ����ó��     => 1���� ����
 *       
 *       �ʱⰪ             => �׻� 1�̴�(X) 
 *       do {
 *          ���๮��; => ���������� ����� �� �ִ�
 *          ������;  => �������� ����  i++, i--, i+=2. i-=2
 *       } while(���ǹ�);
 */
public class �ݺ���1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1~10����
		int i=1;  // 1~10 => ��������
		do {
			System.out.println("i=" + i);
			i++;
		} while(i<=10);
		
		System.out.println("<<10~1>>");
		do {
			i--;
			System.out.println("i=" + i);
		} while(i>1);
		
	}

}
