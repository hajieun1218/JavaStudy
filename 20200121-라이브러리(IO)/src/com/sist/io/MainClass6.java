package com.sist.io;
import java.io.*;
// ���� ���� (���� ���ε�)
/*
 *     �б� : int read(), int read(byte[],off,len)
 *          ===         ===
 *           ���ڹ�ȣ               ���� ����Ʈ ��
 *     ���� : write(byte[]), write(String)
 *     �ݱ� : close()
 */
public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis=new FileInputStream("c:\\image\\1_4.png");
			FileOutputStream fos=new FileOutputStream("c:\\oracle\\1.png");
			
			int i=0;
			byte[] buffer=new byte[1024];
			
			// i: ���� ����Ʈ ����
			while((i=fis.read(buffer, 0, 1024))!=-1) {
				fos.write(buffer, 0, i);
			}
			fis.close();
			fos.close();
			
			System.out.println("���� ���� �Ϸ�");
		} catch(Exception ex) {}
	}

}
