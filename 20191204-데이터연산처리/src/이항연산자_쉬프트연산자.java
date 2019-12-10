/*
 *    쉬프트연산자(비트이동연산자)
 *      <<(왼쪽이동)   >>(오른쪽이동)
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
public class 이항연산자_쉬프트연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 14 << 3;
		int b = 14 >> 3;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}

}
