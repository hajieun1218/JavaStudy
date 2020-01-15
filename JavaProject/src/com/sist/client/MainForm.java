package com.sist.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;

import com.sist.dao.*;
import com.sist.client.*;
import com.sist.common.Function;

import java.io.*;

public class MainForm extends JFrame implements ActionListener, Runnable, MouseListener {

	Start st = new Start();
	Login lo = new Login();
	WaitRoom wr = new WaitRoom();
	MakeRoom mr = new MakeRoom();
//	MyDialog md = new MyDialog();
	GameRoom gr = new GameRoom();
	End en = new End();
	MemberDAO dao = new MemberDAO();
	CardLayout card = new CardLayout();

	// ���� ����� ���� ����
	Socket s;
	OutputStream out;
	BufferedReader in;

	String myRoom;

	public MainForm() {

		setLayout(card);
		add("Start", st);
		add("Login", lo);
		add("Waiting", wr);
		add("GameRoom", gr);
		add("End", en);

		setSize(1024, 768); // ������ ũ��
		setVisible(true);

//      // X-> ����
//      setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // ũ������ ���� => ȭ�� ����
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // ������ư���� ��������

		// title ����
//      setTitle("�ż�����_����");
		st.b1.addActionListener(this);
		st.b3.addActionListener(this);
		wr.b1.addActionListener(this);
		wr.b2.addActionListener(this);
		wr.b3.addActionListener(this);
		en.b1.addActionListener(this);
		lo.b1.addActionListener(this);
		lo.b2.addActionListener(this);
		gr.b4.addActionListener(this);
		gr.b5.addActionListener(this);
		wr.tf.addActionListener(this);
		mr.b1.addActionListener(this); // ���� �游���
		mr.b2.addActionListener(this); 
		wr.table1.addMouseListener(this);
		
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
		}

