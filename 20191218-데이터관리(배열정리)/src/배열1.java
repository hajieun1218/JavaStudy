/*
 *   1. 묶어서 사용(데이터)
 *      배열  ===> 클래스 ===> 패키지 ===> 라이브러리(jar)
 *      
 *   2. 자바 ==> 오라클 ==> HTML(CSS,JavaScript) ==> JSP ==> MVC ==> Spring ==> Kotlin(모바일)
 *                     =============================    ================
 *                                Front                       Back
 *                                
 *                                
 *    배열 단점 : 고정적 ===> 가변형 (ArrayList)
 *             같은 데이터형만 모아서 사용
 *    ===
 *     선언시 => 메모리 크기를 결정
 */

// 달력
import java.util.*;
import java.text.*;
/*
 *   달력
 *     1) 년도, 월 입력
 *     2) 요일 
 *     3) 마지막 날
 *     4) 출력
 */
public class 배열1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		while(true) {
//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:dd");
//			
//			System.out.println(sdf.format(date));
//			try {
//				Thread.sleep(1000);
//			}catch(Exception ex) {}
//		}
		
		
		//년도, 월
		char[] strWeek = {'일','월','화','수','목','금','토'};
		
		// MONTH => 0부터 시작
		// DAY_OF_WEEK => 1부터 시작
		Calendar cal = Calendar.getInstance();
		int y = cal.get(cal.YEAR);
		int m = cal.get(cal.MONTH)+1;
		int d = cal.get(cal.DATE);
		int w = cal.get(cal.DAY_OF_WEEK);
		System.out.println("======" + y + "년도  " + m + "월 " + d + "일 " + strWeek[w-1] + "요일 ======");
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		
		System.out.println("====== 2019년 12월 18일 수요일 ======");
		System.out.println(year + "년도 " + month + "월");
		System.out.println("\n");
		
//		System.out.print("일\t");
//		System.out.print("월\t");
//		System.out.print("화\t");
//		System.out.print("수\t");
//		System.out.print("목\t");
//		System.out.print("금\t");
//		System.out.print("토\t");
		
		
		for(int i=0; i<7; i++) {
			System.out.print(strWeek[i] + "\t");
		}
		
		// 1일자의 요일을 구한다
		// 전년도의 12/31 => 총합
		int total = (year-1)*365
				  + (year-1)/4
				  - (year-1)/100
				  + (year-1)/400;
		
		// 전달까지 총합
		int[] lastDay = {31,8,31,30,31,30,
				         31,31,30,31,30,31};
		if((year%4==0 && year%100!=0) || year%400==0) 
			lastDay[1] = 29;
		else
			lastDay[1] = 28;
		
		for(int i=0; i<month-1; i++) {
			total += lastDay[i];
		}
		
		
		// +1 ===> %7 ===> 요일을 구한다
		total++;  // 각달의 1일자
		int week = total%7;
		
		System.out.println();
		for(int i=1; i<=lastDay[month-1]; i++) {
			if(i==1) {
				for(int j=0; j<week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) {
				week = 0;
				System.out.println();
			}
		}
		
		
	}

}
