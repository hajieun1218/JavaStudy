import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainClass6 extends JFrame implements ActionListener, MouseListener {

	JButton b = new JButton("Click");
	
	public MainClass6() {
		
		// 배치
		add("North", b);
		
		setSize(480, 300);
		setVisible(true);
		
//		b.addActionListener(this);  // b를 누르면 메소드를 호출해라(이벤트 등록)
		b.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass6();
	}

	// 버튼 눌렀을 때 처리하는 함수
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b) {
			System.out.println("B버튼 클릭!!");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b) {
			System.out.println("마우스 버튼 클릭!!");
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
