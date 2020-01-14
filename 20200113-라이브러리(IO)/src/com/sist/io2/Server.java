package com.sist.io2;
/*
 *     Ŭ������ ����
 *       = �Ϲ�Ŭ����
 *       = �߻�Ŭ����(�������̽�_
 *       = ����Ŭ����
 *          1) Ŭ�������� �����͸� ���� => ���Ŭ����
 *              class A {
 *                 class B {
 *                 }
 *              }
 *             Server�� ������ �ִ� ��� ������ ����
 *          2) ��� ���� �������̵��� ���  => �͸��� Ŭ����
 */
import java.util.*;
import java.io.*;
import java.net.*;
public class Server implements Runnable {

	private ServerSocket ss;
	private final int PORT=8888;
	private Vector<Client> waitVc=new Vector<Client>();  // ������ ������ ����(ip,port)

	// ���� ���� => Server => �޸� �Ҵ��� �ѹ��� ���
	public Server() {
		try {
			ss=new ServerSocket(PORT);  // 50������ ���
			// ���� => bind, ������ => listen
			System.out.println("Server Start...");
		} catch(Exception ex) {}
	}
	
	// ����
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// ���ӽÿ� ó��
		while(true) {
			try {
				// ���ӽÿ� Ŭ���̾�Ʈ�� ������ �޾Ƽ� �����ϰ� => ������� ����
				// ���ӽÿ� ���� ==> Socket(ip,port)
				Socket s=ss.accept(); // �����̵Ǹ� ȣ��Ǵ� �޼ҵ�
				// Socket ==> Ŭ���̾�Ʈ(����)
				
				System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�!!=>"+s.getInetAddress().getHostAddress());
				Client client=new Client(s);
				client.start();
				waitVc.add(client); // ������ ����
				
			} catch(Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stubs

		Server server=new Server();
		new Thread(server).start();
	}

	// ���
	// ���Ŭ���� 
	// inner Ŭ���� => Thread, ������=> ������
	class Client extends Thread {
		// Server�� ������ �ִ� ��� �����͸� ����� �� �ִ�
		
		Socket s;  // Ŭ���̾�Ʈ�� ���� ��ȭ��(������ => ����Ʈ����� ����)
		OutputStream out; // Ŭ���̾�Ʈ�� ����� ����
		BufferedReader in; // Ŭ���̾�Ʈ�κ��� ��û���� �޴´�
		
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream();  // Ŭ���̾�Ʈ�� ���� ������ ��������
				in=new BufferedReader(new InputStreamReader(s.getInputStream())); //1byte�� �޾Ƽ� 2byte�� ��ȯ
			} catch(Exception ex) {}
		}
		
		// ���
		public void run() {
			// �̺κк��� ���� �޶���
			while(true) {
				try {
					// Ŭ���̾�Ʈ�� ������ �޽��� �б�
					String msg=in.readLine();
					System.out.println("Client=>"+msg);
					// ������ ��ü Ŭ���̾�Ʈ�� ���� ����
					for(Client c:waitVc) {
						c.out.write((msg+"\n").getBytes());  // 1����Ʈ�� ������
					}
				} catch(Exception ex) {}
			}
		}
	}
}
