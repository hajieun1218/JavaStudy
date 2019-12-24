
public class 메소드1 {

	static void message() {
		System.out.println("Hello Java");
		return;  // 생략이 되면 ==> JVM이 자동으로 코딩을 해준다
	}
	static int aaa() {
		return 10;
	}
	static double bbb() {
		return 10.5;
	}
	static String ccc() {
		return "Hello";
	}
	static int[] ddd() {
		int[] arr = {1,2,3,4,5};
		return arr;
	}
	static int eee(int a) {
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		message();
		int a = aaa();
		double d = bbb();
		String s = ccc();
		int[] arr = ddd();
		int aa = eee(10);
		
	}

}
