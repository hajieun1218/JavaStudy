package com.sist.io;
import java.io.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File dir=new File("c:\\oracle");
			if(dir.exists()) {
				File[] files=dir.listFiles();
				if(files.length>0) {
					// ���� �ȿ� ������ �ִٸ� ���� ���� ����
					for(File f:files) {
						f.delete();
					}
					dir.delete();
				}
				else {
					dir.delete(); 
				}
			}
			System.out.println("oracle���� ���� �Ϸ�");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
