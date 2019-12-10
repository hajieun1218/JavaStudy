/* 
 *    산술연산자(+, -, *, /, %) : 다른 데이터형을 사용했을 경우
 *       1) int 이하 데이터형(byte, short, char) => 연산처리 => int   (초과된 값이 있을 수 있으므로  int로 받는다)
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
public class 이항연산자_산술연산자 {

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
