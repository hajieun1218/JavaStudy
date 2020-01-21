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
					// 폴더 안에 파일이 있다면 파일 먼저 삭제
					for(File f:files) {
						f.delete();
					}
					dir.delete();
				}
				else {
					dir.delete(); 
				}
			}
			System.out.println("oracle폴더 삭제 완료");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
