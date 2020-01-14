package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
/*
    클래스의 종류
       = 일반 클래스
       = 추상 클래스(인터페이스)
          -> 하나의 클래스로 다른 클래스로 제어하기 위해서 사용
       = 내부 클래스
          
          1) 클래스 끼리 데이터를 공유 => static => 멤버클래스 (Thread)
          
             classA{
                
                class B{
                }
             }
             
             Server가 가지고 있는 모든 변수를 공유
          
          2) 상속 없이 오버라이딩을 사용할 때 => 익명의 클래스
 */

public class Server implements Runnable{
   /*
       접속을 담당 : Server
       
    */
   
   private ServerSocket ss;
   private final int PORT = 8888;
   private Vector<Client> waitVc = new Vector<Client>();   //->Client의 모든 정보를 저장 (ip,id,port를 전부 사용하기 위해서) 
   // 접속한 유저의 정보 // IP와  Port번호는 서버에 저장됨
   // 통신만 작동하는 쓰레드를 따로 만들어야한다.
   
   // 하나의 서버에서는 하나의 쓰레드만 동작해야한다.
   // 서버 가동 -> server = 메모리 할당을 한번만 사용
   public Server() {
      try {
         ss = new ServerSocket(PORT);
         // 기본 서버 = 50명 정보 임 -> 50명이 넘어가는 경우 종료됨
         // 개통 => bind , 대기상태 => listen
         System.out.println("server Start......");
      }catch(Exception ex) {}
   }
   @Override
   public void run() {
         while(true) {
         try {
            
            Socket s = ss.accept(); // Socket --> 클라이언트(유저) -> 유저의 접속정보를 서버에게 넘기면  넘겨받은 IP와 통신할 수 있도록 진행
         // 접속시에 클라이언트의 정보를 받아서 저장하고 -> 스레드로 전송
         // 접속시에 정보 ==> Socket(ip,port) => 접속을 하면 저장을 해야한다.
            System.out.println("접속 완료 =:"+s.getInetAddress().getHostAddress());
            Client client = new Client(s);
            client.start();
            waitVc.add(client);
            // 정보를 저장
            
         }catch(Exception ex) {}
         
         
         }
   }
   public static void main(String[] args) {
   
      Server server = new Server();
      new Thread(server).start();
      
   }
   /* 
    
    inner 클래스 => Thread, 윈도우, => 빅데이터 
    Thread 다른 클래스의 내용을 공유하면서 진행해야함
   
   */
   class Client extends Thread { 
      // 멤버 클래스  -> 서버를 1개만 돌리기 위해서 사용 ? 왜 그런지는 모르겠음
      // Server가 가지고 있는 모든 데이터를 사용 할 수 있다   
      
      // 통신을 하는 쓰레드 = Client
      Socket s; // 클라이언트와 연결 전화기 (연결기계 => 소프트웨어로 제작)
      // 소켓이 있으면 다른 쪽과 연결할 수 있다.
      OutputStream out; // 클라이언트로 결과 값 전송
      BufferedReader in; // 클라이언트로부터 요청 값을 받는다.
      public Client(Socket s) { 
         // 접속 할 때 마다 클라이언트가 생성 ex) 10 명이 접속하면 10개의 Client가 생성
         
         /*
             서버 -> 클라이언트 정보
             ㅡ클라이언트는 서버의 정보를 가지고 있다.
             
          */
         try {
            this.s = s;
            out = s.getOutputStream();
            in  = new BufferedReader(new InputStreamReader(s.getInputStream()));
                                             // 클라이언트가 저장된 부분부터 읽어 브리겠다.
         }catch(Exception ex) {}
      }   
         // 통신 시작
         public void run() {
            while(true) {
               
            }
            // 여기서 클라이언트와 서버의 소켓 교환이 이루어짐
         }
   }
}