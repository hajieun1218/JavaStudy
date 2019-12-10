//  컴퓨터 난수, 사용자 입력  ==> 가위,바위,보

import java.util.Scanner;
public class 선택조건문_예제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 0:가위, 1:바위, 2:보
		int com = (int)(Math.random()*3); //0~2
		
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) : ");
		int user = scan.nextInt();
		
		if(user==0)
			System.out.println("플레이어 : 가위");
		if(user==1)
			System.out.println("플레이어 : 바위");
		if(user==2)
			System.out.println("플레이어 : 보");
		
		
		if(com==0)
			System.out.println("컴퓨터 : 가위");
		if(com==1)
			System.out.println("컴퓨터 : 바위");
		if(com==2)
			System.out.println("컴퓨터 : 보");
		
		
		// 결과  ==> com-user
//		if(com==0) // 가위
//		{
//			if(user==0) // 가위  ==> 0
//				System.out.println("비겼다");
//			if(user==1) // 바위 ==> -1
//				System.out.println("플레이어 Win!");
//			if(user==2) // 보 ==> -2
//				System.out.println("컴퓨터 Win!");
//		}
//		if(com==1) // 바위
//		{
//			if(user==0) // 가위 ==> 1
//				System.out.println("컴퓨터 Win!");
//			if(user==1) // 바위 ==> 0
//				System.out.println("비겼다");
//			if(user==2) // 보 ==> -1
//				System.out.println("플레이어 Win!");
//		}
//		if(com==2) // 보
//		{
//			if(user==0) // 가위 ==> 2
//				System.out.println("플레이어 Win!");
//			if(user==1) // 바위 ==> 1
//				System.out.println("컴퓨터 Win!");
//			if(user==2) // 보 ==> 0
//				System.out.println("비겼다");
//		}
		
		
		// player=>-1,2  /  com=>-2,1
		int result = com-user;
		if(result==-1 || result==2)
			System.out.println("플레이어 Win!!");
		if(result==-2 || result==1)
			System.out.println("컴퓨터 Win!!");
		if(result==0)
			System.out.println("비겼다!!");
		
		
	}

}
