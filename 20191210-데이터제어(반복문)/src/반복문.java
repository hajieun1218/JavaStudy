/*
 *   반복문
 *     ================= 선조건
 *     = for : 반복횟수 지정     
 *     = while : 지정이 없는 경우
 *		    초기값
 *        while(조건문)
 *        {
 *           실행문장
 *           증가식
 *        }     
 *     ================= 후조건
 *     = do~while       : 한번 이상은 반드시 수행
 *        초기값
 *        do
 *        {
 *           실행문장
 *           증가식
 *        } while(조건문)
 *     =================
 */
public class 반복문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int i = 1;
//		while(i<=10) {
//			System.out.println("i = " + i);
//			i++;
//		}
		
		
		
		
//		int i = 1;
//		int sum = 0;
//		while(i<=100) {
//			sum+=i;
//			System.out.println("i = " + i + ", sum = " + sum);
//			i++;
//		}
//		System.out.println("1~100까지의 합 : " + sum);
		
		
		
		
		
		
//		// 1~100까지 3,5,7의 배수의 합
//		int i = 1;
//		int sum3=0, sum5=0, sum7=0;
//		while(i<=100) {
//			if(i%3==0)
//				sum3+=i;
//			if(i%5==0)
//				sum5+=i;
//			if(i%7==0)
//				sum7+=i;
//			i++;
//		}
//		System.out.println("1~100까지의 3의 배수의 합 : " + sum3);
//		System.out.println("1~100까지의 5의 배수의 합 : " + sum5);
//		System.out.println("1~100까지의 7의 배수의 합 : " + sum7);
		
		
		
		
		
		// 대문자 알파벳 출력 (A~Z)
		char alpha = 'A';
		while(alpha<='Z') {
			System.out.print(alpha + " ");
			alpha++;
		}
		
		
	}

}
