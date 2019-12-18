
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("====== [4-1] ======");
		/*
		 *   x>10 && x<20
		 *   ch!=' ' || ch!='\t'
		 *   ch=='x' || ch=='X'
		 *   ch >='0' && ch<='9'
		 *   (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')
		 *   (year%400==0) || (year%4==0 && year%100!=0)
		 *   (powerOn == false)? true;false
		 *   str.equals("yes")
		 */
		
		
		System.out.println("====== [4-2] ======");
		int sum = 0;
		for(int i=1; i<=20; i++) {
			if(i%2!=0 || i%3!=0) {
				System.out.print(i + " ");
				sum += i;
			}
		}
		System.out.println("\n1~20 정수 중 2 또는 3의 배수가 아닌 수의 총합 : " + sum);
		
		
		
		
		System.out.println("====== [4-3] ======");
		sum = 0;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				sum += j;
			}
		}
		System.out.println("1+(1+2)+(1+2+3)+...+(1+2+3+...+10) : " +sum);
		
		
		
		
		System.out.println("====== [4-4] ======");
		int num = 1;
		sum = 0;
		while(true) {
			if(num%2==0)
				sum-=num;
			else
				sum+=num;
			
			if(sum >= 100)
				break;
			num++;
		}
		System.out.println("i = " + num + " / 총합 : " + sum);
		
		
		
		
		System.out.println("====== [4-5] ======");
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		num = 0;
		while(num<=10) {
			int j=0;
			while(j<=num) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			num++;
		}
		
		
		
		System.out.println("====== [4-6] ======");
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=6; j++) {
				if(i+j==6) {
					System.out.println("(" + i + "," + j + ")");
				}
					
			}
		}
		
	}

}
