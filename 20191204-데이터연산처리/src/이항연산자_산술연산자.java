/* 
 *    ���������(+, -, *, /, %) : �ٸ� ���������� ������� ���
 *       1) int ���� ��������(byte, short, char) => ����ó�� => int   (�ʰ��� ���� ���� �� �����Ƿ�  int�� �޴´�)
 *           byte + byte => int
 *           char + byte => int
 *           short + byte + char => int
 *           
 *           byte + int => int
 *           short + char + int => int
 *           
 *           short + char + int + double => double  ===> String
 *             "" + 77 ==> "77"
 *             "" + 7.5 ==> "7.5"
 *             "" + true ==> "true"
 *           
 */
public class ���׿�����_��������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//byte b = 10;
		//byte c = 20;
		//int d = b+c;
		//byte d2 = (byte)(b+c);
		//System.out.println("d2 = " + d2);
		
		byte b = (byte)300;
		System.out.println("b = " + b);
		System.out.println(Integer.toBinaryString(300));
		
		/*
		 *   300 => 100101100
		 *   
		 *      1  /  00101100 => 44
		 */
		
		
		//int a = 10+20*3;
		
		
	}

}
