import java.util.Scanner;

/*
 *   국어, 영어, 수학 점수를 입력 받아서 평균
 *     => 평균 60 이상이면 pass, nopass
 *     
 *     
 *     
 *   나이를 입력 ==> 15세 이상이면 (영화관람가능) / 이하(영화관람불가)
 *   
 *   
 *   좌석 => 1 2 3 4 5 => 1,2,4 좌석예매 불가능 / 3,5 좌석예매 가능
 *    
 */
public class 삼항연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("국어 점수 : ");
//		int kor = scan.nextInt();
//		
//		System.out.print("영어 점수 : ");
//		int eng = scan.nextInt();
//		
//		System.out.print("수학 점수 : ");
//		int math = scan.nextInt();
//		
//		int avg = (kor + eng + math) / 3;
//		
//		String result = avg>=60 ? "Pass" : "NonPass";
//		
//		System.out.println("결과 : " + result);
		
		
		
		
		
		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("나이 입력 : ");
//		int age = scan.nextInt();
//		
//		String result = age>=15 ? "영화관람가능" : "영화관람불가";
//		System.out.println(result);
		
		
		
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("좌석 입력(1~5) : ");
		int seat = scan.nextInt();
		
		String result = (seat==3 || seat==5) ? "좌석예매 가능" : "좌석예매 불가능";
		System.out.println(result);
		
	}

}
