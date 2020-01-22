package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class WaitRoom extends JPanel implements ActionListener{

   // ���� ��� ȭ��
   Image back;
//   JPanel myInfo=new JPanel();
//   JLabel myAvatar=new JLabel();
   
   JTable table1, table2;
   DefaultTableModel model1, model2;
   JTextArea tp;
   JTextField tf;
   JButton b1, b2, b3;
   Font f1;
//   MyDialog md = new MyDialog();
//   int roomNo=1;

   public WaitRoom() {
      back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Game.png");
      f1 = new Font("����", Font.BOLD, 25);
      
      setLayout(null);
      
      // �ƹ�Ÿ �̹���
//      myInfo.setBounds(615,420,385,190);
//      myInfo.setBackground(new Color(255,0,0,0)); // �г� ��� �����ϰ�
//      myAvatar.add(new JLabel(
//				new ImageIcon(GameRoom.getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\default.png"), 190,150))));
//      add(myInfo);
      
      // �� ����Ʈ
      String[] col1 = { "���̸�", "��������", "�ο�" };
      String[][] row1 = new String[0][3];
      model1 = new DefaultTableModel(row1, col1) {
         @Override
         public boolean isCellEditable(int row, int column) {
            // TODO Auto-generated method stub
            return false; // ���� �Ұ���
         }
      };
      table1 = new JTable(model1);
      table1.setRowHeight(38);
      JScrollPane js1 = new JScrollPane(table1);
      table1.getTableHeader().setReorderingAllowed(false); // ���̺���� ����
      table1.getTableHeader().setBackground(new Color(254,250,67));
      table1.getTableHeader().setFont(new Font("����",Font.BOLD, 17));
      js1.getViewport().setBackground(Color.white);
      js1.setBounds(10, 15, 600, 400);
      
      
      // ������ ����
      String[] col2 = { "ID","�̸�","����","��ġ" };
      String[][] row2 = new String[0][4];
      model2 = new DefaultTableModel(row2, col2) {
         @Override
         public boolean isCellEditable(int row, int column) {
            // TODO Auto-generated method stub
            return false; // ���� �Ұ���
         }
      };
      table2 = new JTable(model2);
      table2.setRowHeight(38);
      JScrollPane js2 = new JScrollPane(table2);
      table2.getTableHeader().setReorderingAllowed(false); // ���̺���� ����
      table2.getTableHeader().setBackground(new Color(254,250,67));
      table2.getTableHeader().setFont(new Font("����",Font.BOLD, 17));
      js2.getViewport().setBackground(Color.white);
      js2.setBounds(615, 15, 385, 400);
      
      
      // ä��â
      tp = new JTextArea();
      tf = new JTextField();
      tp.setEditable(false);
      JScrollPane js3 = new JScrollPane(tp);
      js3.setBounds(10, 420, 600, 260);
      tf.setBounds(10, 690, 600, 30);
      
      
      // ��ư
      b1 = new JButton("�游���");
      b2 = new JButton("�����");
      b3 = new JButton("������");
      b1.setFont(f1);
      b1.setForeground(Color.white);
      b1.setSize(50, 50);
      b2.setFont(f1);
      b2.setForeground(Color.white);
      b2.setSize(50, 50);
      b3.setFont(f1);
      b3.setForeground(Color.white);
      b3.setSize(50, 50);
      // ��ư ��� �����
      b1.setContentAreaFilled(false);
      b2.setContentAreaFilled(false);
      b3.setContentAreaFilled(false);
      b1.setFocusPainted(false);
      b2.setFocusPainted(false);
      b3.setFocusPainted(false);
      
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(3, 1, 5, 5));
      p.setOpaque(false);
      p.add(b1);
      p.add(b2);
      p.add(b3);
      p.setBounds(615, 620, 385, 100);
      
      
      add(tf);
      add(p);
      add(js3);
      add(js1);
      add(js2);

      // �̺�Ʈ���
//      tf.addActionListener(this);
//      table1.addMouseListener(this);
//      table2.addMouseListener(this);
//      b1.addActionListener(this);
//      md.btnOK.addActionListener(this);
//      md.btnCancel.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      
      // ä��â Enter
//      if (e.getSource() == tf) { // ���͸� ģ textfield�� ����
//         tp.append(tf.getText() + "\n");
//         tf.setText("");
//         tf.requestFocus();
//      }
//      // �游��� => ���̾�α�â
//      if(e.getSource()==b1) {
//         md.setLocation(this.getWidth()/2-md.getWidth()/2, this.getHeight()/2-md.getHeight()/2);
//         md.setVisible(true);
//      }
//      // ���̾�α�â => ���̸�,�ο� ���� �� �游��� ��ư
//      else if(e.getSource()==md.btnOK) {
//         String roomName=md.tf.getText();
//         if(roomName.length()<1) {
//            JOptionPane.showMessageDialog(this, "�� �̸��� �Է��ϼ���!");
//            md.tf.requestFocus();
//            return;
//         }
//         String roomPeople = "";
//         for(int i=0;i<md.radio.length;i++) {
//            if(md.radio[i].isSelected())
//               roomPeople=md.radio[i].getText().substring(0,1);
//         }
//         String[] data= {String.valueOf(roomNo),roomName,"1/"+roomPeople};
//         roomNo++;
//         model1.addRow(data);
//         
//         md.tf.setText("");
//         md.radio[0].setSelected(true);
//         
//         md.setVisible(false);
//      }
//      else if(e.getSource()==md.btnCancel) {
//         md.tf.setText("");
//         md.radio[0].setSelected(true);
//         md.setVisible(false);
//      }
   }
   public void setImage(int image) {
	   
   }
   

   @Override
   protected void paintComponent(Graphics g) {
      g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
   }
}