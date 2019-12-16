/*
 *   3명의 학생 => 국어,영어,수학 점수를 입력받아서 => 출력
 *   =======================================
 *   80 80 80 240 B 2 80.0
 *   90 90 90 270 A 1 90.0
 *   70 70 70 210 C 3 70.0
 */

import java.util.Scanner;
public class 배열8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] math = new int[3];
		int[] total = new int[3];
		char[] score = new char[3];
		int[] lank = new int[3];
		double[] avg = new double[3];
		
		for(int i=0; i<3; i++) {
			System.out.print((i+1) + "번째 학생의 국어 점수 입력 : ");
			kor[i] = scan.nextInt();
			System.out.print((i+1) + "번째 학생의 영어 점수 입력 : ");
			eng[i] = scan.nextInt();
			System.out.print((i+1) + "번째 학생의 수학 점수 입력 : ");
			math[i] = scan.nextInt();
			
			total[i] = kor[i] + eng[i] + math[i];
			avg[i] = total[i] / 3.0;
			
			switch((int)avg[i]/10) {
			case 10:
			case 9:
				score[i] = 'A';
				break;
			case 8: 
				score[i] = 'B';
				break;
			case 7:
				score[i] = 'C';
				break;
			case 6:
				score[i] = 'D';
				break;
			default:
				score[i] = 'F';
			}
			
		}
		
		for(int i=0; i<3; i++) {
			System.out.printf(kor[i] + " " 
		                    + eng[i] + " " 
					        + math[i] + " " 
		                    + total[i] + " " 
					        + score[i] + " " 
		                    + "%.2f\n", avg[i]);
		}
		
	}

}
