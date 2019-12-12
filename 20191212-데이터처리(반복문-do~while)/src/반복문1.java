/*
 *   do~while: 한번 이상을 수행하는 반복문 (사용빈도 많이 없다)
 *   형식) 
 *       // C,C++,C#,Java => 초기값 0부터 시작 (문자열, 자료구조(List,Set,Map), 배열)
 *       // 오라클, 정보처리     => 1부터 시작
 *       
 *       초기값             => 항상 1이다(X) 
 *       do {
 *          실행문장; => 여러문장을 사용할 수 있다
 *          증감식;  => 여러개도 가능  i++, i--, i+=2. i-=2
 *       } while(조건문);
 */
public class 반복문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1~10까지
		int i=1;  // 1~10 => 루프변수
		do {
			System.out.println("i=" + i);
			i++;
		} while(i<=10);
		
		System.out.println("<<10~1>>");
		do {
			i--;
			System.out.println("i=" + i);
		} while(i>1);
		
	}

}
