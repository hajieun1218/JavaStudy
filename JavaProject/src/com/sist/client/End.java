package com.sist.client;
import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class End extends JPanel{
	Image back;
	JButton b1;
	JPanel p;
	
	End(){
		setLayout(null);
		back = Toolkit.getDefaultToolkit().getImage("E:\\ProjectImage\\End.png");
		p = new JPanel();
		b1 = new JButton("종료");
		b1.setFont(new Font("궁서",Font.BOLD,22));
		
		//배치
		add(p);
		p.setBounds(100,100,100,100);
		p.add(b1);
		p.setOpaque(false);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("순위 표시", 400,400);
		g.setFont(new Font("궁서체",Font.BOLD,40));
		g.drawImage(back,0,0, getWidth(), getHeight(), this);
	}
	
	
	
	
}
