/*
 *    String : 문자열 저장
 *     
 *     기능
 *     1) 문자열 분리  substring()
 *     2) 문자 찾기     indexOf(), lastIndexOf() 
 *     3) 문자 비교     equals, equalsIgnoreCase
 *     4) 공백문자 제거   trim()  => 좌우공백제거
 *     5) 대소문자 변경   toUpperCase, toLowerCase
 *     6) 모든 데이터형을 문자열로 변경   valueOf()
 *     7) 문자의 갯수   length()
 *     8) 글자 변경 => replace, replaceAll
 *     
 *     
 *     모든 객체는 4바이트로 저장
 */
public class 문자열정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = " Hello Java!! ";
		System.out.println("글자수 : " + s.length());
		System.out.println(s.substring(0,5));
		System.out.println(s.replace("l", "k"));
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s);
		System.out.println(s.trim());
		System.out.println(s.indexOf("l"));
		System.out.println(s.lastIndexOf("l"));
		
		
		String s1 = "Hello";
		String s2 = "hello";
		
		// equalsIgnoreCase 대소문자 구분X
		String res = s1.equalsIgnoreCase(s2) ? "같다" : "다르다";
		System.out.println(res);
		
		
		
	}

}
