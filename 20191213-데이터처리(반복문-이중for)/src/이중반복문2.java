/*
 *    break : �ݺ��� �ߴ��� ��
 *    continue : Ư�� �κ��� ������ �� 
 */
public class ���߹ݺ���2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=10; i++) {
			if(i==5)
				break;
			System.out.println(i);
		}
		
		System.out.println("=== continue ===");
		for(int i=1; i<=10; i++) {
			if(i==5 || i==7)
				continue;
			System.out.println(i);
		}
		
		System.out.println("=== ¦���� ��� ===");
		for(int i=1; i<=10; i++) {
			if(i%2!=0)
				continue;
			System.out.println(i);
		}
	}

}
