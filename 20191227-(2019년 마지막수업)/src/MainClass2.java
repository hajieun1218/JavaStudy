/*
 *    변수
 *     = instance 변수  : 생성 => new로 메모리를 만들 경우
 *     = static 변수       : 컴파일 될 때  ==> 메소드에서는 사용이 불가능, 클래스에서만 사용
 *     ==========================> 자동 초기화
 *     = 지역변수                 : 메소드 호출 시
 *     ==========================> 반드시 초기화를 한다
 */
class Data {
	// 선언만 가능 , 구현 X
	//          (구현 => 연산처리, 제어문, 메소드호출) => {}안에서만 사용
	int a=10;     // 0
	float f;      // 0.0F
	double d;     // 0.0
	boolean boo;  // false
	long l;       // 0L
	char c = 'A'; // '\0'
	String s;     // null  => 주소값이 없음
	String ss = "";  // null이랑 다름
	static int aa; // 0
}

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Data.aa);
		
//		Data dd = new Data();
//		System.out.println(dd.a);
//		System.out.println(dd.boo);
//		System.out.println(dd.c);
//		System.out.println(dd.d);
//		System.out.println(dd.f);
//		System.out.println(dd.l);
//		System.out.println(dd.s);
//		System.out.println(dd.ss);
		
		
	}

}
