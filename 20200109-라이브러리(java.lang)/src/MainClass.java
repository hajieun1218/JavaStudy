/*
 *    �ڹٿ��� �����ϴ� ���̺귯��
 *    => �ڹ�
 *       1) ����� ����
 *       2) ���̺귯��
 *       ============== 1)+2) ==> ����
 *       
 *       �ڹ� ���� ���̺귯��
 *       java.lang : import�� ���� �ʰ� ���
 *         = String : ���ڿ��� ���õ� Ŭ����
 *            1) equals : ���ڿ� ��
 *            2) trim() : �¿��� ���� ����
 *            3) indexOf(), lastIndexOf()
 *            4) length()
 *            5) startsWith(), endsWith()
 *            6) subString()
 *            7) split()
 *            8) valueOf()
 *         = System : ����, �����, GC
 *            1) gc
 *            2) exit
 *         = Object : ��� Ŭ������ ���� Ŭ����, ��ü ������ �Ҹ��� ����ϴ� Ŭ����
 *            1) clone() : ����
 *            2) finalize() : �Ҹ���
 *         = Math : ����
 *            1) random()
 *            2) ceil()
 *         = StringBuffer
 *            1) toString()
 *            2) append() : ���ڿ� ����
 *         = Thread
 *       java.util : �����ϰ� ����� �� �ִ� Ŭ������ ����
 *         = Scanner
 *         = StringTokenizer 
 *         = Collection
 *         = ArrayList, Vector, LinkedList, Map : �ڷᱸ��(�޸� ���� ����)
 *       java.io
 *         = Reader, Writer (2byte) - �ѱ�
 *         = InputStream, OutputStream (1byte)
 *         = File
 *         = ObjectInputStream, ObjectOutputStream 
 *       java.net
 *         = Socket
 *         = URL
 */

// finalize()

class My {

	public My() {
		System.out.println("My ������ �Լ� ȣ��(��ü ����)");
	}
	public void display() {
		System.out.println("My display() Call...");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("��ü �Ҹ�");
	}
	
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		My m=new My(); // ����
		m.display();   // Ȱ��
		m=null;        // �Ҹ�
		System.gc();   // �޸� �Ҹ�
		
	}

}
