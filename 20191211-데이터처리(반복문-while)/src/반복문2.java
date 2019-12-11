// A~Z => 5개씩 출력

public class 반복문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		char alpha = 'A';
//		while(alpha<='Z') {
//			System.out.print(alpha + "\t");
//			if((alpha+1)%5==0)
//				System.out.println();
//			alpha++;
//		}
//		
//		System.out.println();
		
		
		

		int i = 1;
		boolean bCheck = true;
		char c = 'A';
		while(i<=26) {
			if(bCheck==true)
				System.out.print(c++ + "\t");
			else
				System.out.print((char)(c++ +32) + "\t");
			
			if(i%5==0) {
				System.out.println();
				bCheck = !bCheck;
			}
			i++;
		}
		
		
		
		
	}

}
