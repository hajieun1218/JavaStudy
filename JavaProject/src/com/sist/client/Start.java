package com.sist.client;
import java.awt.*;

import javax.swing.*;



public class Start extends JPanel{
	Image back;
	
	JLabel la1,la2;  // �� �Է��ؾ��ϴ°����� ����
	JButton b1,b2,b3;
	JPanel p,p2;
	Font f1;
	Font f2;
	
	public Start(){
		setLayout(null);
		back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Start.png");
		f1 = new Font("Segoe Script", Font.BOLD, 30);
		f2 = new Font("Segoe Script", Font.BOLD, 25);

		b1 = new JButton("Start");
		b2 = new JButton("Help");
		b3 = new JButton("Exit");
		b1.setFont(f1);
		b2.setFont(f2);
		b3.setFont(f2);

		p = new JPanel();
		p2 = new JPanel();
		p.setBackground(new Color(255, 0, 0, 0));    //����
		p2.setBackground(new Color(255, 0, 0, 0));    //����
		
		// ��ư ������ ���ֱ�
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		// ��ư ä��� ���ֱ�
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		// ��ư ���ý� ���ֱ�
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
		b3.setFocusPainted(false);
		// ��ư ���� �Ͼ�
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		b3.setForeground(Color.WHITE);
		
		// ��ġ
		add(p);
		p.add(b1);
		
		p.setBounds(390,405,235,50);
		p.setOpaque(false); // panel ����ִ� �κ� ���� (��ġ�� �Ÿ��� �κ� �߶󳻱�)
		
		add(p2);
		p2.add(b2);
		p2.add(b3);
		p2.setBounds(760,438,100,110);
		p2.setOpaque(false);
		
	
			
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
	
}
