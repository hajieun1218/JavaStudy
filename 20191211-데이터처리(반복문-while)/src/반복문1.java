/*
 *   �ݺ���
 *   
 *   while     ==> ������(������ �ȵ� ���� �ִ�)
 *   do~while  ==> ������(�ݵ�� �ѹ� �̻� ����)
 *      ����)
 *          �ʱⰪ
 *          do {
 *             ���๮��;
 *             ������;
 *          }while(���ǹ�);
 *   for
 */
public class �ݺ���1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1~10���� 3���� ��� (while�� ���)
		int i = 1;
		while(i<=10) {
			System.out.print(i + "\t");
			if(i%3==0)
				System.out.println();
			i++;
		}
		
		
		
		// 1~10���� 3���� ��� (do~while�� ���)
		System.out.println("\n<<do~while>>");
		
		i = 1;
		do {
			System.out.print(i + "\t");
			if(i%3==0)
				System.out.println();
			i++;
		} while(i<=10);
		
		
		
		
		// 1~10���� 3���� ��� (for�� ���)
		System.out.println("\n<<for>>");
		
		for(i=1; i<=10; i++) {
			System.out.print(i + "\t");
			if(i%3==0)
				System.out.println();
		}
		
		
		
	}

}
