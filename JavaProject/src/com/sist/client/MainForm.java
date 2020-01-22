package com.sist.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;

import com.sist.dao.*;
import com.sist.client.*;
import com.sist.common.Answer;
import com.sist.common.Function;

import java.io.*;

public class MainForm extends JFrame implements ActionListener, Runnable, MouseListener {

//	String[] dap= {"a","b","c","d","e","f","g","h","i","j"};
	Start st = new Start();
	Login lo = new Login();
	WaitRoom wr = new WaitRoom();
	MakeRoom mr = new MakeRoom();
//	MyDialog md = new MyDialog();
	MyDialog2 md2 = new MyDialog2();
	GameRoom gr = new GameRoom();
	End en = new End();
	MemberDAO dao = new MemberDAO();
	Answer answer = new Answer();
	CardLayout card = new CardLayout();

	// ���� ����� ���� ����
	Socket s;
	OutputStream out;
	BufferedReader in;

	String myRoom;

	// �̹��� ����
	int imageNo = 0;
	// ���� ����
	int count = 0;
	// ���� ���� ��ȣ
	int quizNo = 0;
	//
//	boolean Check =true;
	// ����
	String[] dap = new String[10];

	ProgressThread pt;

	public MainForm() {
		pt = new ProgressThread();
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
		st.b2.addActionListener(this);
		st.b3.addActionListener(this);

		md2.b1.addActionListener(this);
		md2.b4.addActionListener(this);

		wr.b1.addActionListener(this);
		wr.b2.addActionListener(this);
		wr.b3.addActionListener(this);

		en.b1.addActionListener(this);

		lo.b1.addActionListener(this);
		lo.b2.addActionListener(this);

		gr.b1.addActionListener(this);
		gr.b4.addActionListener(this); // ���ӽ���
		gr.b5.addActionListener(this); // ������

		gr.ans.addActionListener(this); // ���� �Է�
		gr.tf.addActionListener(this); // ���ӹ�ä��

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
		// join ��ư
		else if (e.getSource() == st.b2) {
			md2.setLocation(this.getWidth() / 2 - md2.getWidth() / 2, this.getHeight() / 2 - md2.getHeight() / 2);
			md2.setVisible(true);
		}
		// dialog2 ĳ���� ���� ��ư
		else if (e.getSource() == md2.b4) {
			JOptionPane.showMessageDialog(this, "���õǾ����ϴ�!");
			md2.tf.requestFocus();
//         md2.setVisible(false);
		}
		// dialog2ȸ������ ��ư
		else if (e.getSource() == md2.b1) {
			md2.setVisible(false);
			card.show(getContentPane(), "Login");
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
//			card.show(getContentPane(), "GameRoom");
//			gr.ta.setText("~~���� �濡 �����Ͽ����ϴ�\n");
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
//			mr.la4.setVisible(false);
//			mr.pf.setVisible(false);
//			mr.pf.setText("");
			mr.tf.requestFocus();

			mr.setVisible(true);
		}
		// �游��� ��ư(���̾�α�)
		else if (e.getSource() == mr.b1) {
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

			// ���� ����
			String rs = ""; // ��������
			String rp = ""; // ��й�ȣ
			if (mr.rb1.isSelected()) {
				rs = "�ִϸ��̼�";
				rp = " "; // �ݵ�� ���� => StringTokenizer�� null�̸� �߶��� ����
//				dap=answer.getAni();
//				quizNo=1;
			} else if (mr.rb2.isSelected()) {
				rs = "�Ƿ��귣��";
				rp = " ";
//				dap=answer.getClothes();
//				quizNo=2;
			} else if (mr.rb3.isSelected()) {
				rs = "������";
				rp = " ";
//				dap=answer.getStar();
//				quizNo=3;
			} else {
				rs = "�������귣��";
				rp = " ";
//				dap=answer.getSport();
//				quizNo=4;
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
		// ���ӹ� ä��
		else if (e.getSource() == gr.tf) {
			String msg = gr.tf.getText();
			if (msg.length() < 1) {
				return;
			}
			try {
				out.write((Function.GAME_CHAT + "|" + myRoom + "|" + msg + "\n").getBytes());
			} catch (Exception ex) {
			}

			gr.tf.setText("");
		}
		// ���ӹ�( �������� -> end)
		else if (e.getSource() == gr.b5) {
//			gr.ta.setText("");
//			card.show(getContentPane(), "Waiting");
			try {
				out.write((Function.GAME_EXIT_U + "|" + myRoom + "\n").getBytes());
			} catch (Exception ex) {
			}
		}
		// ���ӹ� - ���ӽ���
//		else if (e.getSource() == gr.b4) {
//			JOptionPane.showMessageDialog(this, "������ �����մϴ�");
//			gr.ans.setEditable(true);
//			gr.games.setImage(imageNo, quizNo);
//			gr.games.repaint();
//			count = 0;
//		}
//		 ���ӹ�-��������
//		else if(e.getSource() == gr.b1) {
//			imageNo++;
//			if(imageNo>10) {
//				System.out.println("��������");
//				System.out.println("����:"+count);
//				
//				return;
//			}
//			gr.games.setImage(imageNo,quizNo);
//			gr.games.repaint();
//		}
		
		// ���ӹ�-�����Է�â �Ǵ� �������� ��ư
		else if (e.getSource() == gr.ans || e.getSource() == gr.b1) {
			String data = gr.ans.getText();
			// ���� O,X �̹���
			System.out.println("!!! : " + imageNo);
			if (data.equals(dap[imageNo])) {
				gr.daps[imageNo + 10].setIcon(new ImageIcon(
						gr.getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\o.png"), 65, 40)));
				count++;
			} else {
				gr.daps[imageNo + 10].setIcon(new ImageIcon(
						gr.getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\x.png"), 65, 40)));
			}

			// ���������� �Ѿ��
			imageNo++;
			System.out.println("??? : " + imageNo);
			if (imageNo > 9) {

				System.out.println("��������");
				System.out.println("����:" + count);
				try {
//					out.write((Function.GAME_END+"|"+count+"|"+myRoom+"\n").getBytes());	
					out.write((Function.GAME_NEXT + "|" + myRoom + "|" + imageNo +"|" + count + "\n").getBytes());
				} catch (Exception ex) {
				}
//				try { 
//					out.write((Function.GAME_END+"|"+myRoom+"|"+count+"\n").getBytes());
////					pt.interrupt();
//				} catch(Exception ex) {}

				return;
			}
			gr.games.setImage(imageNo, quizNo);
			gr.games.repaint();

			gr.ans.setText("");
			gr.ans.requestFocus();
		}

		else if (e.getSource() == en.b1) {
//			Check = true;
			try {
				out.write((Function.GAME_EXIT_U + "|" + myRoom + "\n").getBytes());
			} catch (Exception ex) {
			}
			en.scoreBoard.setText(" ");
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
				System.out.println("Server=>" + msg);
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
					// Function.ROOMIN+"|"+room.roomName+"|"+room.roomState+"|"+id+"|"+sex+"|"+avata
					myRoom = st.nextToken();
					String rs = st.nextToken();
					String id = st.nextToken();
					String sex = st.nextToken();
					String avata = st.nextToken();

					String temp = "";
					temp = "Icon" + avata;

					// ȭ���̵�
					card.show(getContentPane(), "GameRoom");
					imageNo = 0;

					// �ƹ�Ÿ
					for (int i = 0; i < 6; i++) {
						if (gr.sw[i] == false) { // �� �����̶��
							gr.sw[i] = true;
							gr.pans[i].removeAll(); // �������� ����
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i]
									.add("Center",
											new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
													new ImageIcon("c:\\javaDev\\ProjectImage\\" + temp + ".png"), 150,
													120))));
							gr.pans[i].validate(); // ���ġ
							gr.ids[i].setText(id);
							break;
						}
					}

					if (rs.equals("�ִϸ��̼�")) {
						dap = answer.getAni();
						quizNo = 1;
					} else if (rs.equals("�Ƿ��귣��")) {
						dap = answer.getClothes();
						quizNo = 2;
					} else if (rs.equals("������")) {
						dap = answer.getStar();
						quizNo = 3;
					} else { // ������ �귣��
						dap = answer.getSport();
						quizNo = 4;
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
							gr.pans[i]
									.add("Center",
											new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
													new ImageIcon("c:\\javaDev\\ProjectImage\\" + temp + ".png"), 150,
													120))));
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
				case Function.WAIT_UPDATE: {
					// Function.WAITUPDATE+"|"+room.roomName+"|"+room.current+"/"+room.maxcount+"|"+id+"|"+pos
					String rn = st.nextToken();
					String current = st.nextToken();
					String maxcount = st.nextToken();
					String id = st.nextToken();
					String pos = st.nextToken();

					// ���̺��� �� ã��
					for (int i = 0; i < wr.model1.getRowCount(); i++) {
						String roomName = wr.model1.getValueAt(i, 0).toString();
						if (rn.equals(roomName)) {
							if (Integer.parseInt(current) == 0) {
								wr.model1.removeRow(i);
							} else {
								wr.model1.setValueAt(current + "/" + maxcount, i, 2);
							}
							break;
						}
					}
					// ������ ��� ����
					for (int i = 0; i < wr.model2.getRowCount(); i++) {
						String mid = wr.model2.getValueAt(i, 0).toString();
						if (mid.equals(id)) {
							wr.model2.setValueAt(pos, i, 3);
							break;
						}
					}

					break;
				}
				case Function.WAIT_POSCHANGE: {
					// Function.POSCHANGE+"|"+id+"|"+pos
					String id = st.nextToken();
					String pos = st.nextToken();

					for (int i = 0; i < wr.model2.getRowCount(); i++) {
						String mid = wr.model2.getValueAt(i, 0).toString();
						if (mid.equals(id)) {
							wr.model2.setValueAt(pos, i, 3);
							break;
						}
					}
					break;
				}
				case Function.GAME_EXIT_U: {
					// ���ӹ濡 �����ִ� ��� => �ƹ�Ÿ, ���̵� ����
					String id = st.nextToken();
					for (int i = 0; i < 6; i++) {
						String mid = gr.ids[i].getText();
						if (id.equals(mid)) {
							gr.sw[i] = false;
							gr.pans[i].removeAll();
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i]
									.add("Center",
											new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
													new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150,
													120))));
							gr.pans[i].validate(); // ���ġ
							gr.ids[i].setText("");
						}
					}

					break;
				}
				case Function.GAME_EXIT: {
					// ������ ��� => â�� �������� �ٲ�

					// �ʱ�ȭ => �ʱ�ȭ ���ϸ� ���� ���� �� �ƹ�Ÿ,id,ä���� �״�� ��������
					for (int i = 0; i < 6; i++) {
						gr.sw[i] = false;
						gr.pans[i].removeAll();
						gr.pans[i].setLayout(new BorderLayout());
						gr.pans[i].add("Center", new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
								new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
						gr.pans[i].validate(); // ���ġ
						gr.ids[i].setText("");
					}
					gr.ta.setText("");
					gr.tf.setText("");

					// ���� �г� �ʱ�ȭ
					for (int i = 10; i < 20; i++) {
//						gr.daps[i]=new JLabel();
//						gr.ppp.add(gr.daps[i]);
						gr.daps[i].setIcon(new ImageIcon(
								gr.getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\def.png"), 65, 40)));
					}
					gr.games.setImage(100, quizNo);
					gr.games.repaint();
					gr.ans.setText("");
					gr.b1.setEnabled(false);
					gr.bar.setValue(0);

					pt.interrupt();
					// �ʱ�ȭ �� ���� �̵�
					card.show(getContentPane(), "Waiting");
					break;
				}
				case Function.START: {
					gr.ta.append(st.nextToken() + "\n");// ??
					JOptionPane.showMessageDialog(this, "������ �����մϴ�");
					gr.games.setImage(0, quizNo);
					gr.games.repaint();
					gr.ans.setEditable(true);
					gr.ans.requestFocus();
					gr.b1.setEnabled(true);
					count = 0;
					pt = new ProgressThread();
					pt.start();
					
					break;
				}
				case Function.GAME_END: {
//					Check = false;
					out.write((Function.GAME_END + "|" + count + "|" + myRoom + "\n").getBytes());
					break;
				}
				case Function.END_U: {
//					int score = Integer.parseInt(st.nextToken());
//					String id = st.nextToken();
//					en.scoreBoard.append("[" + id + "] : " + String.valueOf(score) + "\n");
					
					
					String temp=st.nextToken();
					String[] score=temp.split("@");
					String data="";
					
					for(String s:score) {
						StringTokenizer ss=new StringTokenizer(s,"/");
						data+=ss.nextToken()+"("+ss.nextToken()+") �� "+ss.nextToken()+"��\n";
					}
					data=data.substring(0,data.lastIndexOf("\n"));
					en.scoreBoard.append(data);
					card.show(getContentPane(), "End");
					
					break;
				}
				case Function.END: {
					JOptionPane.showMessageDialog(this, "������ ����Ǿ����ϴ�.");
					card.show(getContentPane(), "End");
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
		if (e.getSource() == wr.table1) {
			if (e.getClickCount() == 2) { // ����Ŭ��
				// ���̸�
				int row = wr.table1.getSelectedRow();
				String rn = wr.model1.getValueAt(row, 0).toString();
				String inwon = wr.model1.getValueAt(row, 2).toString();
//				String state=wr.model1.getValueAt(row, 1).toString();

				StringTokenizer st = new StringTokenizer(inwon, "/");
				int no1 = Integer.parseInt(st.nextToken());
				int no2 = Integer.parseInt(st.nextToken());
				if (no1 == no2) {
					// �濡 �� �� ����
					JOptionPane.showMessageDialog(this, "�̹� ���ο��� á���ϴ�\n�ٸ�  ���� �����ϼ���");
				} else {
					// �濡 �� �� �ִ�
					try {
						out.write((Function.WAIT_INROOM + "|" + rn + "\n").getBytes());
					} catch (Exception ex) {
					}
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

	class ProgressThread extends Thread {
		public void run() {
			try {
				for (int i = 0; i <= 100; i++) {
					gr.bar.setValue(i);
					Thread.sleep(200);
					if (i >= 100) {
						out.write((Function.GAME_END + "|" + count + "|" + myRoom + "\n").getBytes());
						pt.interrupt();
//						if(Check) {
//						}
					}
				}
			} catch (Exception ex) {
			}
		}
	}

}
