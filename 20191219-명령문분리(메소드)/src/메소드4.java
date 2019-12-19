/*
 *   게시판
 *     목록출력 (매개변수 : 페이지, 리턴형 : (배열))
 *     내용보기 (매개변수 : 게시물번호, 리턴형 : (클래스))
 *     찾기(매개변수 : 사용자검색어, 리턴형 : (배열))
 *     글쓰기
 *     수정하기
 *     답변하기
 *     삭제하기
 */

import java.util.Scanner;

public class 메소드4 {

	static void gugudan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.printf("%d*%d=%d\n",dan, i, dan*i);
		}
	}
	
	static String gugudan2(int dan) {
		String result = "";
		for(int i=1; i<=9; i++) {
			result += dan + "*" + i + "=" + (dan*i) + "\n";
		}
		return result;
	}
	
	static void process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = scan.nextInt();
		
		// 구구단 출력
//		gugudan(dan);
		String res = gugudan2(dan);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process();
		
	}

}
