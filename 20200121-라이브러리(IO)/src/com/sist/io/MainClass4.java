package com.sist.io;
/*
 *   파일 정보
 *    1) 파일명  : getName()
 *    2) 경로~파일명 : getPath()
 *    3) 경로명 : getParent()
 *    4) 수정일 : lastModified => long ==> new Date()
 *    5) 파일 생성 : createFile()
 *    6) 파일크기 : length
 *    7) 속성(읽기/쓰기/감춤) : canRead, canWrite, isHidden(), isFile() ==> boolean
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file=new File("c:\\javaDev\\Hello.java");
			if(file.exists()) {
				System.out.println("***파일명: "+file.getName());
				System.out.println("경로명: "+file.getParent());
				System.out.println("***전체경로: "+file.getPath());
				System.out.println("***크기: "+file.length());
				System.out.println("읽기전용: "+file.canRead());
				System.out.println("쓰기전용: "+file.canWrite());
				System.out.println("숨김파일: "+file.isHidden());
				System.out.println("***파일여부: "+file.isFile());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일");
				String day=sdf.format(new Date(file.lastModified()));
				System.out.println("***수정일: "+day);
			}
		} catch(Exception ex) {}
	}

}
