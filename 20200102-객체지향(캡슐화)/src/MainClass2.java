class MyData {
	int[] arr = new int[6];
//	arr[0] = 10;  // ���� => ���� ==> instance��� ���
	{
		for(int i=0; i<6; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
	}
	
	public MyData() {
		for(int i=0; i<6; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
	}
	
	static int[] arr2 = new int[6];
	// static ������ static��� ���
	static{
		for(int i=0; i<6; i++) {
			arr2[i] = (int)(Math.random()*100)+1;
		}
	}
	
}

/*
 *    ������ �ʱ�ȭ
 *    
 *    int a=10;
 *    a=100;(X)
 *    =================
 *    {
 *       a=100;
 *    }
 *    ================= �ʱ�ȭ ���(��������� �ʱ�ȭ)
 *    static {
 *       a=200;
 *    }
 *    =================
 */

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		MyData m1 = new MyData();
//		for(int i=0; i<6; i++) {
//			System.out.print(m1.arr[i] + " ");
//		}
//		
//		System.out.println();
//		MyData m2 = new MyData();
//		for(int i=0; i<6; i++) {
//			System.out.print(m2.arr[i] + " ");
//		}
		
		
		
//		for(int i=0; i<6; i++) {
//			System.out.print(MyData.arr2[i] + " ");
//		}
		
		
		
		MyData m1 = new MyData();
		for(int i=0; i<6; i++) {
			System.out.print(m1.arr[i] + " ");
		}
		
	}

}
