import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;  // window와 관련된 클래스

/*
 *   JFrame
 *   JPanel
 *   JWindow
 *   JDialog
 */

public class Login extends JPanel{
	// 클래스 영역 안에서는 선언만 가능 , 구현X
	Image back;
	JLabel la1,la2;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2;
	
	// 아무것도 안붙이면 생성자, 앞에 리턴형 붙이면 일반 메소드
	Login() {
		setLayout(null);
		
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\javaProject\\background.jpg");
		la1 = new JLabel("ID", JLabel.RIGHT);
		la1.setForeground(Color.white);
		la2 = new JLabel("Password", JLabel.RIGHT);
		la2.setForeground(Color.white);
		
		tf = new JTextField();
		pf = new JPasswordField();
		
		b1 = new JButton("로그인");
		b2 = new JButton("취소");
		
		// 배치
		la1.setBounds(390, 330, 80, 30);
		tf.setBounds(475, 330, 150, 30);
		la2.setBounds(390, 365, 80, 30);
		pf.setBounds(475, 365, 150, 30);
		
		// 패널 위에 버튼을 위치하면 정가운데에 배치 가능
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(390, 405, 235, 35);
		p.setOpaque(false); // 배경 투명하게
		
		add(la1);
		add(tf);
		add(la2);
		add(pf);
		add(p);
	}
	
	// 스킨  (게임-paint사용)
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}

	
}
