package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GameRoom extends JPanel implements ActionListener{
	
	
   JPanel[] pans=new JPanel[6];
   JTextField[] ids=new JTextField[6];
   
   //�����Է�â
   JTextField ans =new JTextField(15);
   JTextArea ansTa = new JTextArea();
   
   // ä��â
   JTextArea ta=new JTextArea();
   JTextField tf=new JTextField();
   JButton b1,b2,b3,b4,b5;
   
   // ����
   int userKey = 4;
   ArrayList<String> userList = new ArrayList<String>();
   {
	   for(int i =0; i<userKey;i++) {
		   userList.add("user"+i);
	   }
   }
   String[] userName = {"���Ȱ�","�źϵ���","�θ���","�������","������"};
   JLabel[] u = new JLabel[userList.size()];
   // ���� ���� ���
   String[] s1 = new String[u.length];
   int[] score = new int[u.length];
   {
		for(int i =0; i<u.length;i++){
			score[i] =100;  // ���⿡ ���� ����? ���� ������ ���� �ڸ�
			s1[i] = String.valueOf(score[i]);
		}
	}	

   
   // GameRoom()
   public GameRoom()
   {
	   for(int i=0;i<6;i++)
	   {
		   pans[i]=new JPanel();
		   pans[i].setBackground(Color.black);
		   ids[i]=new JTextField();
	   }
	   
	   int[] a = {15,180,340}; // x�� ��ġ
	   int[] e = {140,305,470};// y�� ��ġ
	   int j =0; // y�� ��ġ��µ� ����ϴ� ����
	   setLayout(null);
	  
	   // �ƹ�Ÿ �ڸ� ���
	   for(int i=0; i<u.length; i++) {
		   if(i == 3) j=0;
		   if(i<3) {
			   pans[i].setBounds(10, a[j], 150,120 );
			   pans[i].setLayout(new BorderLayout());
			   pans[i].add("Center",new JLabel(new ImageIcon(getImageSizeChange(
					   new ImageIcon("C:\\javaDev\\ProjectImage\\icon"+i+".png"), 150, 120))));
			   ids[i].setBounds(10, e[j], 150, 30);
			   ids[i].setEditable(false);
			   ids[i].setText(userName[i]);
			   
		   }
		 
		   else if(i>=3){
			   pans[i].setBounds(850, a[j],150,120 );
			   pans[i].setLayout(new BorderLayout());
			   pans[i].add("Center",new JLabel(new ImageIcon(getImageSizeChange
				   (new ImageIcon("C:\\javaDev\\ProjectImage\\Icon"+i+".png"), 150, 120))));
			   ids[i].setBounds(850, e[j], 150, 30);
			   ids[i].setEditable(false);
			   ids[i].setText(userName[i]);
		   }
		   j++;
	   }
	  
	   // �гΰ� �������� ��ġ
	   for(int i=0;i<u.length;i++)
	   {
		   add(pans[i]);
		   add(ids[i]);
	   }
	   
	   // ä��â
	   JScrollPane js=new JScrollPane(ta);
	   // ä��â �Էµ��� �ʰ� ����
	   ta.setEditable(false); 
	   js.setBounds(10, 510, 600, 180);
	   add(js);
	   
	   tf.setBounds(10, 695, 600, 30);
	   add(tf);
	   
	   // ���� �Է�â
	   JScrollPane js1 = new JScrollPane(ansTa);
	   ansTa.setEditable(false);
	   js1.setBounds(620,570,200,120);
	   ans.setBounds(620,695,200,30);
	   add(ans);
	   add(js1);
	   
	   // ��ư �Է�
	   b1=new JButton("�ʴ��ϱ�");
	   b2=new JButton("�����ϱ�");
	   b3=new JButton("�����غ�");
	   b4=new JButton("���ӽ���");
	   b5=new JButton("������");
	   
	   
	   // �гΰ� ��ư��
	   JPanel p=new JPanel();
	   p.setLayout(new GridLayout(5,1,5,5));
	   p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);
	   p.setBounds(850, 510, 150, 210);
	   add(p);
   }
   
   public Image getImageSizeChange(ImageIcon icon,int width,int height)
   {
   	Image img=icon.getImage();
   	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
   	return change;
   }

   @Override
	public void actionPerformed(ActionEvent e) {
	   if(e.getSource() == b1) {
		   // ���� ���� Dialogâ
		   b1.setEnabled(false);
	   }
	
	}
}


