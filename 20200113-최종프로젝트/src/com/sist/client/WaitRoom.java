package com.sist.client;
import javax.swing.*;

import java.awt.*;
import javax.swing.table.*;

public class WaitRoom extends JPanel{

	JTable table1, table2;
	DefaultTableModel model1, model2;
	JTextArea tp;  // 여러줄 입력
	JTextField tf; // 한줄 입력
	JButton b1, b2, b3, b4, b5, b6;
	
	WaitRoom() {
		String[] col1 = {"방이름","공개/비공개","인원"};
		String[][] row = new String[0][3];
		model1 = new DefaultTableModel(row, col1);
		table1 = new JTable(model1);
		JScrollPane js1 = new JScrollPane(table1);
		
		String[] col2 = {"ID","이름","성별","위치"};
		String[][] row2 = new String[0][4];
		model2 = new DefaultTableModel(row2, col2);
		table2 = new JTable(model2);
		JScrollPane js2 = new JScrollPane(table2);
		
		setLayout(null);
		
		js1.setBounds(10, 15, 600, 400);
		js2.setBounds(10, 420, 600, 290);
		
		tp = new JTextArea();
		tf = new JTextField();
		b1 = new JButton("방만들기");
		b2 = new JButton("방들어가기");
		b3 = new JButton("쪽지보내기");
		b4 = new JButton("정보보기");
		b5 = new JButton("1:1게임");
		b6 = new JButton("나가기");
		
		JScrollPane js3 = new JScrollPane(tp);
		js3.setBounds(615, 15, 380, 400);
		
		tf.setBounds(615, 420, 380, 30);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,2,5,5));   //2개씩 3줄 간격5
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		
		p.setBounds(615, 460, 380, 240);

		add(p);
		add(tf);
		add(js3);
		add(js1);
		add(js2);
	}
}
