import java.util.*;

public class 연산자문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int 기본급 = 1500000;
		int 수당 = 55000;
	    double 세금 = 기본급 * 0.1;
	    double 실수령액 = 기본급 + 수당 - 세금;
	    
	    System.out.println("실수령액 : " + (int)실수령액 + "원");
		
	    System.out.println("---------------------------");
	    
	    String name = "홍길동";
	    String department = "개발부";
	    String position = "대리";
	    int sal = 1500000;
	    
	    System.out.println("이름 : " + name);
	    System.out.printf("부서 : " + department + "\n");
	    System.out.print("직위 : " + position + "\n" + "급여 : " + sal + "원" + "\n");
	    
	    System.out.println("---------------------------");
	    
	    String inputName;
	    int kor, eng, mat;
	    
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Input name : ");
	    inputName = scan.next();
	    System.out.print("kor : ");
	    kor = scan.nextInt();
	    System.out.print("eng : ");
	    eng = scan.nextInt();
	    System.out.print("mat : ");
	    mat = scan.nextInt();
	    
	    System.out.println("이름 : " + inputName);
	    System.out.println("합계점수 : " + (kor + eng + mat) + "점");
	    System.out.printf("평균점수 : %.1f", (kor+eng+mat)/3.0);
	    
	    System.out.println("\n---------------------------");
	    
	    int numOfApples = 123;
	    int sizeOfBucket = 10;
//	    int numOfBucket = numOfApples % sizeOfBucket == 0 ? numOfApples / sizeOfBucket : numOfApples / sizeOfBucket + 1;
	    int numOfBucket = (int)Math.ceil(((double)numOfApples / (double)sizeOfBucket));
	    System.out.println("필요한 바구니의 수 : " + numOfBucket);
	    
	    
	}

}
