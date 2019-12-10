/*
 *   다중조건문 : 여러개의 조건을 제시하고 해당 조건 1개만 수행이 되게 만든다
 *   
 */

// 성적 처리
// 3개의 점수를 받아서 => 총점을 출력, 평균을 출력, 학점을 출력

import java.util.Scanner;
public class 다중조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 필요한 변수 선언  => 다시 사용하기 전에 값을 할당해주어야함
		int kor, eng, math, total, temp;
		double avg;
		char score;
		
		// 입력
		Scanner scan = new Scanner(System.in);
		// new : 메모리 할당
		// Scanner(System.in) : 변수에 대한 초기화(생성자)
		// 클래스 => 사용자정의 데이터형 (변수+메소드)
		
		System.out.print("국어 점수 : ");
		kor = scan.nextInt();
		System.out.print("영어 점수 : ");
		eng = scan.nextInt();
		System.out.print("수학 점수 : ");
		math = scan.nextInt();
		
		total = kor+eng+math;
		avg = total/3.0;
		
		temp = (int)avg;  //= total/3
		
		if(temp>=90)
			score = 'A';
		else if(temp>=80)
			score = 'B';
		else if(temp>=70)
			score = 'C';
		else if(temp>=60)
			score = 'D';
		else
			score = 'F';
		
		
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		System.out.println("학점 : " + score);
		
		
		
		
		
	}

}
