import java.util.Scanner;
public class 배열5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int year, month;
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		year = scan.nextInt();
		System.out.print("월 입력 : ");
		month = scan.nextInt();
		
		int[] lastDay = {31, 28, 31, 30, 31, 30,
				         31, 31, 30, 31, 30, 31};
		if((year%4==0 && year%100!=0) || year%400==0)
			lastDay[1] = 29;
		else
			lastDay[1] = 28;
		
		System.out.println(year + "년 " + month + "월의 마지막 날은 " + lastDay[month-1]);
		
	}

}
