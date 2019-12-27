import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Start extends JPanel{
	Image back;
	
	JLabel la1,la2;  // 뭘 입력해야하는것인지 지시
	JButton b1,b2,b3;
	JPanel p,p2;
	Font f1;
	Font f2;
	Start(){
		setLayout(null);
		back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\javaProject\\background.png");
		f1 = new Font("Segoe Script", Font.BOLD, 35);
		f2 = new Font("Segoe Script", Font.BOLD, 25);

		b1 = new JButton("Start");
		b2 = new JButton("Help");
		b3 = new JButton("Exit"+ "");
		b1.setFont(f1);
		b2.setFont(f2);
		b3.setFont(f2);
		
		b1.setBorderPainted(false);    // JButton의 Border(외곽선)을 없애줌
		b1.setContentAreaFilled(false); // JButton의 내용영역 채우기 안함
		b1.setFocusPainted(false);   // JButton이 선택되었을 때 생기는 테두리 사용안함
		b1.setForeground(Color.white);  // 글자색 =>화이트
		
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		b2.setForeground(Color.white);
		
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setFocusPainted(false);
		b3.setForeground(Color.white);

		p = new JPanel();
		p2 = new JPanel();
//		p.setBackground(new Color(255, 0, 0, 0));    //투명
//		p2.setBackground(new Color(255, 0, 0, 0));    //투명
		
		// 배치
		add(p);
		p.add(b1);
		p.setBounds(390,405,235,50);
		p.setOpaque(false); // panel 띄워주는 부분 삭제 (거치적 거리는 부분 잘라내기)
		
		add(p2);
		p2.add(b2);
		p2.add(b3);
		p2.setBounds(754,450,100,110);
		p2.setOpaque(false);
			
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
	
}
