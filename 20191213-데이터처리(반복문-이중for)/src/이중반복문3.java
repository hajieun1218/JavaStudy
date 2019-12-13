/*
 *   구구단 출력 
 *   for, while문 사용
 */
public class 이중반복문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.printf("%2d * %2d = %2d\t", j, i, j*i);
			}
			System.out.println();
		}
		
		
		
		System.out.println("\nfor~while============");
		
		for(int i=1; i<=9; i++) {
			int j=2;   // 변수위치 확인
			while(j<=9) {
				System.out.printf("%2d * %2d = %2d\t", j, i, j*i);
				j++;
			}
			System.out.println();
		}
		
	}

}
