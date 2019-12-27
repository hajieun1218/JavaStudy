import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.*;

public class WaitRoom extends JPanel implements ActionListener{
	Image back;
	JTable table1, table2;
	DefaultTableModel model1, model2;
	JTextPane tp;  // ������ �Է�
	JTextField tf; // ���� �Է�
	JButton b1, b2, b3;
	Font f1;

	
	WaitRoom() {
	    f1 = new Font("�ü�", Font.BOLD,25);
		back = Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\javaProject\\background2.jpg");
		
		String[] col1 = {"��ȣ","����","����"};
		String[][] row = new String[0][3];
		model1 = new DefaultTableModel(row, col1);
		table1 = new JTable(model1);
		JScrollPane js1 = new JScrollPane(table1);
		
		String[] col2 = {"ID","�̸�","����","��ġ"};
		String[][] row2 = new String[0][4];
		model2 = new DefaultTableModel(row2, col2);
		table2 = new JTable(model2);
		JScrollPane js2 = new JScrollPane(table2);
		
		setLayout(null);
		
		js1.setBounds(75, 50, 470, 300);
		js2.setBounds(550, 50, 380, 300);
		
		tp = new JTextPane();
		tf = new JTextField();
		b1 = new JButton("�游���");
		b2 = new JButton("�����");
		b3 = new JButton("������");
		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);
		
		JScrollPane js3 = new JScrollPane(tp);
		js3.setBounds(75, 355, 470, 290);
		
		tf.setBounds(75, 650, 470, 30);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1,5,5));   //1���� 3�� ����5
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.setOpaque(false);
		
		p.setBounds(750, 420, 180, 200);

		add(p);
		add(tf);
		add(js3);
		add(js1);
		add(js2);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}




