package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
/*
    Ŭ������ ����
       = �Ϲ� Ŭ����
       = �߻� Ŭ����(�������̽�)
          -> �ϳ��� Ŭ������ �ٸ� Ŭ������ �����ϱ� ���ؼ� ���
       = ���� Ŭ����
          
          1) Ŭ���� ���� �����͸� ���� => static => ���Ŭ���� (Thread)
          
             classA{
                
                class B{
                }
             }
             
             Server�� ������ �ִ� ��� ������ ����
          
          2) ��� ���� �������̵��� ����� �� => �͸��� Ŭ����
 */

public class Server implements Runnable{
   /*
       ������ ��� : Server
       
    */
   
   private ServerSocket ss;
   private final int PORT = 8888;
   private Vector<Client> waitVc = new Vector<Client>();   //->Client�� ��� ������ ���� (ip,id,port�� ���� ����ϱ� ���ؼ�) 
   // ������ ������ ���� // IP��  Port��ȣ�� ������ �����
   // ��Ÿ� �۵��ϴ� �����带 ���� �������Ѵ�.
   
   // �ϳ��� ���������� �ϳ��� �����常 �����ؾ��Ѵ�.
   // ���� ���� -> server = �޸� �Ҵ��� �ѹ��� ���
   public Server() {
      try {
         ss = new ServerSocket(PORT);
         // �⺻ ���� = 50�� ���� �� -> 50���� �Ѿ�� ��� �����
         // ���� => bind , ������ => listen
         System.out.println("server Start......");
      }catch(Exception ex) {}
   }
   @Override
   public void run() {
         while(true) {
         try {
            
            Socket s = ss.accept(); // Socket --> Ŭ���̾�Ʈ(����) -> ������ ���������� �������� �ѱ��  �Ѱܹ��� IP�� ����� �� �ֵ��� ����
         // ���ӽÿ� Ŭ���̾�Ʈ�� ������ �޾Ƽ� �����ϰ� -> ������� ����
         // ���ӽÿ� ���� ==> Socket(ip,port) => ������ �ϸ� ������ �ؾ��Ѵ�.
            System.out.println("���� �Ϸ� =:"+s.getInetAddress().getHostAddress());
            Client client = new Client(s);
            client.start();
            waitVc.add(client);
            // ������ ����
            
         }catch(Exception ex) {}
         
         
         }
   }
   public static void main(String[] args) {
   
      Server server = new Server();
      new Thread(server).start();
      
   }
   /* 
    
    inner Ŭ���� => Thread, ������, => ������ 
    Thread �ٸ� Ŭ������ ������ �����ϸ鼭 �����ؾ���
   
   */
   class Client extends Thread { 
      // ��� Ŭ����  -> ������ 1���� ������ ���ؼ� ��� ? �� �׷����� �𸣰���
      // Server�� ������ �ִ� ��� �����͸� ��� �� �� �ִ�   
      
      // ����� �ϴ� ������ = Client
      Socket s; // Ŭ���̾�Ʈ�� ���� ��ȭ�� (������ => ����Ʈ����� ����)
      // ������ ������ �ٸ� �ʰ� ������ �� �ִ�.
      OutputStream out; // Ŭ���̾�Ʈ�� ��� �� ����
      BufferedReader in; // Ŭ���̾�Ʈ�κ��� ��û ���� �޴´�.
      public Client(Socket s) { 
         // ���� �� �� ���� Ŭ���̾�Ʈ�� ���� ex) 10 ���� �����ϸ� 10���� Client�� ����
         
         /*
             ���� -> Ŭ���̾�Ʈ ����
             ��Ŭ���̾�Ʈ�� ������ ������ ������ �ִ�.
             
          */
         try {
            this.s = s;
            out = s.getOutputStream();
            in  = new BufferedReader(new InputStreamReader(s.getInputStream()));
                                             // Ŭ���̾�Ʈ�� ����� �κк��� �о� �긮�ڴ�.
         }catch(Exception ex) {}
      }   
         // ��� ����
         public void run() {
            while(true) {
               
            }
            // ���⼭ Ŭ���̾�Ʈ�� ������ ���� ��ȯ�� �̷����
         }
   }
}