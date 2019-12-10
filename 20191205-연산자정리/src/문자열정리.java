/*
 *    String : ���ڿ� ����
 *     
 *     ���
 *     1) ���ڿ� �и�  substring()
 *     2) ���� ã��     indexOf(), lastIndexOf() 
 *     3) ���� ��     equals, equalsIgnoreCase
 *     4) ���鹮�� ����   trim()  => �¿��������
 *     5) ��ҹ��� ����   toUpperCase, toLowerCase
 *     6) ��� ���������� ���ڿ��� ����   valueOf()
 *     7) ������ ����   length()
 *     8) ���� ���� => replace, replaceAll
 *     
 *     
 *     ��� ��ü�� 4����Ʈ�� ����
 */
public class ���ڿ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = " Hello Java!! ";
		System.out.println("���ڼ� : " + s.length());
		System.out.println(s.substring(0,5));
		System.out.println(s.replace("l", "k"));
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s);
		System.out.println(s.trim());
		System.out.println(s.indexOf("l"));
		System.out.println(s.lastIndexOf("l"));
		
		
		String s1 = "Hello";
		String s2 = "hello";
		
		// equalsIgnoreCase ��ҹ��� ����X
		String res = s1.equalsIgnoreCase(s2) ? "����" : "�ٸ���";
		System.out.println(res);
		
		
		
	}

}
