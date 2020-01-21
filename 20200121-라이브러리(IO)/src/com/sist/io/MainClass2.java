package com.sist.io;
// 폴더
/*
 *    1) 폴더에 있는 모든 파일 읽기 ==> listFiles() => 리턴형 : File[]
 *    2) 폴더 생성                         ==> mkdir()     => 리턴형 : void
 *    3) 폴더 삭제                         ==> delete()    => 리턴형 : void
 */
import java.io.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File dir=new File("c:\\oracle");
//			if(!dir.exists()) {  //oracle폴더가 존재하지 않으면
//				// oracle폴더를 만들어라
//				dir.mkdir();
//			}
//			System.out.println("oracle폴더 생성 완료");
			
			if(dir.exists()) {
				dir.delete();
			}
			System.out.println("oracle폴더 삭제 완료");
		}catch(Exception ex) {}
	}

}
