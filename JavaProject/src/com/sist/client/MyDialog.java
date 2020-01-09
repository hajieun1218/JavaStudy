package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyDialog extends JDialog  {

	JLabel la1, la2;
	JTextField tf;
	JButton btnOK;
	JRadioButton[] radio;
	JPanel panel;
	
//	private String roomName;
//	private String roomPeople;
	
	public MyDialog() {
		la1 = new JLabel("방 제목 : ");
		la2 = new JLabel("방 인원 : ");
		tf = new JTextField(10);
		btnOK = new JButton("방만들기");
		radio = new JRadioButton[4];
		panel = new JPanel();
		
		String[] radio_name = {"2명","3명","4명","5명"};
		
		ButtonGroup group = new ButtonGroup();
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(radio_name[i]);
			group.add(radio[i]);
			panel.add(radio[i]);
		}
		
		// 디폴트 선택
		radio[0].setSelected(true);
		
		setLayout(new FlowLayout());
		add(la1);
		add(tf);
		add(la2);
		add(panel);
		add(btnOK);
		
		setSize(400,250);
		
		
	}

}
