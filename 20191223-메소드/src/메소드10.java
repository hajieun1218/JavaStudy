import java.util.Scanner;

// ���� �Է� => ���
/*
 *   �Է�
 *   ���
 *   ===
 *   ����
 */
public class �޼ҵ�10 {

	static int input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = scan.nextInt();
		
		return num;
	}
	
	static void print(int num) {
		System.out.println(num);
	}
	
	static void process() {
		print(input());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		process();
	}

}
