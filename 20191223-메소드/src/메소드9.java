import java.util.Scanner;

// 국어 영어 수학 점수를 받아서
// 총점 평균 학점을 출력하는 메소드
/*
 *   1. 입력
 *   2. 총점
 *   3. 평균
 *   4. 학점
 *   5. 출력
 */
public class 메소드9 {

	// 1. 입력
	static int[] input() {
		int[] score = new int[3];
		String[] msg = {"국어", "영어", "수학"};
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			System.out.print(msg[i] + "점수 : ");
			score[i] = scan.nextInt();
		}
		
		return score;
	}
	
	// 2. 총점
	static int total(int[] score) {
		int sum = 0;
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		
		return sum;
	}
	
	// 3. 평균
	static double avg(int sum) {
		return sum/3.0;
	}
	
	// 4. 학점
	static char hakjum(double avg) {
		char score = 'A';
		switch((int)(avg/10)) {
		case 10:
		case 9:
			score = 'A';
			break;
		case 8:
			score = 'B';
			break;
		case 7:
			score = 'C';
			break;
		case 6:
			score = 'D';
			break;
		default:
			score = 'F';
		}
		
		return score;
	}
	
	// 5. 출력
	static void print(int[] score, int sum, double avg, char hakjum) {
		System.out.printf("%d %d %d %d %.2f %c\n",
				score[0], score[1], score[2], sum, avg, hakjum);
	}
	
	
	static void process() {
		int[] score = input();
		int total = total(score);
		double avg = avg(total);
		char hakjum = hakjum(avg);
		
		print(score, total, avg, hakjum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process();
	}

}
