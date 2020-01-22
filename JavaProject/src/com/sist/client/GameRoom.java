package com.sist.client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameRoom extends JPanel {

	boolean[] sw = new boolean[6]; // ���� true, �� ���� false

	Font f1 = new Font("����", Font.BOLD, 25);
	
	// ���� ��� ȭ��

	Image back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Game.png");
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Image0.png");
	Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Picture.png");

	// ����ȭ�� â
	GameVIew games = new GameVIew();
	JLabel viewName = new JLabel("������ �Է��ϼ���");

	// ����
	JPanel[] pans = new JPanel[6];
	JTextField[] ids = new JTextField[6];

	// �����Է�â
	JTextField ans = new JTextField(15);

	// ä��â
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();

	// ��ư
	JButton b1, b2, b3, b4, b5;

	// ���� ���� ���

	// �ð� ���α׷�����
	JProgressBar bar = new JProgressBar();

	// ���� O X
	JLabel[] daps = new JLabel[20];
	JPanel ppp = new JPanel();

	// GameRoom()
	public GameRoom() {

		setLayout(null);

		for (int i = 0; i < 6; i++) {
			pans[i] = new JPanel();
			pans[i].setBackground(Color.black);
			ids[i] = new JTextField();
			ids[i].setEditable(false);
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

		// �гΰ� �������� ��ġ
		for (int i = 0; i < 6; i++) {
			add(pans[i]);
			add(ids[i]);

		}
		// ���� ���� �ø� �г�
		
		ppp.setLayout(new GridLayout(2, 10, 3, 3));
		for (int i = 0; i < 20; i++) {
			daps[i] = new JLabel();
			ppp.add(daps[i]);
		}
		// ���� OX �� ��ġ
		for (int i = 0; i < 10; i++) {
			daps[i].setIcon(new ImageIcon(
					getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\n" + (i + 1) + ".png"), 65, 40)));
		}
		ppp.setBounds(170, 370, 670, 100);
		ppp.setBackground(Color.white);
		add(ppp);

		// ���� ȭ��
		games.setBackground(Color.white);
//		games.setBounds(170, 15, 670, 485);
		games.setBounds(170, 15, 670, 350);
		add(games);

		// ����ȭ�鿡 ���� ����
//		games.setLayout(new BorderLayout());
//		games.add("Center", new JLabel(new ImageIcon(
//				getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Quiz\\3_3.png"), 300, 300))));
//		games.add("North", new JLabel(new ImageIcon(
//				getImageSizeChange(new ImageIcon("C:\\\\javaDev\\\\ProjectImage\\quizTitle2.png"), 400, 100))));

		// ä��â
		JScrollPane js = new JScrollPane(ta);
		// ä��â �Էµ��� �ʰ� ����
		ta.setEditable(false);
		js.setBounds(10, 510, 600, 180);
		add(js);
		tf.setBounds(10, 695, 600, 30);
		add(tf);

		// ���� �Է�â
		b2 = new JButton("�Է�");
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

		// ��ư �Է�
		b1 = new JButton("��������");
		b3 = new JButton("�����غ�");
		b4 = new JButton("���ӽ���");
		b5 = new JButton("������");
		
		b1.setEnabled(false);
		
//		b1.setContentAreaFilled(false);
//		b5.setContentAreaFilled(false);
//	    b1.setFocusPainted(false);
//	    b5.setFocusPainted(false);
//	    b1.setFont(f1);
//	    b5.setFont(f1);
//	    b1.setForeground(Color.WHITE);
//	    b5.setForeground(Color.WHITE);

		// �гΰ� ��ư��
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1, 8, 8));
//		p.add(b4);
		p.add(b1);
		p.add(b5);
		p.setBounds(850, 518, 150, 207);
		p.setOpaque(false);
		add(p);

		// ���α׷����� ����
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setForeground(Color.yellow);
		bar.setBackground(Color.white);
		bar.setStringPainted(true); // ���ۼ�Ʈ ǥ��
		bar.setBounds(170, 475, 670, 25);
		add(bar);
//		games.add("South",bar);

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