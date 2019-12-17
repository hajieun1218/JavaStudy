/*
 *   관련된 내용을 묶어서 사용
 *   
 *   => 같은 데이터형 묶어서 한개의 이름으로 제어 : 배열
 *      ==========
 *      int[] arr = {1,2,3,4,5};   // 값이 별로 없을 때
 *      int[] arr = new int[5];    // 값이 많을 때, 클래스에 값을 채울 때 => 공간을 만들어놓고 채움
 *      
 *      int[] arr = {'A','B',...};
 *      double[] arr = {10,20,30,...};
 *      String[] arr = {"","","","",...};  => 클래스 (값이 없는경우:null)
 *      
 */
public class 배열4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "aaaaa";
		String b = null;
		String c = "";
		a.length();
		b.length();   //java.lang.NullPointerException
		c.length();
		

	}

}
