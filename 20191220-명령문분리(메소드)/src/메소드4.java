// 1~45 ���� �߻� => �ߺ����� 6�� �߻�
/*
 *   �迭 ==> 6��
 *   
 *   for(6Ƚ��) {
 *      while(�ߺ�) {
 *         ���� �߻�
 *         �迭�� ���� �� �����Ϳ� ���� ��
 *      }
 *      �迭 ����
 *   }
 */
public class �޼ҵ�4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� ���� ����
		int[] com = new int[6];
		// ����
		int su = 0;
		// �� => �ߺ�
		boolean bCheck = false;
		
		for(int i=0; i<6; i++) {
			bCheck = true;
			while(bCheck) {
				su = (int)(Math.random()*45) + 1;
				bCheck = false;
				for(int j=0; j<i; j++) {
					if(com[j] == su) {
						bCheck = true;
						break;
					}
				}
			}
			com[i] = su;
		}
		
		// ���
		for(int i:com) {
			System.out.print(i + " ");
		}
		
	}

}
