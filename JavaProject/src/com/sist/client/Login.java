package com.sist.client;
import javax.swing.*;
import java.awt.*;

public class Login extends JPanel{
   
   Image back;
   JTextField tf;      //�Է�â ���
   JPasswordField pf;   //��й�ȣ �Է½� *�� ���
   JButton b1,b2;

   public Login() {
      
      
      setLayout(null);   //���ϴ� ��ġ�� ����
      back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\Projectimage\\login.png");
      
      tf=new JTextField();
      pf=new JPasswordField();
      b1=new JButton("LOGIN");
      b2=new JButton("MAIN");
      
      tf.setBounds(50,300,280,30);
      pf.setBounds(50,400,280,30);   
      
//      JPanel p=new JPanel();
//      p.add(b1);
//      p.add(b2);
//      p.setBounds(380,520,200,35);
//      p.setOpaque(false);            //false==����,true==������
      
      b1.setBounds(70,450,100,30);
      b2.setBounds(200,450,100,30);
      b1.setBackground(new Color(254,250,67));
      b2.setBackground(new Color(254,250,67));
      add(tf);
      add(pf);
//      add(p);
      add(b1);
      add(b2);
      
      
   }

   @Override   
   protected void paintComponent(Graphics g) {
      g.drawImage(back, 0, 0, getWidth(), getHeight(), this);  
   }   
   
}