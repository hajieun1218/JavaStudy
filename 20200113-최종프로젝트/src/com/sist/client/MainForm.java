package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.sist.dao.*;  // �ٸ������� ������ import

public class MainForm extends JFrame implements ActionListener {

	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	CardLayout card = new CardLayout();  // ������â�� �״��, �гθ� �ٲ�
	
	MainForm() {
		setLayout(card);
		
		add("LOGIN", login);
		add("WR", wr);
		
		setSize(1024, 768);
		setVisible(true);   // ������ ������
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
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
			String pwd=String.valueOf(login.pf.getPassword());
			
			if(id.length()<1) {
				JOptionPane.showMessageDialog(this, "ID�� �Է��ϼ���");
				login.tf.requestFocus();
			}
			
			else if(pwd.length()<1) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
				login.pf.requestFocus();
			}
			
			else {
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
					JOptionPane.showMessageDialog(this, id+"�� �α��� �Ǿ����ϴ�");
					card.show(getContentPane(), "WR");
				}
			}
			
		}
		else if(e.getSource() == login.b2) {
			System.exit(0);
		}
	}
	
}
