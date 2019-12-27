/*
 *    자바 (클래스가 여러개) ==> 한 파일, 별도로 파일을 만들어서 사용
 *    한개의 파일에서 사용
 *    =============
 *      class A
 *      class C
 *      class D
 *      public class B  ==> public 클래스는 한개만 존재
 *    ================ B.java  ==> public 있는 클래스가 저장명
 *      class A
 *      class B
 *    ================ A.java / B.java 아무거나 가능
 */

// News 데이터형
class News {
	String title;
	String content;
	String author;
	String regdata;
//	static String site;
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 저장 => 통으로 저장
		// 메모리 만들기
		News n1 = new News();
		n1.title = "\"8일째 1위\"..'백두산', 450만명 돌파..'천문' 개봉 첫날 14만 흥행";
		n1.content = "[OSEN=하수정 기자] 영화 '백두산'이 성탄절에 이어 문화의 날에도 흥행 정상을 지켰고, '천문: 하늘에 묻는다'가 첫날 2위에 오르며   박스오피스 판도가 또 바뀌었다.";
		n1.author = "OSEN";
		n1.regdata = "19.12.27";
		
//		n1 = new News();
//		System.out.println(n1.title);  // => null
		
		News n2 = new News();
		n2.title = "진선규·성유빈 영화 '카운트' 캐스팅";
		n2.content = "배우 진선규와 성유빈이 영화 ‘카운트’에서 호흡을 맞춘다고 배급사 CJ엔터테인먼트가 27일 전했다.";
		n2.author = "아시아경제";
		n2.regdata = "19.12.27";
		
		News n3 = new News();
		n3.title = "'백두산' 450만 돌파.. '천문' 2위 출발";
		n3.content = "영화 ‘백두산’(감독 이해준, 김병서)이 관객수 500만 돌파를 눈앞에 뒀다.";
		n3.author = "쿠키뉴스";
		n3.regdata = "19.12.27";
		
		// 출력
		System.out.println(n1.title);
		System.out.println(n2.title);
		System.out.println(n3.title);
	}

}
