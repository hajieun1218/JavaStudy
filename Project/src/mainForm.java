import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class mainForm extends JFrame implements ActionListener{

	Start start = new Start();
	WaitRoom wait = new WaitRoom();
	CardLayout card = new CardLayout();
	
	mainForm() {
		setLayout(card);
		add("Start", start);
		add("Wait", wait);
		setSize(1024,768); // 윈도우 크기
		setVisible(true);
		
		start.b1.addActionListener(this);
	}
	
	public static void main(String[] args) {
		mainForm mf = new mainForm();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == start.b1) {
			card.show(getContentPane(), "Wait");
		}
	}

}
