package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyDialog extends JDialog  {

	JLabel la1, la2;
	JTextField tf;
	JButton btnOK, btnCancel;
	JRadioButton[] radio;
	JPanel panelRadio;
	JPanel p1,p2;
	
//	private String roomName;
//	private String roomPeople;
	
	public MyDialog() {
		la1 = new JLabel("방 제목 : ");
		tf = new JTextField(10);
		
		
		la2 = new JLabel("방 인원 : ");
		radio = new JRadioButton[4];
		panelRadio = new JPanel();
		
		String[] radio_name = {"2명","3명","4명","5명"};
		
		ButtonGroup group = new ButtonGroup();
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(radio_name[i]);
			group.add(radio[i]);
			panelRadio.add(radio[i]);
		}
		
		p1 = new JPanel();
		p1.add(la1);
		p1.add(tf);
		p1.add(la2);
		p1.add(panelRadio);
		
		
		btnOK = new JButton("방만들기");
		btnCancel = new JButton("취소");
		
		// 디폴트 선택
		radio[0].setSelected(true);
		
		p2 = new JPanel();
		p2.add(btnOK);
		p2.add(btnCancel);
		
//		setLayout(new FlowLayout());
		add("Center",p1);
		add("South",p2);

//		add(la1);
//		add(tf);
//		add(la2);
//		add(panelRadio);
//		add(btnOK);
		
		setSize(400,250);
		
		
	}

}
