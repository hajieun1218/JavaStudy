/*
 *    Wrapper 클래스 : 기본형(int,long,...)을 쉽게 제어가 가능하게 만들어진 클래스
 *      int     => Integer  => BOXING, AUTOBOXING
 *        Integer ii=new Integer(10);
 *        int i=ii.valueOf();
 *        
 *        int i=ii;
 *        Integer ii=10;
 *        
 *      double  => Double
 *      byte    => Byte
 *      boolean => Boolean
 *      
 */

import java.util.Scanner;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Integer ii=new Integer(100);
//		int i=ii;
//		int k=1000;
//		Integer kk=k;
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("정수입력:");
//		String no1=scan.next();
//		System.out.print("정수입력:");
//		String no2=scan.next();
		
//		System.out.println(Integer.parseInt(no1)+Integer.parseInt(no2));
		
		String s="true";
		if(Boolean.parseBoolean(s)==true) {
			System.out.println("출력");
		}
		
		String score="4.5";
		System.out.println(Double.parseDouble(score)+1);
		
		boolean b=true;
		System.out.println(String.valueOf(b));
	}

}
