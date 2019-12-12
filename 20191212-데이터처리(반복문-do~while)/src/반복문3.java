// ===> 비효율적

import java.util.Scanner;;
public class 반복문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int kor,eng,math,total,avg;
		char score = 'A';
		
		int kor1,eng1,math1,total1,avg1;
		char score1 = 'A';
		
		int kor2,eng2,math2,total2,avg2;
		char score2 = 'A';
		
		int i=1;
		do { 
			if(i==1) {      // 첫번째 학생
				System.out.print("국어 점수 : ");
				kor = scan.nextInt();
				System.out.print("영어 점수 : ");
				eng = scan.nextInt();
				System.out.print("수학 점수 : ");
				math = scan.nextInt();

				total = kor + eng + math;
				avg = total / 3;

				char c = 'A';
				switch (avg / 10) {
				case 10:
				case 9:
					c = 'A';
					break;
				case 8:
					c = 'B';
					break;
				case 7:
					c = 'C';
					break;
				case 6:
					c = 'D';
					break;
				default:
					c = 'F';
				}
			}
			else if(i==2) { // 두번째 학생
				
			}
			else {          // 세번째 학생
				
			}
			i++;
		} while(i<=3);
		
	}

}
