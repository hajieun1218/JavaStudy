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

	// 서버 통신을 위한 변수
	Socket s;
	OutputStream out;
	BufferedReader in;

	String myRoom;

	// 이미지 숫자
	int imageNo = 0;
	// 정답 숫자
	int count = 0;
	// 퀴즈 주제 번호
	int quizNo = 0;
	//
//	boolean Check =true;
	// 정답
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

		setSize(1024, 768); // 윈도우 크기
		setVisible(true);

//      // X-> 종료
//      setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // 크기조절 방지 => 화면 고정
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 엑스버튼으로 못나가게

		// title 설정
//      setTitle("신서유기_퀴즈");
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
		gr.b4.addActionListener(this); // 게임시작
		gr.b5.addActionListener(this); // 나가기

		gr.ans.addActionListener(this); // 정답 입력
		gr.tf.addActionListener(this); // 게임방채팅

		wr.tf.addActionListener(this);
		mr.b1.addActionListener(this); // 실제 방만들기
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

	// 버튼 처리 하는 메서드
	public void actionPerformed(ActionEvent e) { // 버튼처리하는 내용

		// 시작화면 ( start -> 로그인 (아직 구현x)
		if (e.getSource() == st.b1) {// 로그인 버튼을 눌렸다면
			card.show(getContentPane(), "Login"); // 화면 변경 // 대기실 창으로 이동
			lo.tf.setText("");
			lo.pf.setText("");
		}
		// 시작화면 (나가기 -> 종료)
		else if (e.getSource() == st.b3) {
			System.exit(0);
		}
		// join 버튼
		else if (e.getSource() == st.b2) {
			md2.setLocation(this.getWidth() / 2 - md2.getWidth() / 2, this.getHeight() / 2 - md2.getHeight() / 2);
			md2.setVisible(true);
		}
		// dialog2 캐릭터 선택 버튼
		else if (e.getSource() == md2.b4) {
			JOptionPane.showMessageDialog(this, "선택되었습니다!");
			md2.tf.requestFocus();
//         md2.setVisible(false);
		}
		// dialog2회원가입 버튼
		else if (e.getSource() == md2.b1) {
			md2.setVisible(false);
			card.show(getContentPane(), "Login");
		}
		// 로그인화면 (login -> 대기방)
		else if (e.getSource() == lo.b1) {
			String id = lo.tf.getText();
			String pwd = String.valueOf(lo.pf.getPassword());
			if (id.length() < 1) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				lo.tf.requestFocus();
				return;
			} else if (pwd.length() < 1) {

				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				lo.pf.requestFocus();
				return;
			}

			// 처리
			dao = new MemberDAO();
			String result = dao.isLogin(id, pwd);
			if (result.equals("NOID")) {
				JOptionPane.showMessageDialog(this, "ID가 존재하지 않습니다.");
				lo.tf.setText("");
				lo.tf.setText("");
				lo.tf.requestFocus();
			} else if (result.equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "pwd가 틀립니다.");
				lo.pf.setText("");
				lo.pf.requestFocus();
			} else {
				connection(result);
			}
		}

		// 로그인화면 (main -> 시작화면)
		else if (e.getSource() == lo.b2) {
			card.show(getContentPane(), "Start");
		}

		// 대기실 채팅
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

		// 대기방(방들어가기 -> 게임방)
		else if (e.getSource() == wr.b2) {
//			card.show(getContentPane(), "GameRoom");
//			gr.ta.setText("~~님이 방에 입장하였습니다\n");
		}
		// 대기방(나가기 -> 시작화면)
		else if (e.getSource() == wr.b3) {
			try {
				out.write((Function.WAIT_EXIT_U + "|\n").getBytes());
				/*
				 * 나가기 => 요청 === 처리 ==> 서버 결과출력 => 클라이언트
				 */
			} catch (Exception ex) {
			}
//			wr.tp.setText("");
//			card.show(getContentPane(), "Start");
		}
		// 방만들기버튼 클릭(대기실)
		else if (e.getSource() == wr.b1) {
			// 초기화
			mr.tf.setText("");
			mr.rb1.setSelected(true);
			mr.box.setSelectedIndex(0);
//			mr.la4.setVisible(false);
//			mr.pf.setVisible(false);
//			mr.pf.setText("");
			mr.tf.requestFocus();

			mr.setVisible(true);
		}
		// 방만들기 버튼(다이얼로그)
		else if (e.getSource() == mr.b1) {
			// 방이름
			String rn = mr.tf.getText();
			if (rn.length() < 1) {
				JOptionPane.showMessageDialog(this, "방이름을 입력하세요");
				mr.tf.requestFocus();
				return;
			}
			for (int i = 0; i < wr.model1.getRowCount(); i++) {
				String roomName = wr.model1.getValueAt(i, 0).toString();
				if (rn.equals(roomName)) {
					JOptionPane.showMessageDialog(this, "이미 존재하는 방입니다\n다시입력하세요");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}

			// 게임 주제
			String rs = ""; // 게임주제
			String rp = ""; // 비밀번호
			if (mr.rb1.isSelected()) {
				rs = "애니메이션";
				rp = " "; // 반드시 공백 => StringTokenizer가 null이면 잘라내지 못함
//				dap=answer.getAni();
//				quizNo=1;
			} else if (mr.rb2.isSelected()) {
				rs = "의류브랜드";
				rp = " ";
//				dap=answer.getClothes();
//				quizNo=2;
			} else if (mr.rb3.isSelected()) {
				rs = "연예인";
				rp = " ";
//				dap=answer.getStar();
//				quizNo=3;
			} else {
				rs = "스포츠브랜드";
				rp = " ";
//				dap=answer.getSport();
//				quizNo=4;
			}

			// 인원체크
			int inwon = mr.box.getSelectedIndex() + 2;

			// 서버로 전송
			try {
				out.write((Function.WAIT_MAKEROOM + "|" + rn + "|" + rs + "|" + rp + "|" + inwon + "\n").getBytes());
			} catch (Exception ex) {
			}
			mr.setVisible(false);

		} else if (e.getSource() == mr.b2) {
			mr.setVisible(false);
		}
		// 게임방 채팅
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
		// 게임방( 정상종료 -> end)
		else if (e.getSource() == gr.b5) {
//			gr.ta.setText("");
//			card.show(getContentPane(), "Waiting");
			try {
				out.write((Function.GAME_EXIT_U + "|" + myRoom + "\n").getBytes());
			} catch (Exception ex) {
			}
		}
		// 게임방 - 게임시작
//		else if (e.getSource() == gr.b4) {
//			JOptionPane.showMessageDialog(this, "게임을 시작합니다");
//			gr.ans.setEditable(true);
//			gr.games.setImage(imageNo, quizNo);
//			gr.games.repaint();
//			count = 0;
//		}
//		 게임방-다음문제
//		else if(e.getSource() == gr.b1) {
//			imageNo++;
//			if(imageNo>10) {
//				System.out.println("게임종료");
//				System.out.println("정답:"+count);
//				
//				return;
//			}
//			gr.games.setImage(imageNo,quizNo);
//			gr.games.repaint();
//		}
		
		// 게임방-정답입력창 또는 다음문제 버튼
		else if (e.getSource() == gr.ans || e.getSource() == gr.b1) {
			String data = gr.ans.getText();
			// 정답 O,X 이미지
			System.out.println("!!! : " + imageNo);
			if (data.equals(dap[imageNo])) {
				gr.daps[imageNo + 10].setIcon(new ImageIcon(
						gr.getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\o.png"), 65, 40)));
				count++;
			} else {
				gr.daps[imageNo + 10].setIcon(new ImageIcon(
						gr.getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\x.png"), 65, 40)));
			}

			// 다음문제로 넘어가기
			imageNo++;
			System.out.println("??? : " + imageNo);
			if (imageNo > 9) {

				System.out.println("게임종료");
				System.out.println("정답:" + count);
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
							st.nextToken(), // 이름
							st.nextToken(), // 성별
							st.nextToken(), // 위치
					};
					wr.model2.addRow(data);// 대기실에 저장된 값을 출력
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
				case Function.WAIT_EXIT_U: { // 남아있는사람
					String id = st.nextToken();
					for (int i = 0; i < wr.model2.getRowCount(); i++) { // 테이블에 저장된 개수만큼
						String mid = wr.model2.getValueAt(i, 0).toString(); // i번째 id를 가져옴
						if (mid.equals(id)) {
							wr.model2.removeRow(i);
							break;
						}
					}
					break;
				}
				case Function.WAIT_EXIT: { // 실제 나가는 사람 처리
					dispose(); // 메모리 회수
					System.exit(0); // 프로그램 종료
					break;
				}
				case Function.WAIT_MAKEROOM: {
					String[] data = { st.nextToken(), // 방이름
							st.nextToken(), // 상태(공개/비공개)
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

					// 화면이동
					card.show(getContentPane(), "GameRoom");
					imageNo = 0;

					// 아바타
					for (int i = 0; i < 6; i++) {
						if (gr.sw[i] == false) { // 빈 공백이라면
							gr.sw[i] = true;
							gr.pans[i].removeAll(); // 검정색라벨 삭제
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i]
									.add("Center",
											new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
													new ImageIcon("c:\\javaDev\\ProjectImage\\" + temp + ".png"), 150,
													120))));
							gr.pans[i].validate(); // 재배치
							gr.ids[i].setText(id);
							break;
						}
					}

					if (rs.equals("애니메이션")) {
						dap = answer.getAni();
						quizNo = 1;
					} else if (rs.equals("의류브랜드")) {
						dap = answer.getClothes();
						quizNo = 2;
					} else if (rs.equals("연예인")) {
						dap = answer.getStar();
						quizNo = 3;
					} else { // 스포츠 브랜드
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

					// 아바타
					for (int i = 0; i < 6; i++) {
						if (gr.sw[i] == false) { // 빈 공백이라면
							gr.sw[i] = true;
							gr.pans[i].removeAll(); // 검정색라벨 삭제
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i]
									.add("Center",
											new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
													new ImageIcon("c:\\javaDev\\ProjectImage\\" + temp + ".png"), 150,
													120))));
							gr.pans[i].validate(); // 재배치
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

					// 테이블에서 방 찾기
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
					// 접속자 목록 변경
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
					// 게임방에 남아있는 사람 => 아바타, 아이디 빼기
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
							gr.pans[i].validate(); // 재배치
							gr.ids[i].setText("");
						}
					}

					break;
				}
				case Function.GAME_EXIT: {
					// 나가는 사람 => 창을 대기방으로 바꿈

					// 초기화 => 초기화 안하면 전에 들어갔던 방 아바타,id,채팅이 그대로 남아있음
					for (int i = 0; i < 6; i++) {
						gr.sw[i] = false;
						gr.pans[i].removeAll();
						gr.pans[i].setLayout(new BorderLayout());
						gr.pans[i].add("Center", new JLabel(new ImageIcon(GameRoom.getImageSizeChange(
								new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
						gr.pans[i].validate(); // 재배치
						gr.ids[i].setText("");
					}
					gr.ta.setText("");
					gr.tf.setText("");

					// 게임 패널 초기화
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
					// 초기화 후 대기실 이동
					card.show(getContentPane(), "Waiting");
					break;
				}
				case Function.START: {
					gr.ta.append(st.nextToken() + "\n");// ??
					JOptionPane.showMessageDialog(this, "게임을 시작합니다");
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
						data+=ss.nextToken()+"("+ss.nextToken()+") ☞ "+ss.nextToken()+"위\n";
					}
					data=data.substring(0,data.lastIndexOf("\n"));
					en.scoreBoard.append(data);
					card.show(getContentPane(), "End");
					
					break;
				}
				case Function.END: {
					JOptionPane.showMessageDialog(this, "게임이 종료되었습니다.");
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
			if (e.getClickCount() == 2) { // 더블클릭
				// 방이름
				int row = wr.table1.getSelectedRow();
				String rn = wr.model1.getValueAt(row, 0).toString();
				String inwon = wr.model1.getValueAt(row, 2).toString();
//				String state=wr.model1.getValueAt(row, 1).toString();

				StringTokenizer st = new StringTokenizer(inwon, "/");
				int no1 = Integer.parseInt(st.nextToken());
				int no2 = Integer.parseInt(st.nextToken());
				if (no1 == no2) {
					// 방에 들어갈 수 없다
					JOptionPane.showMessageDialog(this, "이미 방인원이 찼습니다\n다른  방을 선택하세요");
				} else {
					// 방에 들어갈 수 있다
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
