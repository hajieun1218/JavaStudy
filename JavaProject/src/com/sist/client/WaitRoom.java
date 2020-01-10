package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class WaitRoom extends JPanel implements ActionListener, MouseListener {

	JTable table1, table2;
	DefaultTableModel model1, model2;
	JTextArea tp;
	JTextField tf;
	JButton b1, b2, b3;
	Font f1;
	MyDialog md = new MyDialog();
	int roomNo=1;

	public WaitRoom() {
		f1 = new Font("궁서", Font.BOLD, 25);
		
		setLayout(null);
		
		// 방 리스트
		String[] col1 = { "방 번호", "방 이름", "인원" };
		String[][] row1 = new String[0][3];
		model1 = new DefaultTableModel(row1, col1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false; // 수정 불가능
			}
		};
		table1 = new JTable(model1);
		table1.setRowHeight(38);
		JScrollPane js1 = new JScrollPane(table1);
		table1.getTableHeader().setReorderingAllowed(false); // 테이블헤더 고정
		table1.getTableHeader().setBackground(Color.pink);
		js1.getViewport().setBackground(Color.white);
		js1.setBounds(10, 15, 600, 400);
		
		
		// 접속한 유저
		String[] col2 = { "ID", "위치" };
		String[][] row2 = new String[0][2];
		model2 = new DefaultTableModel(row2, col2) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false; // 수정 불가능
			}
		};
		table2 = new JTable(model2);
		table2.setRowHeight(38);
		JScrollPane js2 = new JScrollPane(table2);
		table2.getTableHeader().setReorderingAllowed(false); // 테이블헤더 고정
		table2.getTableHeader().setBackground(Color.pink);
		js2.getViewport().setBackground(Color.white);
		js2.setBounds(615, 15, 385, 400);
		
		
		// 채팅창
		tp = new JTextArea();
		tf = new JTextField();
		tp.setEditable(false);
		JScrollPane js3 = new JScrollPane(tp);
		js3.setBounds(10, 420, 600, 260);
		tf.setBounds(10, 690, 600, 30);
		
		
		// 버튼
		b1 = new JButton("방만들기");
		b2 = new JButton("방들어가기");
		b3 = new JButton("나가기");
		b1.setFont(f1);
		b1.setSize(50, 50);
		b2.setFont(f1);
		b2.setSize(50, 50);
		b3.setFont(f1);
		b3.setSize(50, 50);
		// 버튼 배경 지우기
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
		b3.setFocusPainted(false);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 2, 5, 5));
		p.setOpaque(false);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.setBounds(615, 610, 380, 100);
		
		
		add(tf);
		add(p);
		add(js3);
		add(js1);
		add(js2);

		// 이벤트등록
		tf.addActionListener(this);
		table1.addMouseListener(this);
		table2.addMouseListener(this);
		b1.addActionListener(this);
		md.btnOK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// 채팅창 Enter
		if (e.getSource() == tf) { // 엔터를 친 textfield가 뭐냐
			tp.append(tf.getText() + "\n");
			tf.setText("");
			tf.requestFocus();
		}
		// 방만들기 => 다이얼로그창
		else if(e.getSource()==b1) {
			md.setLocation(this.getWidth()/2-md.getWidth()/2, this.getHeight()/2-md.getHeight()/2);
			md.setVisible(true);
		}
		// 다이얼로그창 => 방이름,인원 선택 후 방만들기 버튼
		else if(e.getSource()==md.btnOK) {
			String roomName=md.tf.getText();
			if(roomName.length()<1) {
				JOptionPane.showMessageDialog(this, "방 이름을 입력하세요!");
				return;
			}
			String roomPeople = "";
			for(int i=0;i<md.radio.length;i++) {
				if(md.radio[i].isSelected())
					roomPeople=md.radio[i].getText().substring(0,1);
			}
			String[] data= {String.valueOf(roomNo),roomName,"1/"+roomPeople};
			roomNo++;
			model1.addRow(data);
			
			md.tf.setText("");
			md.radio[0].setSelected(true);
			
			md.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == table1) {
			if(e.getClickCount() == 2) {  // 더블클릭
				int row = table1.getSelectedRow();
				String no = model1.getValueAt(row, 0).toString();
				String name = model1.getValueAt(row, 1).toString();
				String num = model1.getValueAt(row, 2).toString();
				
				String data = "방번호 : " + no + "\n"
						    + "방이름 : " + name + "\n"
						    + "상태 : " + num;
				
				JOptionPane.showMessageDialog(this, data);
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
