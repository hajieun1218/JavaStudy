
public class ¸Þ¼Òµå7 {

	static void getData(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
	}
	
	static void getData2(String s) {
		s = "Hello";
	}
	
	static void getData3(int a) {
		a = 100;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "Java";
		getData2(a);
		System.out.println(a);
		
		int aa = 500;
		getData3(aa);
		System.out.println(aa);
		
		int[] arr = new int[5];
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		getData(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
	}

}
