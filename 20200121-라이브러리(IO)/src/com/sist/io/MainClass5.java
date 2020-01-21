package com.sist.io;

/*
 *    File �Ӽ� ==> File �����
 *    
 *     FileInputStream, FileOutputStream  ==> 1byte
 *     FileReader     , FileWriter        ==> 2byte
 */
import java.io.*;
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// ������ ������
			File file=new File("C:\\javaDev\\javaStudy\\20200121-���̺귯��(IO)\\src\\com\\sist\\io\\MainClass.java");
//			FileInputStream fis=new FileInputStream(file);
			FileReader fis=new FileReader(file);
			// ������ => �������� �����ڸ� ������ ���� �� �ִ�
			
			int i=0; // ���� �б� => int read() => ASC�� �о�´�
			String data="";
			// i: ���ڹ�ȣ
			while((i=fis.read())!=-1) {   // -1�� EOF(End Of File)
//				System.out.print((char)i);
				data+=String.valueOf((char)i);  // �����Ͱ� ������ StringBuffer
			}
			System.out.println(data);
			fis.close();
			
			
			/*
			 *    r: �б�
			 *    w: ����
			 *    a: �߰�
			 */
			
			File file2=new File("c:\\image\\data.txt");
			if(!file2.exists()) {
				file2.createNewFile();
			}
			// �ٽ� �����ϸ�=> ������ �ִ� ���� ����� �����
			// true => append��� => ���� �߰��ϱ�
			FileWriter fos=new FileWriter(file2, true); 
			fos.write(data);  
			fos.close();
			System.out.println("���� ���� �Ϸ�");
			
			
			
			
			/* 
			 *   Ŭ����
			 *   ====
			 *    1) �������
			 *       1. ������� : (������뺯��(�ν��Ͻ� ����), ���뺯��(��������))
			 *                  private int a; ==> ��������� ����(new) �Ŀ� ����
			 *                  private static int b; ==> Ŭ���� �δ�
			 *                  
			 *                  �⺻��, Ŭ����, �迭 ===> ��������
			 *                        =========
			 *                         ����� ���� ��������
			 *                  
			 *                  �޼ҵ� �ȿ��� ����ϴ� ���� : ��������
			 *                  
			 *       2. �޼ҵ�
			 *           = ���𸸵� �޼ҵ�(�߻�޼ҵ�) => �̿ϼ��� Ŭ����
			 *             ====> �ϼ��� �ؼ� ���(�߻�Ŭ����,�������̽�)
			 *             public void display();
			 *           = ����+���� �޼ҵ�
			 *             public void display() {
			 *             }
			 *             
			 *           ====> ������� ��û���� �޾Ƽ� ó�� ����� �����ش�
			 *                 =========       ======
			 *                   �Ű�����                       ���ϰ�
			 *                   
			 *                   => ���ϰ� : ����� ���� ������� (int,String)
			 *                             �����Ͱ� ����(�迭,Ŭ����,�÷���)
			 *                   => �Ű����� : 3�� �̻��̸� => Ŭ������ ��� ����
			 *                   
			 *                   => �޼ҵ�� ����ȭ
			 *                      aaa();
			 *                      bbb();
			 *                      ccc();
			 *                      
			 *                   => �޼ҵ尡 �ַ� �ϴ� ���� : ���(Ŭ������ Ŭ����) => �޼���
			 *                                       ������ �����ϰ�, ������ ����
			 *                   
			 *       3. ������ : ��������� �ʱ�ȭ => ��������� ���� ����
			 *                                1) File�� �о ���� ����
			 *                                2) ��� ���
			 *                                *** class�� ����� ������ �� �� ����(���� ����, ����� ���ÿ� ������ ����)
			 */
		} catch(Exception ex) {}
	}

}
