/* 
 *   자바에서 제공하는 특수문자
 *   1) \n  => new line ==> 다음줄에 출력   System.out.println();
 *   2) \t  => tab ==> 일정 간격 
 *   3) \"  => " ==> 따옴표 출력 (인용부호)
 *      System.out.println("\"Hello Java\"");
 *      
 *      
 *      
 *      
 *    서식이 있는 출력 ==> JDK 1.5 이상부터
 *    
 *    1) %d  ==> 정수
 *      System.out.printf("%d%d%d", 100, 90, 60);       // 1009060
 *      System.out.printf("%5d%5d%5d", 100, 90, 60);    // --100---90---60  ==> 오른쪽 정렬
 *      System.out.printf("%-5d%-5d%-5d", 100, 90, 60); // 100--90---60---  ==> 왼쪽 정렬
 *    2) %f  ==> 실수
 *    3) %c  ==> 문자
 *    4) %s  ==> 문자열
 *    
 *    System.out.printf();
 *    이름    국어   영어   수학   총점
 *    홍길동  90  90  90  270
 */
public class 일주차정리2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("%d%d%d\n", 100, 90, 60);
		System.out.printf("%5d%5d%5d\n", 100, 90, 60);
		System.out.printf("%-5d%-5d%-5d\n", 100, 90, 60);
		
		System.out.printf("%-10.2f%-10.2f%-10.2f\n", 99.9999, 80.88, 60.6666666);
		
		System.out.printf("%2c%2c%2c\n", 'A', 'B', 'C');
		
		System.out.printf("%10s%10s%10s\n", "Hello", "Java", "!!");
		
		System.out.printf("%7s%5d%5d%5d%7.2f%c\n", "홍길동", 80, 80, 80, 80.000, 'B');
	}

}
