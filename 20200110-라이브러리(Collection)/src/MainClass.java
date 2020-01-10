/*
 *    컬렉션 : 데이터를 메모리에 저장하는 방법 (쉽게 저장하고 쉽게 사용), 표준화가 되는 상태
 *          여러개 데이터를 쉽게 제어가 가능
 *          가변 배열 => 데이터 개수를 클래스에서 제어
 *          
 *          * 단점 : 서로 다른 데이터타입을 저장할 수 있다 => 데어터타입 통일 => 제네릭스 타입 <데이터타입>
 *                 제네릭 데이터타입 => 클래스형으로 들어가야함 => <int>(X) <Integer>(O)
 *                 저장할 때 같은 데이터형을 저장하는 것이 제어하기 편리하다
 *                 
 *                 
 *    종류
 *                     Collection
 *                         |
 *       ------------------------------------
 *       |                  |                |
 *     List                Set              Map                        => 인터페이스
 *     ====               =====            =====                       => 인터페이스를 구현한 클래스
 *   ArrayList           HashSet          Hashtable
 *   Vector              TreeSet          HashMap : Hashtable을 보완
 *   LinkedList
 *   *순서를 가지고 있다           *순서가 존재하지 않는다          *key,value => 순서는 없다
 *   *중복데이터를 허용            *중복데이터를 허용 X      *key => 중복 허용하지 않는다
 *                                        *value => 중복을 허용
 *     
 *   ===============================================================
 *   
 *      자료구조 => 메모리에 저장된 데이터 관리
 *                         =======
 *                          읽기, 쓰기, 검색, 수정, 삭제
 *                          ======================
 *                          메소드 => 쓰기 => add(데이터)
 *                                       add(index,데이터)
 *                                  읽기 => get(index)
 *                                  수정 => set(index,데이터)
 *                                  삭제 => remove(index)  => 하나만 삭제
 *                                        remove(데이터)   => 중복된 데이터 모두 삭제
 */

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList list=new ArrayList();
		// 추가
		list.add("홍길동");
		list.add(30);
		list.add("서울");
		list.add("1111-1111");
		list.add(180.5);
		list.add("A");
		
		// 데이터 읽기
		String name=(String)list.get(0);
		int age=(int)list.get(1);
		String addr=(String)list.get(2);
		String tel=(String)list.get(3);
		Double ki=(Double)list.get(4);
		String aa=(String)list.get(5);
		
		// 출력
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("주소:"+addr);
		System.out.println("전화:"+tel);
		System.out.println("키:"+ki);
		System.out.println("혈액형:"+aa);
		
		
		
		
		
	}

}
