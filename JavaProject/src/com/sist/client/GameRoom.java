package com.sist.client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameRoom extends JPanel {

	boolean[] sw = new boolean[6]; // 들어가면 true, 빈 공백 false

	// 게임 배경 화면

	Image back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Game.png");
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Image0.png");
	Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Picture.png");

	// 게임화면 창
	GameVIew games = new GameVIew();
	JLabel viewName = new JLabel("정답을 입력하세요");

	// 유저
	JPanel[] pans = new JPanel[6];
	JTextField[] ids = new JTextField[6];

	// 정답입력창
	JTextField ans = new JTextField(15);

	// 채팅창
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();

	// 버튼
	JButton b1, b2, b3, b4, b5;

	// 유저 점수 출력

	// 시간 프로그레스바
	JProgressBar bar = new JProgressBar();

	// GameRoom()
	public GameRoom() {

		setLayout(null);
		
		TitledBorder Tb = new TitledBorder(new LineBorder(Color.BLACK));

		// 게임화면
//      view.setBackground(Color.white);
//      view.setBorder(Tb);
//      view.setLayout(new BorderLayout());
//      view.setBounds(170,15, 665, 480);
//      add(view);

		for (int i = 0; i < 6; i++) {
			pans[i] = new JPanel();
			pans[i].setBackground(Color.black);
			ids[i] = new JTextField();
			ids[i].setEditable(false);
		}

//		// 패널과 아이콘을 배치
//		for (int i = 0; i < 6; i++) {
//			add(pans[i]);
//			add(ids[i]);
//		}
		pans[0].setBounds(10, 15, 150, 120);
		pans[0].setLayout(new BorderLayout());
		pans[0].add("Center", new JLabel(
				new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
		ids[0].setBounds(10, 140, 150, 30);

		pans[1].setBounds(850, 15, 150, 120);
		pans[1].setLayout(new BorderLayout());
		pans[1].add("Center", new JLabel(
				new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
		ids[1].setBounds(850, 140, 150, 30);

		pans[2].setBounds(10, 180, 150, 120);
		pans[2].setLayout(new BorderLayout());
		pans[2].add("Center", new JLabel(
				new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
		ids[2].setBounds(10, 305, 150, 30);

		pans[3].setBounds(850, 180, 150, 120);
		pans[3].setLayout(new BorderLayout());
		pans[3].add("Center", new JLabel(
				new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
		ids[3].setBounds(850, 305, 150, 30);

		pans[4].setBounds(10, 345, 150, 120);
		pans[4].setLayout(new BorderLayout());
		pans[4].add("Center", new JLabel(
				new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
		ids[4].setBounds(10, 470, 150, 30);

		pans[5].setBounds(850, 345, 150, 120);
		pans[5].setLayout(new BorderLayout());
		pans[5].add("Center", new JLabel(
				new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 150, 120))));
		ids[5].setBounds(850, 470, 150, 30);

		// 패널과 아이콘을 배치
		for (int i = 0; i < 6; i++) {
			add(pans[i]);
			add(ids[i]);

		}

		// 게임 화면
		games.setBackground(Color.white);
		games.setBounds(170, 15, 670, 485);
		add(games);

		// 게임화면에 퀴즈 띄우기
		games.setLayout(new BorderLayout());
		games.add("Center", new JLabel(new ImageIcon(
				getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Quiz\\3_3.png"), 300, 300))));
		games.add("North", new JLabel(new ImageIcon(
				getImageSizeChange(new ImageIcon("C:\\\\javaDev\\\\ProjectImage\\quizTitle2.png"), 400, 100))));

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
		b1 = new JButton("다음문제");
		b3 = new JButton("게임준비");
		b4 = new JButton("게임시작");
		b5 = new JButton("나가기");

		// 패널과 버튼들
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1, 8, 8));
		p.add(b4);
		p.add(b1);
		p.add(b5);
		p.setBounds(850, 518, 150, 210);
		p.setOpaque(false);
		add(p);

		// 프로그레스바 설정
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setForeground(Color.yellow);
		bar.setBackground(Color.white);
		bar.setStringPainted(true); // 몇퍼센트 표시
		games.add("South",bar);
	}

	public static Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(icon1, 620, 500, 150, 170, this);
		g.drawImage(icon, 718, 500, 130, 170, this);

	}

}