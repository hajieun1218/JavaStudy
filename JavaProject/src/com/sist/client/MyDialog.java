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
		la1 = new JLabel("�� ���� : ");
		la2 = new JLabel("�� �ο� : ");
		tf = new JTextField(10);
		btnOK = new JButton("�游���");
		radio = new JRadioButton[4];
		panel = new JPanel();
		
		String[] radio_name = {"2��","3��","4��","5��"};
		
		ButtonGroup group = new ButtonGroup();
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(radio_name[i]);
			group.add(radio[i]);
			panel.add(radio[i]);
		}
		
		// ����Ʈ ����
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
