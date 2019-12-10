import java.util.Scanner;

// 정수 입력 => 1,2,3,4
public class 제어문_조건문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 상수
		final int UP = 1;
		final int DOWN = 2;
		final int LEFT = 3;
		final int RIGHT = 4;
		
		int x = 0, y = 800;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("키보드 입력(위:1,아래:2,왼쪽:3,오른쪽:4) : ");
		int input = scan.nextInt();
		
		if(input == UP)
		{
			System.out.println("위쪽으로 올라간다!!");
			y-=5;
		}
		if(input == DOWN)
		{
			System.out.println("아래로 내려간다!!");
			y+=5;
		}
		if(input == LEFT)
		{
			System.out.println("왼쪽으로 이동한다!!");
			x-=5;
		}
		if(input == RIGHT)
		{
			System.out.println("오른쪽으로 이동한다!!");
			x+=5;
		}
			
		
			
		
		
		
	}

}
