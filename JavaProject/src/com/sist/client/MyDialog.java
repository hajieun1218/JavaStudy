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
	JPanel p1,p2,p3;
	Font f1;
	
//	private String roomName;
//	private String roomPeople;
	
	public MyDialog() {
		
		setLayout(null);
		f1 = new Font("굴림", Font.BOLD, 15);
		
		la1 = new JLabel("방 제목 : ");
		la1.setFont(f1);
		tf = new JTextField(15);
		tf.setFont(f1);
		
		
		la2 = new JLabel("방 인원 : ");
		la2.setFont(f1);
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
		p1.setBounds(50,50,300,30);
		
		p2 = new JPanel();
		p2.add(la2);
		p2.add(panelRadio);
		p2.setBounds(50,80,300,30);
		
		
		btnOK = new JButton("방만들기");
		btnOK.setFont(f1);
		btnCancel = new JButton("취소");
		btnCancel.setFont(f1);
		
		// 디폴트 선택
		radio[0].setSelected(true);
		
		p3 = new JPanel();
		p3.add(btnOK);
		p3.add(btnCancel);
		p3.setBounds(50,150,300,50);
		
		add(p1);
		add(p2);
		add(p3);
		
//		add("Center",p1);
//		add("South",p2);

//		add(la1);
//		add(tf);
//		add(la2);
//		add(panelRadio);
//		add(btnOK);
		
		setSize(400,250);
		
		
	}

}
