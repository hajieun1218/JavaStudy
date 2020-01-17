package com.sist.image;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainForm2 extends JFrame implements ActionListener,Runnable {

	JButton b;
	JProgressBar bar;
	
	public MainForm2() {
		
		b=new JButton("Start");
		bar=new JProgressBar();
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setForeground(Color.cyan);
		bar.setBackground(Color.white);
		bar.setStringPainted(true); // 몇퍼센트 진행되고 있는지 
		
		add("Center",bar);
		add("South",b);
		
		setSize(450,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b.addActionListener(this);
	}
	
	public void go() {
		try {
			for(int i=0;i<=100;i++) {
				bar.setValue(i);
				Thread.sleep(100);
			}
		} catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MainForm2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b) {
			new Thread(this).start();
			// thread 사용하지 않으면 진행과정이 보이지 않고 결과만 나타남
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		go();
	}
	
	

}
