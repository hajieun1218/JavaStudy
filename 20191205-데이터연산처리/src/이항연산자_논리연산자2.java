
public class 이항연산자_논리연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		boolean b1 = (6<7) && (7==7);
		System.out.println("b1 = " + b1);
		
		b1 = (6>7) && (7==7);
		System.out.println("b1 = " + b1);

		b1 = (6>7) || (7==7);
		System.out.println("b1 = " + b1); 
		
		b1 = (6<7) || (7==7);
		System.out.println("b1 = " + b1);
		
		b1 = (6>7) || (7!=7);
		System.out.println("b1 = " + b1);
	}

}
