/*
 *   ���õ� ������ ��� ���
 *   
 *   => ���� �������� ��� �Ѱ��� �̸����� ���� : �迭
 *      ==========
 *      int[] arr = {1,2,3,4,5};   // ���� ���� ���� ��
 *      int[] arr = new int[5];    // ���� ���� ��, Ŭ������ ���� ä�� �� => ������ �������� ä��
 *      
 *      int[] arr = {'A','B',...};
 *      double[] arr = {10,20,30,...};
 *      String[] arr = {"","","","",...};  => Ŭ���� (���� ���°��:null)
 *      
 */
public class �迭4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "aaaaa";
		String b = null;
		String c = "";
		a.length();
		b.length();   //java.lang.NullPointerException
		c.length();
		

	}

}
