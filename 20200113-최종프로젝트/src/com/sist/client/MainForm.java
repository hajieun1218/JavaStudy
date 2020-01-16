package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.sist.common.Function;
import com.sist.dao.*;  // 다른폴더에 있을때 import
// 서버연결
import java.util.*;
import java.net.*;
import java.io.*;
public class MainForm extends JFrame implements ActionListener, Runnable, MouseListener {

	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	GameRoom gr=new GameRoom();
	MakeRoom mr=new MakeRoom();
	CardLayout card = new CardLayout();  // 윈도우창은 그대로, 패널만 바꿈
	
	// 서버 연결과 관련된 라이브러리
	Socket s; // 서버와 연결
	OutputStream out; // 서버로 데이터 전송(요청)
	BufferedReader in; // 서버에서 응답한 데이터를 받는다
	/*
	 *    1) 유저가 직접 보내는 데이터 => 이벤트 발생
	 *                          
	 *    2) 서버에서 들어오는 데이터 => Thread => 출력(Function)
	 */
	
	String myRoom,myId;
	
	MainForm() {
		setLayout(card);
		
		add("LOGIN", login);
		add("WR", wr);
		add("GAME",gr);
		
//		setSize(1024, 768);
		setBounds(448,216,1024,768);
		setVisible(true);   // 윈도우 보여라
		
		setResizable(false); // 크기조절 방지 => 화면 고정
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 엑스버튼으로 못나가게
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		wr.table1.addMouseListener(this);
		wr.tf.addActionListener(this);
		wr.b6.addActionListener(this); // 나가기
		wr.b1.addActionListener(this); // 방만들기 버튼(대기실)
		mr.b1.addActionListener(this); // 실제 방만들기
		mr.b2.addActionListener(this); 
		gr.tf.addActionListener(this);// 방안에서 채팅 등록
		gr.b5.addActionListener(this); // 방나가기
		gr.b2.addActionListener(this); // 강퇴
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
				JOptionPane.showMessageDialog(this, "ID를 입력하세요");
				login.tf.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.length()<1) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				login.pf.requestFocus();
				return;
			}
			
			// 처리
			MemberDAO dao=new MemberDAO();
			String result=dao.isLogin(id, pwd);
			if(result.equals("NOID")) {
				JOptionPane.showMessageDialog(this, "ID가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}
			else if(result.equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();
			}
			else {
//				JOptionPane.showMessageDialog(this, id+"님 로그인 되었습니다");
//				card.show(getContentPane(), "WR");
				
				connection(result);
			}
		}
		else if(e.getSource() == login.b2) {
			System.exit(0);
		}
		// 대기실 채팅
		else if(e.getSource()==wr.tf ) {
			// 입력된 문자열 읽기
			String msg=wr.tf.getText();
			if(msg.length()<1) { // 입력이 안된경우
				wr.tf.requestFocus();
				return;
			}
			
			// 서버로 전송
			try {
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			} catch(Exception ex) {}
			
			wr.tf.setText("");
		}
		// 나가기(대기실)
		else if(e.getSource()==wr.b6) {
			try {
				out.write((Function.EXIT+"|\n").getBytes());
				/*
				 *    나가기 => 요청
				 *           ===
				 *            처리 ==> 서버
				 *            결과출력 => 클라이언트
				 */
			} catch(Exception ex) {}
		}
		// 방만들기버튼 클릭(대기실)
		else if(e.getSource()==wr.b1) {
			// 초기화
			mr.tf.setText("");
			mr.rb1.setSelected(true);
			mr.box.setSelectedIndex(0);
			mr.la4.setVisible(false);
			mr.pf.setVisible(false);
			mr.pf.setText("");
			mr.tf.requestFocus();
			
			mr.setVisible(true);
		}
		else if(e.getSource()==mr.b1) {
			// 방이름
			String rn=mr.tf.getText();
			if(rn.length()<1) {
				JOptionPane.showMessageDialog(this, "방이름을 입력하세요");
				mr.tf.requestFocus();
				return;
			}
			for(int i=0;i<wr.model1.getRowCount();i++) {
				String roomName=wr.model1.getValueAt(i,0).toString();
				if(rn.equals(roomName)) {
					JOptionPane.showMessageDialog(this, "이미 존재하는 방입니다\n다시입력하세요");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}
			
			// 공개 비공개
			String rs=""; // 상태(공개/비공개)
			String rp=""; // 비밀번호
			if(mr.rb1.isSelected()) {
				rs="공개";
				rp=" "; // 반드시 공백 => StringTokenizer가 null이면 잘라내지 못함
			}
			else {
				rs="비공개";
				rp=String.valueOf(mr.pf.getPassword());
			}
			
			// 인원체크
			int inwon=mr.box.getSelectedIndex()+2;
			
			// 서버로 전송
			try {
				out.write((Function.MAKEROOM+"|"+rn+"|"
						+rs+"|"+rp+"|"+inwon+"\n").getBytes());
			} catch(Exception ex) {}
			mr.setVisible(false);
			
			
		}
		else if(e.getSource()==mr.b2) {
			mr.setVisible(false);
		}
		// 게임방 채팅
		else if(e.getSource()==gr.tf ) {
			String msg=gr.tf.getText();
			if(msg.length()<1) {
				return;
			}
			try {
				out.write((Function.ROOMCHAT+"|"+myRoom+"|"+msg+"\n").getBytes());
			} catch(Exception ex) {}
			
			gr.tf.setText("");
		}
		// 게임방 나가기
		else if(e.getSource()==gr.b5) {
			try {
				out.write((Function.ROOMOUT+"|"+myRoom+"\n").getBytes());
			} catch(Exception ex) {}
		}
		// 강퇴(게임방)
		else if(e.getSource()==gr.b2) {
			String youId=gr.box.getSelectedItem().toString();
			try {
				out.write((Function.KANG+"|"+myRoom+"|"+youId+"\n").getBytes());
			} catch(Exception ex) {}
		}
	}

	public void connection(String userData) {
		try {
			s=new Socket("localhost",8888); // 전화걸기
			// 송신-user /수신-thread
			// 송신
			out=s.getOutputStream();
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// 로그인 데이터 보내기
			// 100|hong|홍길동|남자\n
			out.write((Function.LOGIN+"|"+userData+"\n").getBytes());
			
		} catch(Exception ex) {}
		
		// 서버로부터 데이터를 읽기 시작
		new Thread(this).start();
	}
	
	// 서버로부터 데이터를 수신하는 기능
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				// 100|hong|홍길동|남자|대기실\n
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				
				switch(protocol) {
				case Function.LOGIN: 
				{
					String[] data= {
							st.nextToken(),  // id
							st.nextToken(),  // 이름
							st.nextToken(),  // 성별
							st.nextToken()   // 위치
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
				case Function.EXIT: {  // 남아있는사람
					String id=st.nextToken();
					for(int i=0;i<wr.model2.getRowCount();i++) { // 테이블에 저장된 개수만큼
						String mid=wr.model2.getValueAt(i,0).toString(); // i번째 id를 가져옴
						if(mid.equals(id)) {
							wr.model2.removeRow(i);
							break;
						}
					}
					break;
				}
				case Function.MYEXIT: {  // 실제 나가는 사람 처리
					dispose(); // 메모리 회수
					System.exit(0); // 프로그램 종료
					break;
				}
				case Function.MAKEROOM: {
					String[] data= {
							st.nextToken(),  // 방이름
							st.nextToken(),  // 상태(공개/비공개)
							st.nextToken()   // 1/6
					};
					wr.model1.addRow(data);
					break;
				}
				case Function.ROOMIN: {
					//Function.ROOMIN+"|"+room.roomName+"|"+id+"|"+sex+"|"+avata
					myRoom=st.nextToken();
					String id=st.nextToken();
					String sex=st.nextToken();
					String avata=st.nextToken();
					myId=id;
					
					String temp="";
					if(sex.equals("남자")) {
						temp="m"+avata;
					}
					else {
						temp="w"+avata;
					}
					
					// 화면이동
					card.show(getContentPane(), "GAME");
					
					// 아바타
					for(int i=0;i<6;i++) {
						if(gr.sw[i]==false) {  // 빈 공백이라면
							gr.sw[i]=true;
							gr.pans[i].removeAll(); // 검정색라벨 삭제
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i].add("Center",
									new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\"+temp+".png"), 150, 120))));
							gr.pans[i].validate(); // 재배치
							gr.ids[i].setText(id);
							break;
						}
					}
					
					break;
				}
				case Function.ROOMADD: {
					String id=st.nextToken();
					String sex=st.nextToken();
					String avata=st.nextToken();
					
					String temp="";
					if(sex.equals("남자")) {
						temp="m"+avata;
					}
					else {
						temp="w"+avata;
					}
					
					// 아바타
					for(int i=0;i<6;i++) {
						if(gr.sw[i]==false) {  // 빈 공백이라면
							gr.sw[i]=true;
							gr.pans[i].removeAll(); // 검정색라벨 삭제
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i].add("Center",
									new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\"+temp+".png"), 150, 120))));
							gr.pans[i].validate(); // 재배치
							gr.ids[i].setText(id);
							break;
						}
					}
					gr.box.addItem(id);
					break;
				}
				case Function.ROOMCHAT: {
					gr.ta.append(st.nextToken()+"\n");
					break;
				}
				case Function.WAITUPDATE: {
					// Function.WAITUPDATE+"|"+room.roomName+"|"+room.current+"/"+room.maxcount+"|"+id+"|"+pos
					String rn=st.nextToken();
					String current=st.nextToken();
					String maxcount=st.nextToken();
					String id=st.nextToken();
					String pos=st.nextToken();
					
					// 테이블에서 방 찾기
					for(int i=0;i<wr.model1.getRowCount();i++) {
						String roomName=wr.model1.getValueAt(i,0).toString();
						if(rn.equals(roomName)) {
							if(Integer.parseInt(current)==0) {
								wr.model1.removeRow(i);
							}
							else {
								wr.model1.setValueAt(current+"/"+maxcount,i,2);
							}
							break;
						}
					}
					// 접속자 목록 변경
					for(int i=0;i<wr.model2.getRowCount();i++) {
						String mid=wr.model2.getValueAt(i,0).toString();
						if(mid.equals(id)) {
							wr.model2.setValueAt(pos,i,3);
							break;
						}
					}
					
					break;
				}
				case Function.POSCHANGE: {
					// Function.POSCHANGE+"|"+id+"|"+pos
					String id=st.nextToken();
					String pos=st.nextToken();
					
					for(int i=0;i<wr.model2.getRowCount();i++) {
						String mid=wr.model2.getValueAt(i,0).toString();
						if(mid.equals(id)) {
							wr.model2.setValueAt(pos,i,3);
							break;
						}
					}
					break;
				}
				case Function.ROOMOUT: {
					// 게임방에 남아있는 사람 => 아바타, 아이디 빼기
					String id=st.nextToken();
					for(int i=0;i<6;i++) {
						String mid=gr.ids[i].getText();
						if(id.equals(mid)) {
							gr.sw[i]=false;
							gr.pans[i].removeAll();
							gr.pans[i].setLayout(new BorderLayout());
							gr.pans[i].add("Center",
									new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\def.png"), 150, 120))));
							gr.pans[i].validate(); // 재배치
							gr.ids[i].setText("");
						}
					}
					gr.box.removeItem(id); // 강퇴목록에서 지우기
					break;
				}
				case Function.MYROOMOUT: {
					// 나가는 사람 => 창을 대기방으로 바꿈
					
					// 초기화 => 초기화 안하면 전에 들어갔던 방 아바타,id,채팅이 그대로 남아있음
					for(int i=0;i<6;i++) {
						gr.sw[i]=false;
						gr.pans[i].removeAll();
						gr.pans[i].setLayout(new BorderLayout());
						gr.pans[i].add("Center",
								new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\def.png"), 150, 120))));
						gr.pans[i].validate(); // 재배치
						gr.ids[i].setText("");
					}
					gr.ta.setText("");
					gr.tf.setText("");
					
					// 초기화 후 대기실 이동
					card.show(getContentPane(),"WR");
					break;
				}
				case Function.KANG: {
					String rn=st.nextToken();
					JOptionPane.showMessageDialog(this, rn+"방에서 강퇴되었습니다");
					out.write((Function.ROOMOUT+"|"+rn+"\n").getBytes());
					break;
				}
					
				}
				
			}
		} catch(Exception ex) {}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table1) {
			if(e.getClickCount()==2) { // 더블클릭
				// 방이름
				int row=wr.table1.getSelectedRow();
				String rn=wr.model1.getValueAt(row, 0).toString();
				String inwon=wr.model1.getValueAt(row, 2).toString();
//				String state=wr.model1.getValueAt(row, 1).toString();
				
				StringTokenizer st=new StringTokenizer(inwon,"/");
				int no1=Integer.parseInt(st.nextToken());
				int no2=Integer.parseInt(st.nextToken());
				if(no1==no2) {
					// 방에 들어갈 수 없다
					JOptionPane.showMessageDialog(this,"이미 방인원이 찼습니다\n다른  방을 선택하세요");
				}
				else {
					// 방에 들어갈 수 있다
					try {
						out.write((Function.ROOMIN+"|"+rn+"\n").getBytes());
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
