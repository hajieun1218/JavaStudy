package com.sist.client;
/*
 *   배치 
 *    = BorderLayout : JFrame(최대화,최소화,닫기), JDialog(닫기), JWindow(아무것도 없음)
 *        5군데 배치 (East West Center North South)
 *    = FlowLayout
 *    = GridLayout
 *    = 사용자 정의
 */

import java.awt.*;   // Layout, Event
import javax.swing.*; // Window관련 모든것

public class LayoutEx {

	JFrame frame = new JFrame("BorderLayout");
	
	public LayoutEx() {
		
		JButton[] btn = new JButton[5];
		String[] layout = {"East", "West", "Center", "North", "South"};
		
//		for(int i=0; i<5; i++) {
//			btn[i] = new JButton(layout[i]);
//			frame.add(layout[i], btn[i]);
//		}
		
		btn[0] = new JButton("West");
		frame.add("West", btn[0]);
		btn[1] = new JButton("East");
		frame.add("East", btn[1]);
		
		frame.setSize(350, 350);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LayoutEx ex = new LayoutEx();
	}

}
