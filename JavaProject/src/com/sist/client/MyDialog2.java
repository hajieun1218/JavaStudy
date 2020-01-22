package com.sist.client;

import java.awt.*;

import java.applet.*;

import java.awt.event.*;
import javax.swing.*;


public class MyDialog2 extends JDialog implements ActionListener {

   Font f1,f2,f3;
   JLabel j1,j2,j3,j4;
   JTextField tf,tf1;
   JButton b1,b2,b3,b4;
   JPanel p1,p2,panelRadio,p3,p4,p5;
   JRadioButton[] radio;
   int ad =0;
//   ainForm ain=new ainForm();

   Image back;
   
   public MyDialog2() {

      back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage000\\6_1.png");

      setLayout(null);
      f1 = new Font("궁서체", Font.BOLD, 17);
      f2= new Font("굴림", Font.BOLD, 17);
      f3= new Font("바탕",Font.BOLD,17);


      j1=new JLabel("아이디:");
      j1.setFont(f1);

      tf = new JTextField(12);
      tf.setFont(f2);


      j2=new JLabel("비밀번호:");
      j2.setFont(f1);

      tf1 = new JTextField(10);
      tf1.setFont(f2);


      j3 = new JLabel("성별:");
      j3.setFont(f1);
      radio = new JRadioButton[2];
      panelRadio = new JPanel();

      String[] radio_name = {"여자","남자"};


      ButtonGroup group = new ButtonGroup();
      for(int i=0; i<radio.length; i++) {
         radio[i] = new JRadioButton(radio_name[i]);
         group.add(radio[i]);
         panelRadio.add(radio[i]);
      }


      j4=new JLabel("캐릭터 선택");
      j4.setFont(f3);

      //view.add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("C:\\javaDev\\ProjectImage\\Quiz\\Person_오정세.jfif"),300,300))));

      p1 = new JPanel();
      p1.add(j1);
      p1.add(tf);
      p1.setBounds(50,50,300,30);

      p2 = new JPanel();
      p2.add(j2);
      p2.add(tf1);
      p2.setBounds(50,86,300,30);

      p3 =new JPanel();
      p3.add(j3);
      p3.add(panelRadio);
      p3.setBounds(50,120,300,30);

      p4 =new JPanel();
      p4.add(j4);
      p4.setBounds(50,170,300,30);

      
      p5 = new JPanel() {
         @Override
         public void paint(Graphics g) {
           
        g.drawImage(back,0,0,300,300,this);
           
         }
      };
      p5.setBackground(Color.black);
      p5.setBounds(80,200,400,300);
      p5.setOpaque(false);
      p5.setLayout(new BorderLayout());
      p5.add("Center",new JLabel(new ImageIcon(getImageSizeChange
           (new ImageIcon("C:\\javaDev\\ProjectImage\\Icon"+ad+".png"), 150, 120))));


      //버튼
      b1 = new JButton("회원가입");
      b1.setFont(f2);
      b1.setBounds(85, 600,113, 40);
      b2 = new JButton("취소");
      b2.setFont(f2);
      b2.setBounds(200,600, 113, 40);
      b3 = new JButton("다음");
      b3.setBounds(100,500,113,40);
      b4 =new JButton("캐릭터 선택하기");
      b4.setBounds(215,500,113,40);


      //디폴트선택
      //      p3 = new JPanel();
      //      p3.add(b1);
      //      p3.add(b2);
      //      p3.setBounds(50,80,350,30);
      radio[0].setSelected(true);


      add(p1);
      add(p2);
      add(p3);
      add(p4);
      add(p5);
      add(b1);
      add(b2);
      add(b3);
      add(b4);
      
      
//      startBtn.addActionListener(this);
//      nextBtn.addActionListener(this);
//      prevBtn.addActionListener(this);
//

      b3.addActionListener(this);
      b4.addActionListener(this);
      
      
      
      setSize(420,700);


   }

   private Image getImageSizeChange(ImageIcon Icon, int width,int height) {
      Image img=Icon.getImage();
      Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return change;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == b3) {
         ad++;
         if(ad>4) {
            ad=0;
         }
         setImage(ad);
         repaint();
         
      }
     
   }

   public void setImage(int ad) {
      if(ad == 0) {
         back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage000\\6_1.png");
      }
      else {
         back = Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage000\\6_"+ad+".png");
      }
   }

   




}