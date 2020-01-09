import java.io.IOException;
import java.sql.SQLException;

class MyException {
	// ������ �����߿� ����Ǵ� ������ �ִ� => �ý��ۿ� �˷��ش� => throws
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

		// �޸� �Ҵ�
		MyException m = new MyException();  // m�ּҿ� display() ����
		m.display();
		// NumberFormatException, NullPointerException, ArithmeticException
		// RuntionException ==> ��������
		
		
		try {
			m.display1();
//		} catch(Exception e) {}
		} catch(Throwable e) {}
	}

}
