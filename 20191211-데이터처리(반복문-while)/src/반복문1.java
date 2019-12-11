/*
 *   반복문
 *   
 *   while     ==> 선조건(실행이 안될 수도 있다)
 *   do~while  ==> 후조건(반드시 한번 이상 실행)
 *      형식)
 *          초기값
 *          do {
 *             실행문장;
 *             증가식;
 *          }while(조건문);
 *   for
 */
public class 반복문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1~10까지 3개씩 출력 (while문 사용)
		int i = 1;
		while(i<=10) {
			System.out.print(i + "\t");
			if(i%3==0)
				System.out.println();
			i++;
		}
		
		
		
		// 1~10까지 3개씩 출력 (do~while문 사용)
		System.out.println("\n<<do~while>>");
		
		i = 1;
		do {
			System.out.print(i + "\t");
			if(i%3==0)
				System.out.println();
			i++;
		} while(i<=10);
		
		
		
		
		// 1~10까지 3개씩 출력 (for문 사용)
		System.out.println("\n<<for>>");
		
		for(i=1; i<=10; i++) {
			System.out.print(i + "\t");
			if(i%3==0)
				System.out.println();
		}
		
		
		
	}

}
