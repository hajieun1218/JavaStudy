import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 *    interface ==> implements �������̽���
 *    =========
 *      ���� ����� ����
 *      
 *      interface A
 *      interface B
 *      class C implements A,B,...
 */
public class MyTextField extends JFrame implements ActionListener {

	JTextField tf = new JTextField();  // �Է�â
	JTextArea ta = new JTextArea();
	
	public MyTextField() {
		
		ta.setEditable(false);   // ���� �Ұ���
		JScrollPane js = new JScrollPane(ta);
		add("Center", js);
		add("South", tf);
		setSize(350, 450);
		setVisible(true);
		
		// �̺�Ʈ ���
		tf.addActionListener(this); // MyTextField�� �ִ�  actionPerformed�� ȣ��// ���ͽ� �̺�Ʈ �߻�
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ������ ȣ��
		new MyTextField();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == tf) {  // ���͸� ģ textfield�� ����
			ta.append(tf.getText() + "\n");
			// append(���ڿ� ����), setText(���ο� ���ڸ� ���)
			// tf.getText() => �Էµ� ���ڸ� �о�´�
		}
	}

}
