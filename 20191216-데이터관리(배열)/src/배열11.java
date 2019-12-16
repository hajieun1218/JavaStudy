/*
 *   5개의 난수 발생 ==> 배열
 *   30 20 40 50 10
 *   ===============> 50 40 30 20 10
 *   
 *   <<선택정렬>>
 */
public class 배열11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = new int[5];
		
		for(int i=0; i<5; i++) {
			num[i] = (int)(Math.random()*100) + 1;
			System.out.print(num[i] + " ");
		}
		
		for(int i=0; i<num.length-1; i++) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i]<num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		System.out.println();
		for(int i:num) {
			System.out.print(i + " ");
		}
	}
}
