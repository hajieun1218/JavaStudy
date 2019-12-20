/*
 *   String : ���ڿ��� ����
 *   
 *     java.lang => import�� ������ �� �ִ�
 *     ���ڿ��� �����ϴ� ���
 *       1) String ������ = "Hello Java";
 *       2) String ������ = new String("Hello Java");  // ���� ���ڿ� => ������ ����
 *                       ====
 *                       ���ο� �޸𸮿� ����
 *     
 *      String���� �����ϴ� ���
 *        1) equals : ����� ���ڿ� ������ ���� Ȯ��(true/false)
 *             ID,PWD ==> �α��� (��ҹ��� ����)
 *             ���ڿ��� (==)(X)
 *             
 *             String s = "Hello";
 *             String s1 = "Hello";
 *             String s2 = new String("Hello");
 *             
 *             if(s==s1) ===> true
 *             if(s==s2) ===> false;
 *             if(s.equals(s1)) ===>true
 *             
 *        2) substring : ���ڿ��� �ڸ� �� 
 *             substring(int start)
 *             substring(int start, int end)
 *             
 *             String s = "0123456789";
 *             substring(3) => "3456789"
 *             String s = "112��, 15���̻������";
 *             substring(0,3) => "112"
 *             
 *        3) length : ���ڿ� ����
 *             String s = "Hello ȫ�浿";
 *             s.length ==> 9��
 *             
 *        4) trim : �¿��� ���鹮�� ����
 *             String s = "Hello Java";
 *                  => s.length => 10��
 *                  => s.trim().length => 10��  (�߰� ������ ����X)
 *                  
 *        5) startsWith, endsWith : ���� ���ڿ��� ���� ��, ������ ���ڿ��� ���� ��
 *                                  ==> �˻��� �� ���� ���
 *             startsWith("�ڹ�");
 *             
 *        6) indexOf, lastIndexOf
 *             ������ ��ġ : (indexOf:�տ���, lastIndexOf:�ڿ���)
 *             String s = "Hello Java";
 *             s.indexOf('a');     ==> 7
 *             s.lastIndexOf('a'); ==> 9
 *             
 *        7) split
 *             String s = "�̺���, ������, ������, ������, ����";
 *             String[] names = s.split(",");
 *             
 *             ���Խ�
 *             ====
 *              211.238.142.181
 *              211.238.142.180
 *              211.238.142.1
 *              211.238.142.23
 *              211.238.1.1
 *              ==> [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}
 *                  0���� 9���� / 1-3�ڸ�
 *        
 *        8) toUpperCase, toLowerCase : �빮�� ��ȯ, �ҹ��� ��ȯ
 *             String s = "Hello";
 *             s.toUpperCase();  ==> HELLO
 *             s.toLowerCase();  ==> hello
 *             
 *        9) replace, replaceAll 
 *           =======
 *           ���� ==> String s = "Hello Java";
 *                  s.replace('a','b');  ==> Hello jbvb 
 *                  
 *           replaceAll ==> ���Խ�
 *             String s = "113��";
 *             s.replaceAll("[^0-9]","");  ==> 113 (���ڻ��� �����)
 *             s.replaceAll("^[0-9]","");  ==>     (���ڷ� �����ϴ�)
 *             s.replaceAll("[^0-9]$","");  ==>    (���ڷ� ������)
 *             s.replaceAll("[^��-�R]","");  ==>    (�ѱۻ��� �����)
 *             s.replaceAll("[^A-Za-z]","");  ==>  (�������� �����)
 *        
 *         10) contains : ���Ե� ���ڸ� ã�� ���
 *               
 */
import java.util.Scanner;

public class ���ڿ�Ŭ���� {

	static String[] autoComplate(String data) {
		String[] ss = {
				"�ڹٿ� JSP","�ڹ� ���α׷���","������ 5","Ajax�� JSP","�������� ����Ʈ",
				"�ڹ� ����Ŭ","MVC ����","��Ʋ���� �ȵ���̵�","��Ʋ�� ���α׷�","������ ������",
				"ȥ�ڹ��� �ڹ�","�������� ���α׷�","�� ���α׷�","�ڹ� �����α׷�","����Ŭ �ڹ�"};
		String[] findData = new String[10];
		
		int j=0;
		for(int i=0; i<ss.length; i++) {
//			if(ss[i].startsWith(data)) {
			if(ss[i].contains(data)) {
				findData[j] = ss[i];
				j++;
			}
		}
		return findData;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� �Է� : ");
		String data = scan.next();
		
		String[] fd = autoComplate(data);
		for(int i=0; i<fd.length; i++) {
			if(fd[i] != null) {
				System.out.println(fd[i]);
			}
		}
		
	}

}
