package com.sist.client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameRoom extends JPanel implements ActionListener {

	boolean[] sw = new boolean[6]; // 들어가면 true, 빈 공백 false
	
	// quiz
	Image quiz = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Quiz\\sports_kappa.png");
	Image quizTitle = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\quizTitle.jpg");

	// 액션 key
	int CheckAction = 0;
	/*
	 * 게임 준비 -> 비활성화 게임 준비 2번 클릭 -> 활성화를 위해 사용
	 */

	// 게임 배경 화면
	Image back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Game.png");
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Image0.png");
	Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Picture.png");

	// 게임화면 창
	JPanel view = new JPanel();
	JLabel viewName = new JLabel("정답을 입력하세요");
	// 유저
	JPanel[] pans = new JPanel[6];
	JTextField[] ids = new JTextField[6];

	// 정답입력창
	JTextField ans = new JTextField(15);

	// 채팅창
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();
	JButton b2, b3, b4, b5;

	// 유저 ?? 유저가 1명씩 들어옴 -> 바꿔야함
	int userKey = 4;
	ArrayList<String> userList = new ArrayList<String>();
	{
		for (int i = 0; i < userKey; i++) {
			userList.add("user" + i);
		}
	}
	String[] userName = { "저팔계", "거북도사", "부르마", "삼장법사", "오공이" };
	JLabel[] u = new JLabel[userList.size()];

	// 유저 점수 출력
	JLabel[] scoreView = new JLabel[userList.size()];
	String[] s1 = new String[u.length];
	int[] score = new int[u.length];
	{
		for (int i = 0; i < u.length; i++) {
			score[i] = 100; // 여기에 점수 변수? 유저 점수가 들어올 자리
			s1[i] = String.valueOf(score[i]);
		}

		for (int i = 0; i < u.length; i++) {
			scoreView[i] = new JLabel("점수:" + s1[i]);
			scoreView[i].setForeground(Color.white);
		}
	}

	// GameRoom()
	public GameRoom() {
		TitledBorder Tb = new TitledBorder(new LineBorder(Color.BLACK));

		// 게임화면
		view.setBackground(Color.white);
		view.setBorder(Tb);
		view.setLayout(new BorderLayout());
		view.setBounds(170, 15, 665, 480);
		add(view);

		for (int i = 0; i < 6; i++) {
			pans[i] = new JPanel();
			pans[i].setBackground(Color.black);
			ids[i] = new JTextField();
		}

		int[] a = { 15, 180, 340 }; // x축 위치
		int[] e = { 140, 305, 470 };// y축 위치
		int j = 0; // y축 위치잡는데 사용하는 변수
		setLayout(null);

		// 아바타 자리 잡기
		for (int i = 0; i < u.length; i++) {
			if (i == 3)
				j = 0;
			if (i < 3) {
				pans[i].setBounds(10, a[j], 150, 120);
				pans[i].setLayout(new BorderLayout());
				pans[i].add("Center", new JLabel(new ImageIcon(
						getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\icon" + i + ".png"), 150, 120))));
				ids[i].setBounds(10, e[j], 65, 30);
				scoreView[i].setBounds(85, e[j], 60, 30);
				ids[i].setEditable(false);
				ids[i].setText(userName[i]);

			}

			else if (i >= 3) {
				pans[i].setBounds(850, a[j], 150, 120);
				pans[i].setLayout(new BorderLayout());
				pans[i].add("Center", new JLabel(new ImageIcon(
						getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Icon" + i + ".png"), 150, 120))));
				ids[i].setBounds(850, e[j], 65, 30);
				scoreView[i].setBounds(926, e[j], 60, 30);
				ids[i].setEditable(false);
				ids[i].setText(userName[i]);
			}
			j++;
		}

		// 패널과 아이콘을 배치
		for (int i = 0; i < u.length; i++) {
			add(pans[i]);
			add(ids[i]);
			add(scoreView[i]);
		}

		// 퀴즈 그림 출력
		view.add("Center", new JLabel(new ImageIcon(
				getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Quiz\\sport_kappa.png"), 300, 300))));
		view.add("North", new JLabel(new ImageIcon(
				getImageSizeChange(new ImageIcon("C:\\\\javaDev\\\\ProjectImage\\quizTitle2.png"), 300, 100))));
		// 채팅창
		JScrollPane js = new JScrollPane(ta);
		// 채팅창 입력되지 않게 고정
		ta.setEditable(false);
		js.setBounds(10, 510, 600, 180);
		add(js);
		tf.setBounds(10, 695, 600, 30);
		add(tf);

		// 정답 입력창
		b2 = new JButton("입력");
//      b2.setForeground(Color.white);
//      viewName.setFont(new Font("궁서체",22,Font.BOLD));
		viewName.setBounds(620, 585, 150, 150);
		viewName.setForeground(Color.white);
		add(viewName);
		ans.setBounds(620, 675, 200, 30);
		add(b2);
		b2.setEnabled(false);
		ans.setEditable(false);
		b2.setBounds(775, 675, 65, 50);
		ans.setSize(150, 50);
		add(ans);

		// 버튼 입력
//      b1=new JButton("초대하기");
		b3 = new JButton("게임준비");
		b4 = new JButton("게임시작");
		b5 = new JButton("나가기");

		// 패널과 버튼들
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1, 8, 8));
//      p.add(b1);p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.setBounds(850, 518, 150, 210);
		p.setOpaque(false);
		add(p);

		b4.addActionListener(this);
		b3.addActionListener(this);
		tf.addActionListener(this);
	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = tf.getText();
		if (e.getSource() == tf) {
			ta.append(text + "\n");
			tf.setText("");
		}
		// 게임준비
		if ((CheckAction == 0) && (e.getSource() == b3)) {
			tf.setEnabled(false);
			b5.setEnabled(false);
			ans.setEditable(true);
			b2.setEnabled(true);
			CheckAction = 5;
		}
		// 게임 준비 2번 눌렀을 떄
		else if ((CheckAction == 5) && (e.getSource() == b3)) {
			tf.setEnabled(true);
			b5.setEnabled(true);
			ans.setEditable(false);
			b2.setEnabled(false);
			CheckAction = 0;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(icon1, 620, 500, 150, 170, this);
		g.drawImage(icon, 718, 500, 130, 170, this);

	}

}
