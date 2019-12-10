// 정수 입력 => 년도 윤년
/* 
 *   4년마다
 *   100년마다 제외
 *   400년마다 
 *   ================= 로마시대 (윤년)
 *   year%4==0
 *   year%100!=0
 *   year%400==0
 *   
 */
import java.util.Scanner;;
public class 제어문_조건문4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력: ");
		int year = scan.nextInt();
		
		// 윤년 조건
		if((year%4==0 && year%100!=0) || year%400==0)
		{
			System.out.println(year + "년도는 윤년입니다");
		}
		if(!((year%4==0 && year%100!=0) || year%400==0))
		{
			System.out.println(year + "년도는 윤년이 아닙니다");
		}
		
	}

}
