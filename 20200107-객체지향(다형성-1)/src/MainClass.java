// 오버로딩

class Calc {
	public void display(int a) {
		System.out.println("a = " + a);
	}
	public void display(int a, int b, int c) {
		System.out.println("display(int a, int b, int c) call");
	}
	public void display(double a, int b, double c) {
		System.out.println("display(double a, int b, double c) call");
	}
	public void display(float a, char b, int c) {
		System.out.println("display(float a, char b, int c) call");
	}
	public void display(double a, double b, double c) {
		System.out.println("display(double a, double b, double c) call");
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Calc 객체 생성
		Calc c = new Calc();
		c.display('A');  // 작은 데이터형은 들어갈 수 있다
//		c.display(10.5);
		c.display(10, 10.5, 'A');
		
	}

}
