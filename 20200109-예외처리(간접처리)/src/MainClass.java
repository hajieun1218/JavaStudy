import java.io.IOException;
import java.sql.SQLException;

class MyException {
	// 구현된 내용중에 예상되는 에러가 있다 => 시스템에 알려준다 => throws
	public void display() throws NumberFormatException, NullPointerException, ArithmeticException {
		System.out.println("MyException : display Call...");
	}
	
	public void display1() throws IOException, SQLException {
		System.out.println("MyException : display1 Call...");
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 메모리 할당
		MyException m = new MyException();  // m주소에 display() 저장
		m.display();
		// NumberFormatException, NullPointerException, ArithmeticException
		// RuntionException ==> 생략가능
		
		
		try {
			m.display1();
//		} catch(Exception e) {}
		} catch(Throwable e) {}
	}

}
