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
		la1 = new JLabel("�� ���� : ");
		tf = new JTextField(10);
		
		
		la2 = new JLabel("�� �ο� : ");
		radio = new JRadioButton[4];
		panelRadio = new JPanel();
		
		String[] radio_name = {"2��","3��","4��","5��"};
		
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
		
		
		btnOK = new JButton("�游���");
		btnCancel = new JButton("���");
		
		// ����Ʈ ����
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
