/*
 *   for : 반복문(반복횟수가 지정)
 *   ====
 *    일반 for
 *       = 변수가 한개 이상일 수도 있음
 *         for(int i=0,j=1; i<=1 && j>=1; ....)
 *         
 *    향상된 for(JDK1.5이상) : 배열, 컬렉션(데이터베이스)
 *    
 *   ==========
 *   메소드 (일반메소드, 람다식(함수포인터):JDK1.8)
 */
public class 반복문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for(i=1; i<=10; i++) {
			System.out.println("i = " + i);
		}
		System.out.println("i = " + i);
	}

}
