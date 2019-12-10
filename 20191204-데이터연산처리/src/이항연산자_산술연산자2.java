import java.util.*; //Scanner (값을 받을 때 사용)

public class 이항연산자_산술연산자2 {

	public static void main(String[] args) {

		int a = (int)(Math.random()*100)+1;
		// Math.random() => 0.0 ~ 0.99  ==> 0.0 ~ 99.0 ==> 정수형 0~99 +1
		// 1 ~ 100
		
//		System.out.println("a = " + a);
//		
//		Scanner scan = new Scanner(System.in);
//		//   System.in => 키보드 입력 값을 받는다
//		System.out.print("정수 입력 : ");
//		int b = scan.nextInt();
//		System.out.println("b = " + b);
		
		
		
		// 국어, 영어, 수학 점수를 받아서 총점, 평균(소수점 2자리까지 출력)
		int kor, eng, math, total;
		double avg;
		
		// 입력할 수 있는 기능의 클래스를 가져온다
		Scanner scan = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		kor = scan.nextInt();
		System.out.print("영어 점수 : ");
		eng = scan.nextInt();
		System.out.print("수학 점수 : ");
		math = scan.nextInt();
		
		total = kor + eng + math;
		avg = total / 3.0;
		
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f", avg);
		
		
	}

}
