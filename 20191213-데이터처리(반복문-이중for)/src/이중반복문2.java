/*
 *    break : 반복을 중단할 때
 *    continue : 특정 부분을 제외할 때 
 */
public class 이중반복문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=10; i++) {
			if(i==5)
				break;
			System.out.println(i);
		}
		
		System.out.println("=== continue ===");
		for(int i=1; i<=10; i++) {
			if(i==5 || i==7)
				continue;
			System.out.println(i);
		}
		
		System.out.println("=== 짝수만 출력 ===");
		for(int i=1; i<=10; i++) {
			if(i%2!=0)
				continue;
			System.out.println(i);
		}
	}

}
