package com.sist.client;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class End extends JPanel{
	Image back;
	JButton b1 = new JButton();
	JPanel p = new JPanel();
	
	JPanel scoreBoard ;
	LineBorder bb;
	End(){
		setLayout(null);
		back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\End.png");
		b1 = new JButton("��");
		b1.setFont(new Font("�ü�",Font.BOLD,22));
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		p = new JPanel(new BorderLayout());
		add(p);
		p.setBounds(0,0,1024,768);
		p.setOpaque(false);
		p.add("Center",b1);
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("���� ǥ��", 400,400);
		g.setFont(new Font("�ü�ü",Font.BOLD,40));
		g.drawImage(back,0,0, getWidth(), getHeight(), this);
	}
	
	
	
	
}
