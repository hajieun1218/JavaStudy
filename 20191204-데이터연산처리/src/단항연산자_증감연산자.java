/*
 *    =================
 *      method 공간 (static)
 *    =================
 *      stack => 메모리 관리({}이 끝나면 저장으로 회수)  | 지역변수
 *    =================
 *      heap => 사용자가 관리 => 가비지컬렉션 멤버변수       | 전역변수 
 *    =================
 * 
 */
public class 단항연산자_증감연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10;
		a--;  // 후치연산
		a--;
		a--;
		System.out.println("a = " + a);
		
		int b = 10;
		--b;  // 전치연산
		--b;
		--b;
		System.out.println("b = " + b);
		
		int c = 10;
		int d = c--;
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		
		int e = 10;
		int g = --e;
		System.out.println("e = " + e);
		System.out.println("g = " + g);
		
		
	}

}
