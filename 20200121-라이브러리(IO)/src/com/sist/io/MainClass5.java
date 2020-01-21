package com.sist.io;

/*
 *    File 속성 ==> File 입출력
 *    
 *     FileInputStream, FileOutputStream  ==> 1byte
 *     FileReader     , FileWriter        ==> 2byte
 */
import java.io.*;
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 파일은 절대경로
			File file=new File("C:\\javaDev\\javaStudy\\20200121-라이브러리(IO)\\src\\com\\sist\\io\\MainClass.java");
//			FileInputStream fis=new FileInputStream(file);
			FileReader fis=new FileReader(file);
			// 생성자 => 여러개의 생성자를 가지고 있을 수 있다
			
			int i=0; // 값을 읽기 => int read() => ASC를 읽어온다
			String data="";
			// i: 문자번호
			while((i=fis.read())!=-1) {   // -1은 EOF(End Of File)
//				System.out.print((char)i);
				data+=String.valueOf((char)i);  // 데이터가 많으면 StringBuffer
			}
			System.out.println(data);
			fis.close();
			
			
			/*
			 *    r: 읽기
			 *    w: 쓰기
			 *    a: 추가
			 */
			
			File file2=new File("c:\\image\\data.txt");
			if(!file2.exists()) {
				file2.createNewFile();
			}
			// 다시 실행하면=> 기존에 있던 내용 지우고 덮어쓰기
			// true => append모드 => 내용 추가하기
			FileWriter fos=new FileWriter(file2, true); 
			fos.write(data);  
			fos.close();
			System.out.println("파일 쓰기 완료");
			
			
			
			
			/* 
			 *   클래스
			 *   ====
			 *    1) 구성요소
			 *       1. 멤버변수 : (개별사용변수(인스턴스 변수), 공통변수(정적변수))
			 *                  private int a; ==> 저장공간을 생성(new) 후에 저장
			 *                  private static int b; ==> 클래스 로더
			 *                  
			 *                  기본형, 클래스, 배열 ===> 데이터형
			 *                        =========
			 *                         사용자 정의 데이터형
			 *                  
			 *                  메소드 안에서 사용하는 변수 : 지역변수
			 *                  
			 *       2. 메소드
			 *           = 선언만된 메소드(추상메소드) => 미완성된 클래스
			 *             ====> 완성을 해서 사용(추상클래스,인터페이스)
			 *             public void display();
			 *           = 선언+구현 메소드
			 *             public void display() {
			 *             }
			 *             
			 *           ====> 사용자의 요청값을 받아서 처리 결과를 보내준다
			 *                 =========       ======
			 *                   매개변수                       리턴값
			 *                   
			 *                   => 리턴값 : 경우의 수가 많은경우 (int,String)
			 *                             데이터가 많다(배열,클래스,컬렉션)
			 *                   => 매개변수 : 3개 이상이면 => 클래스로 묶어서 전송
			 *                   
			 *                   => 메소드는 동기화
			 *                      aaa();
			 *                      bbb();
			 *                      ccc();
			 *                      
			 *                   => 메소드가 주로 하는 역할 : 통신(클래스와 클래스) => 메세지
			 *                                       변경이 가능하고, 재사용이 가능
			 *                   
			 *       3. 생성자 : 멤버변수의 초기화 => 멤버변수에 값을 대임
			 *                                1) File을 읽어서 값을 대입
			 *                                2) 제어문 사용
			 *                                *** class의 블록은 구현을 할 수 없다(선언만 가능, 선언과 동시에 구현은 가능)
			 */
		} catch(Exception ex) {}
	}

}
