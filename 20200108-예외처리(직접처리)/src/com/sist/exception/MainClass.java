package com.sist.exception;
/*
 *    예외처리 : 소스상에서 수정이 가능한 에러(가벼운 에러: 프로그래머가 처리가 가능)
 *            ex) 0으로 나눈다, 파일명이 틀리다, ip가 틀리다, URL주소가 틀리다, 배열의 범위가 초과, ...
 *            
 *    예외처리의 목적
 *      1) 에러가 발생 시 예방을 하는 프로그램
 *      2) 에러가 발생 시 => 정상상태 유지 방법
 *      
 *    
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr=new int[6];
		try {
			for(int i=0;i<=6;i++) {
				arr[i]=(int)(Math.random()*45)+1;
			}
		} catch(Exception e) {
			System.out.println("오류발생");
		}
		
		for(int i=0;i<6;i++) {
			System.out.print(arr[i]+" ");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
