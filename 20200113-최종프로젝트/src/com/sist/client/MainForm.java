package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.sist.common.Function;
import com.sist.dao.*;  // �ٸ������� ������ import
// ��������
import java.util.*;
import java.net.*;
import java.io.*;
public class MainForm extends JFrame implements ActionListener, Runnable {

	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	CardLayout card = new CardLayout();  // ������â�� �״��, �гθ� �ٲ�
	
	// ���� ����� ���õ� ���̺귯��
	Socket s; // ������ ����
	OutputStream out; // ������ ������ ����(��û)
	BufferedReader in; // �������� ������ �����͸� �޴´�
	/*
	 *    1) ������ ���� ������ ������ => �̺�Ʈ �߻�
	 *                          
	 *    2) �������� ������ ������ => Thread => ���(Function)
	 */
	
	MainForm() {
		setLayout(card);
		
		add("LOGIN", login);
		add("WR", wr);
		
		setSize(1024, 768);
		setVisible(true);   // ������ ������
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		wr.tf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
 	}
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch(Exception e) {}
		
		MainForm mf = new MainForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == login.b1) {
			
			String id=login.tf.getText();
			if(id.length()<1) {
				JOptionPane.showMessageDialog(this, "ID�� �Է��ϼ���");
				login.tf.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.length()<1) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
				login.pf.requestFocus();
				return;
			}
			
			// ó��
			MemberDAO dao=new MemberDAO();
			String result=dao.isLogin(id, pwd);
			if(result.equals("NOID")) {
				JOptionPane.showMessageDialog(this, "ID�� �������� �ʽ��ϴ�");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}
			else if(result.equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� Ʋ���ϴ�");
				login.pf.setText("");
				login.pf.requestFocus();
			}
			else {
//				JOptionPane.showMessageDialog(this, id+"�� �α��� �Ǿ����ϴ�");
//				card.show(getContentPane(), "WR");
				
				connection(result);
			}
		}
		else if(e.getSource() == login.b2) {
			System.exit(0);
		}
		// ���� ä��
		else if(e.getSource()==wr.tf ) {
			// �Էµ� ���ڿ� �б�
			String msg=wr.tf.getText();
			if(msg.length()<1) { // �Է��� �ȵȰ��
				wr.tf.requestFocus();
			}
			
			// ������ ����
			try {
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			} catch(Exception ex) {}
			
			wr.tf.setText("");
		}
	}

	public void connection(String userData) {
		try {
			s=new Socket("localhost",8888); // ��ȭ�ɱ�
			// �۽�-user /����-thread
			// �۽�
			out=s.getOutputStream();
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// �α��� ������ ������
			// 100|hong|ȫ�浿|����\n
			out.write((Function.LOGIN+"|"+userData+"\n").getBytes());
			
		} catch(Exception ex) {}
		
		// �����κ��� �����͸� �б� ����
		new Thread(this).start();
	}
	
	// �����κ��� �����͸� �����ϴ� ���
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				// 100|hong|ȫ�浿|����|����\n
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				
				switch(protocol) {
				case Function.LOGIN: 
				{
					String[] data= {
							st.nextToken(),  // id
							st.nextToken(),  // �̸�
							st.nextToken(),  // ����
							st.nextToken()   // ��ġ
					};
					wr.model2.addRow(data);
					break;
				}
				case Function.MYLOG: 
				{
					String id=st.nextToken();
					setTitle(id);
					card.show(getContentPane(), "WR");
					break;
				}
				case Function.WAITCHAT: 
				{
					wr.tp.append(st.nextToken()+"\n");
					break;
				}
					
				}
				
			}
		} catch(Exception ex) {}
	}
	
}
