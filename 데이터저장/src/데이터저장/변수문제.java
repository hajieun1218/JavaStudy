package 데이터저장;

/*
 *   이름, 국어, 영어, 수학 점수를 저장한 후
 *   이름, 국어, 영어, 수학, 총점, 평균을 출력
 */

public class 변수문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 데이터 저장
		String name = "홍길동";
		int kor = 80;
		int eng = 85;
		int math = 91;
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;  //  정수/정수 = 정수 이므로 3(X) => 3.0(O)
		
		// 출력
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg + "\n");
		
		System.out.print("평균 ; " + avg);
		System.out.printf("평균 : %.2f", avg);
		
		
		
	}

}
