/*
 *   *** 효율적 연산
 *    && => 왼쪽 false => 오른쪽은 연산에서 제외
 *    || => 왼쪽 true => 오른쪽은 연산에서 제외
 */
public class 이항연산자_논리연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 알파벳을 저장 후에 소문자, 대문자
		char c = 'A';
		
		// 대문자=>소문자, 소문자=>대문자 변경
		// A(65) a(87) => 32차이
		char result = (c>='A' && c<='Z') ? (char)(c+32) : (char)(c-32);
		System.out.println(c + "는(은) " + result);
		
		
	}

}
