/*
 *   *** ȿ���� ����
 *    && => ���� false => �������� ���꿡�� ����
 *    || => ���� true => �������� ���꿡�� ����
 */
public class ���׿�����_�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���ĺ��� ���� �Ŀ� �ҹ���, �빮��
		char c = 'A';
		
		// �빮��=>�ҹ���, �ҹ���=>�빮�� ����
		// A(65) a(87) => 32����
		char result = (c>='A' && c<='Z') ? (char)(c+32) : (char)(c-32);
		System.out.println(c + "��(��) " + result);
		
		
	}

}
