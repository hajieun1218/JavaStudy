package com.sist.client;
import java.awt.*;

import javax.swing.*;

public class End extends JPanel{
	Image back;
	JButton b1,b2;
	JPanel p;
	
	JTextArea scoreBoard =new JTextArea();
	End(){
		setLayout(null);
		back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\End.png");
		p = new JPanel();
		b1 = new JButton("����");
		b1.setFont(new Font("�ü�",Font.BOLD,22));
		b2 = new JButton("�����");
		b2.setFont(new Font("�ü�",Font.BOLD,22));
		//��ġ
		add(p);
		p.setBounds(200,200,200,200);
		p.add(b1);
		p.add(b2);
		p.setOpaque(false);
		
		add(scoreBoard);
		scoreBoard.setBackground(Color.white);
		scoreBoard.setBounds(0,0,300,300);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("���� ǥ��", 400,400);
		g.setFont(new Font("�ü�ü",Font.BOLD,40));
		g.drawImage(back,0,0, getWidth(), getHeight(), this);
	}
	
	
	
	
}
