/*
 *   ���ǹ� : true/false �� �� ������ ó���� ���� �Ѵ�
 *      ����) 
 *          if (���ǹ�)
 *             ���๮��  ==> ���ǹ� true
 *          else 
 *             ���๮��  ==> ���ǹ� false
 *             
 *          ��)
 *             ����� => �ΰ��� ���� �Է� => ó��(������)
 *             
 *             ===> if ��� ==> error ����, ���ϴ� ������
 *                            ==========
 *                             ���� ó��
 */
public class �������ǹ�_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = 1;
		
		if(b == 0)  // error ����
			System.out.println("0���� ���� �� �����ϴ�");
		else        // ���� ó��
			System.out.println("a/b = " + (a/b));
		
		
	}

}