		MainForm mf = new MainForm();
		WaitRoom wf = new WaitRoom();
		GameRoom gm = new GameRoom();
		End end = new End();

	}

	// ��ư ó�� �ϴ� �޼���
	public void actionPerformed(ActionEvent e) { // ��ưó���ϴ� ����

		// ����ȭ�� ( start -> �α��� (���� ����x)
		if (e.getSource() == st.b1) {// �α��� ��ư�� ���ȴٸ�
			card.show(getContentPane(), "Login"); // ȭ�� ���� // ���� â���� �̵�
			lo.tf.setText("");
			lo.pf.setText("");
		}
		// ����ȭ�� (������ -> ����)
		else if (e.getSource() == st.b3) {
			System.exit(0);
		}

		// �α���ȭ�� (login -> ����)
		else if (e.getSource() == lo.b1) {
			String id = lo.tf.getText();
			String pwd = String.valueOf(lo.pf.getPassword());
			if (id.length() < 1) {
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
				lo.tf.requestFocus();
				return;
			} else if (pwd.length() < 1) {

				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
				lo.pf.requestFocus();
				return;
			}

			// ó��
			dao = new MemberDAO();
			String result = dao.isLogin(id, pwd);
			if (result.equals("NOID")) {
				JOptionPane.showMessageDialog(this, "ID�� �������� �ʽ��ϴ�.");
				lo.tf.setText("");
				lo.tf.setText("");
				lo.tf.requestFocus();
			} else if (result.equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "pwd�� Ʋ���ϴ�.");
				lo.pf.setText("");
				lo.pf.requestFocus();
			} else {
				connection(result);
			}
		}

		// �α���ȭ�� (main -> ����ȭ��)
		else if (e.getSource() == lo.b2) {
			card.show(getContentPane(), "Start");
		}

		// ���� ä��
		else if (e.getSource() == wr.tf) {
			String msg = wr.tf.getText();
			if (msg.length() < 1) {
				wr.tf.requestFocus();
				return;
			}
			try {
				out.write((Function.WAIT_CHAT + "|" + msg + "\n").getBytes());
			} catch (Exception ex) {
			}
			wr.tf.setText("");
		}

		// ����(����� -> ���ӹ�)
		else if (e.getSource() == wr.b2) {
			card.show(getContentPane(), "GameRoom");
			gr.ta.setText("~~���� �濡 �����Ͽ����ϴ�\n");
		}
		// ����(������ -> ����ȭ��)
		else if (e.getSource() == wr.b3) {
			try {
				out.write((Function.WAIT_EXIT_U + "|\n").getBytes());
				/*
				 * ������ => ��û === ó�� ==> ���� ������ => Ŭ���̾�Ʈ
				 */
			} catch (Exception ex) {
			}
//			wr.tp.setText("");
//			card.show(getContentPane(), "Start");
		}
		// �游����ư Ŭ��(����)
		else if (e.getSource() == wr.b1) {
			// �ʱ�ȭ
			mr.tf.setText("");
			mr.rb1.setSelected(true);
			mr.box.setSelectedIndex(0);
			mr.la4.setVisible(false);
			mr.pf.setVisible(false);
			mr.pf.setText("");
			mr.tf.requestFocus();

			mr.setVisible(true);
		} else if (e.getSource() == mr.b1) {
			// ���̸�
			String rn = mr.tf.getText();
			if (rn.length() < 1) {
				JOptionPane.showMessageDialog(this, "���̸��� �Է��ϼ���");
				mr.tf.requestFocus();
				return;
			}
			for (int i = 0; i < wr.model1.getRowCount(); i++) {
				String roomName = wr.model1.getValueAt(i, 0).toString();
				if (rn.equals(roomName)) {
					JOptionPane.showMessageDialog(this, "�̹� �����ϴ� ���Դϴ�\n�ٽ��Է��ϼ���");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}

			// ���� �����
			String rs = ""; // ����(����/�����)
			String rp = ""; // ��й�ȣ
			if (mr.rb1.isSelected()) {
				rs = "����";
				rp = " "; // �ݵ�� ���� => StringTokenizer�� null�̸� �߶��� ����
			} else {
				rs = "�����";
				rp = String.valueOf(mr.pf.getPassword());
			}

			// �ο�üũ
			int inwon = mr.box.getSelectedIndex() + 2;

			// ������ ����
			try {
				out.write((Function.WAIT_MAKEROOM + "|" + rn + "|" + rs + "|" + rp + "|" + inwon + "\n").getBytes());
			} catch (Exception ex) {
			}
			mr.setVisible(false);

		} else if (e.getSource() == mr.b2) {
			mr.setVisible(false);
		}
		// ���ӹ�( �������� -> end)
		else if (e.getSource() == gr.b5) {
			gr.ta.setText("");
			card.show(getContentPane(), "Waiting");
		} else if (e.getSource() == gr.b4) {
			JOptionPane.showMessageDialog(this, "������ �����մϴ�");
			card.show(getContentPane(), "End");
		} else if (e.getSource() == en.b1) {
			card.show(getContentPane(), "GameRoom");
		}
	}

	public void connection(String userData) {
		try {
			s = new Socket("localhost", 8888);
			out = s.getOutputStream();
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out.write((Function.LOGIN + "|" + userData + "\n").getBytes());

		} catch (Exception ex) {
		}
		new Thread(this).start();

	}

	@Override
	public void run() {

		try {
			while (true) {
				String msg = in.readLine();
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());

				switch (protocol) {

				case Function.LOGIN: {
					String[] data = { st.nextToken(), // id
							st.nextToken(), // �̸�
							st.nextToken(), // ����
							st.nextToken(), // ��ġ
					};
					wr.model2.addRow(data);// ���ǿ� ����� ���� ���
					break;
				}
				case Function.LOGIN_UPDATE: {
					String id = st.nextToken();
					setTitle(id);
					card.show(getContentPane(), "Waiting");
					break;
				}
				case Function.WAIT_CHAT: {
					wr.tp.append(st.nextToken() + "\n");
					break;
				}
				case Function.WAIT_EXIT_U: { // �����ִ»��
					String id = st.nextToken();
					for (int i = 0; i < wr.model2.getRowCount(); i++) { // ���̺� ����� ������ŭ
						String mid = wr.model2.getValueAt(i, 0).toString(); // i��° id�� ������
						if (mid.equals(id)) {
							wr.model2.removeRow(i);
							break;
						}
					}
					break;
				}
				case Function.WAIT_EXIT: { // ���� ������ ��� ó��
					dispose(); // �޸� ȸ��
					System.exit(0); // ���α׷� ����
					break;
				}
				case Function.WAIT_MAKEROOM: {
					String[] data = { st.nextToken(), // ���̸�
							st.nextToken(), // ����(����/�����)
							st.nextToken() // 1/6
					};
					wr.model1.addRow(data);
					break;
				}
				case Function.WAIT_INROOM: {
					// Function.ROOMIN+"|"+room.roomName+"|"+id+"|"+sex+"|"+avata
					myRoom = st.nextToken();
					String id = st.nextToken();
					String sex = st.nextToken();
					String avata = st.nextToken();

					String temp = "";
					temp = "Icon" + avata;

					// ȭ���̵�
					card.show(getContentPane(), "GameRoom");

					// �ƹ�Ÿ
					for (int i = 0; i < 6; i++) {
						if (gr.sw[i] == false) { // �� �����̶��
							gr.sw[i] = true;
							gr.pans[i].removeAll(); // �������� ����
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i].add("Center", new JLabel(new ImageIcon(
									gr.getImageSizeChange(new ImageIcon("c:\\image\\" + temp + ".png"), 150, 120))));
							gr.pans[i].validate(); // ���ġ
							gr.ids[i].setText(id);
							break;
						}
					}
					break;
				}
				case Function.GAME_USERADD: {
					String id = st.nextToken();
					String sex = st.nextToken();
					String avata = st.nextToken();

					String temp = "";
					temp = "Icon" + avata;

					// �ƹ�Ÿ
					for (int i = 0; i < 6; i++) {
						if (gr.sw[i] == false) { // �� �����̶��
							gr.sw[i] = true;
							gr.pans[i].removeAll(); // �������� ����
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i].add("Center", new JLabel(new ImageIcon(
									gr.getImageSizeChange(new ImageIcon("c:\\image\\" + temp + ".png"), 150, 120))));
							gr.pans[i].validate(); // ���ġ
							gr.ids[i].setText(id);
							break;
						}
					}
					break;
				}
				case Function.GAME_CHAT: {
					gr.ta.append(st.nextToken() + "\n");
					break;
				}
				}
			}
		} catch (Exception ex) {
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table1) {
			if(e.getClickCount()==2) { // ����Ŭ��
				// ���̸�
				int row=wr.table1.getSelectedRow();
				String rn=wr.model1.getValueAt(row, 0).toString();
				String inwon=wr.model1.getValueAt(row, 2).toString();
//				String state=wr.model1.getValueAt(row, 1).toString();
				
				StringTokenizer st=new StringTokenizer(inwon,"/");
				int no1=Integer.parseInt(st.nextToken());
				int no2=Integer.parseInt(st.nextToken());
				if(no1==no2) {
					// �濡 �� �� ����
					JOptionPane.showMessageDialog(this,"�̹� ���ο��� á���ϴ�\n�ٸ�  ���� �����ϼ���");
				}
				else {
					// �濡 �� �� �ִ�
					try {
						out.write((Function.WAIT_INROOM+"|"+rn+"\n").getBytes());
					} catch(Exception ex) {}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
