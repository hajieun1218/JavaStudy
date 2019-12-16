import java.util.Scanner;
public class 배열2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[3];
		Scanner scan = new Scanner(System.in);
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1)+ "번째 정수 입력 : ");
			arr[i] = scan.nextInt();
			if(arr[i]>max)
				max = arr[i];
		}
		System.out.println("가장 큰 값 : " + max);
		
	}

}
