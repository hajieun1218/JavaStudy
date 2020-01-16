package com.sist.client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameRoom extends JPanel implements ActionListener {

	boolean[] sw = new boolean[6]; // 들어가면 true, 빈 공백 false
	// 액션 key
	int CheckAction = 0;
	// quiz
	Image quiz = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Quiz\\sports_kappa.png");
	Image quizTitle = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\quizTitle.jpg");

	// 게임 배경 화면

	Image back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Game.png");
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Image0.png");
	Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Picture.png");

	// 게임화면 창
	// JPanel view = new JPanel();
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
	JButton b2, b3, b4, b5;

	// 유저 점수 출력

	// GameRoom()
	public GameRoom() {
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
		}

		setLayout(null);
		// 패널과 아이콘을 배치
		for (int i = 0; i < 6; i++) {
			add(pans[i]);
			add(ids[i]);
		}
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
				getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Quiz\\sport_kappa.png"), 300, 300))));
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

	public static Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = tf.getText();
//		if (e.getSource() == tf) {
//			ta.append(text + "\n");
//			tf.setText("");
//		}
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