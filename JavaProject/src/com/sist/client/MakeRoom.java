package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MakeRoom extends JDialog implements ActionListener {

	JLabel la1,la2,la3;
	JTextField tf;
	JComboBox box;
	JRadioButton rb1,rb2,rb3,rb4;
	JButton b1,b2;
	
	public MakeRoom() {
		la1=new JLabel("방이름",JLabel.RIGHT);
		la2=new JLabel("게임주제",JLabel.RIGHT);
		la3=new JLabel("인원",JLabel.RIGHT);
//		la4=new JLabel("비밀번호");
		
		tf=new JTextField();
		rb1=new JRadioButton("애니메이션");
		rb2=new JRadioButton("의류브랜드");
		rb3=new JRadioButton("연예인");
		rb4=new JRadioButton("스포츠브랜드");
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		// 선택
		rb1.setSelected(true);
		
		
		b1=new JButton("방만들기");
		b2=new JButton("취소");
		
		box=new JComboBox();
		for(int i=2;i<=6;i++) {
			box.addItem(i+"명");
		}
		
		
		// 배치
		setLayout(null);
		la1.setBounds(10,15,70,30);
		tf.setBounds(85,15,150,30);
		
		la2.setBounds(10,50,70,30);
		rb1.setBounds(85,50,100,30);
		rb2.setBounds(190,50,100,30);
		rb3.setBounds(85,85,100,30);
		rb4.setBounds(190,85,105,30);
		
//		la4.setBounds(65,85,55,30);
//		pf.setBounds(120,85,95,30);
		
		la3.setBounds(10,120,70,30);
		box.setBounds(85,120,150,30);
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(10,160,300,35);
		
		add(la1); add(tf);
		add(la2); add(rb1); add(rb2); add(rb3); add(rb4);
//		add(la4); add(pf);
		add(la3); add(box);
		add(p);
		
		setSize(325,255);
//		setVisible(true);
		
		rb1.addActionListener(this);
		rb2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MakeRoom();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource()==rb1) {
//			la4.setVisible(false);
//			pf.setVisible(false);
//			pf.setText("");
//		}
//		else if(e.getSource()==rb2) {
//			la4.setVisible(true);
//			pf.setVisible(true);
//			pf.setText("");
//			pf.requestFocus();
//		}
	}

}
