/*
 *    자바에서 제공하는 라이브러리
 *    => 자바
 *       1) 사용자 정의
 *       2) 라이브러리
 *       ============== 1)+2) ==> 조립
 *       
 *       자바 제공 라이브러리
 *       java.lang : import를 하지 않고 사용
 *         = String : 문자열과 관련된 클래스
 *            1) equals : 문자열 비교
 *            2) trim() : 좌우의 공백 제거
 *            3) indexOf(), lastIndexOf()
 *            4) length()
 *            5) startsWith(), endsWith()
 *            6) subString()
 *            7) split()
 *            8) valueOf()
 *         = System : 종료, 입출력, GC
 *            1) gc
 *            2) exit
 *         = Object : 모든 클래스의 상위 클래스, 객체 생성과 소멸을 담당하는 클래스
 *            1) clone() : 복제
 *            2) finalize() : 소멸자
 *         = Math : 수학
 *            1) random()
 *            2) ceil()
 *         = StringBuffer
 *            1) toString()
 *            2) append() : 문자열 결합
 *         = Thread
 *       java.util : 유용하게 사용할 수 있는 클래스의 집합
 *         = Scanner
 *         = StringTokenizer 
 *         = Collection
 *         = ArrayList, Vector, LinkedList, Map : 자료구조(메모리 저장 관리)
 *       java.io
 *         = Reader, Writer (2byte) - 한글
 *         = InputStream, OutputStream (1byte)
 *         = File
 *         = ObjectInputStream, ObjectOutputStream 
 *       java.net
 *         = Socket
 *         = URL
 */

// finalize()

class My {

	public My() {
		System.out.println("My 생성자 함수 호출(객체 생성)");
	}
	public void display() {
		System.out.println("My display() Call...");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("객체 소멸");
	}
	
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		My m=new My(); // 생성
		m.display();   // 활용
		m=null;        // 소멸
		System.gc();   // 메모리 소멸
		
	}

}
