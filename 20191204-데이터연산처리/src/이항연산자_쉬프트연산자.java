/*
 *    ����Ʈ������(��Ʈ�̵�������)
 *      <<(�����̵�)   >>(�������̵�)
 *      
 *       10<<2
 *       1010
 *     101000  => 40
 *      
 *      X << Y  ==> X * 2^Y
 *                  10 * 4 ==> 40
 *      
 *       10>>2
 *       1010
 *       0010(10)  => 2
 *       
 *       X >> Y  ==> X / 2^Y
 *                   10 / 4 ==> 2
 *                   
 *      
 */
public class ���׿�����_����Ʈ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 14 << 3;
		int b = 14 >> 3;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}

}
