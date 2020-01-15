package com.sist.client;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameRoom extends JPanel implements ActionListener {

	boolean[] sw = new boolean[6]; // ���� true, �� ���� false
	
	// quiz
	Image quiz = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Quiz\\sports_kappa.png");
	Image quizTitle = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\quizTitle.jpg");

	// �׼� key
	int CheckAction = 0;
	/*
	 * ���� �غ� -> ��Ȱ��ȭ ���� �غ� 2�� Ŭ�� -> Ȱ��ȭ�� ���� ���
	 */

	// ���� ��� ȭ��
	Image back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Game.png");
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Image0.png");
	Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Picture.png");

	// ����ȭ�� â
	JPanel view = new JPanel();
	JLabel viewName = new JLabel("������ �Է��ϼ���");
	// ����
	JPanel[] pans = new JPanel[6];
	JTextField[] ids = new JTextField[6];

	// �����Է�â
	JTextField ans = new JTextField(15);

	// ä��â
	JTextArea ta = new JTextArea();
	JTextField tf = new JTextField();
	JButton b2, b3, b4, b5;

	// ���� ?? ������ 1�� ���� -> �ٲ����
	int userKey = 4;
	ArrayList<String> userList = new ArrayList<String>();
	{
		for (int i = 0; i < userKey; i++) {
			userList.add("user" + i);
		}
	}
	String[] userName = { "���Ȱ�", "�źϵ���", "�θ���", "�������", "������" };
	JLabel[] u = new JLabel[userList.size()];

	// ���� ���� ���
	JLabel[] scoreView = new JLabel[userList.size()];
	String[] s1 = new String[u.length];
	int[] score = new int[u.length];
	{
		for (int i = 0; i < u.length; i++) {
			score[i] = 100; // ���⿡ ���� ����? ���� ������ ���� �ڸ�
			s1[i] = String.valueOf(score[i]);
		}

		for (int i = 0; i < u.length; i++) {
			scoreView[i] = new JLabel("����:" + s1[i]);
			scoreView[i].setForeground(Color.white);
		}
	}

	// GameRoom()
	public GameRoom() {
		TitledBorder Tb = new TitledBorder(new LineBorder(Color.BLACK));

		// ����ȭ��
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

		int[] a = { 15, 180, 340 }; // x�� ��ġ
		int[] e = { 140, 305, 470 };// y�� ��ġ
		int j = 0; // y�� ��ġ��µ� ����ϴ� ����
		setLayout(null);

		// �ƹ�Ÿ �ڸ� ���
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

		// �гΰ� �������� ��ġ
		for (int i = 0; i < u.length; i++) {
			add(pans[i]);
			add(ids[i]);
			add(scoreView[i]);
		}

		// ���� �׸� ���
		view.add("Center", new JLabel(new ImageIcon(
				getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Quiz\\sport_kappa.png"), 300, 300))));
		view.add("North", new JLabel(new ImageIcon(
				getImageSizeChange(new ImageIcon("C:\\\\javaDev\\\\ProjectImage\\quizTitle2.png"), 300, 100))));
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
//      b2.setForeground(Color.white);
//      viewName.setFont(new Font("�ü�ü",22,Font.BOLD));
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
//      b1=new JButton("�ʴ��ϱ�");
		b3 = new JButton("�����غ�");
		b4 = new JButton("���ӽ���");
		b5 = new JButton("������");

		// �гΰ� ��ư��
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
		// �����غ�
		if ((CheckAction == 0) && (e.getSource() == b3)) {
			tf.setEnabled(false);
			b5.setEnabled(false);
			ans.setEditable(true);
			b2.setEnabled(true);
			CheckAction = 5;
		}
		// ���� �غ� 2�� ������ ��
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
