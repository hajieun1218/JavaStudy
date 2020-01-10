package com.sist.client;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GameRoom extends JPanel implements ActionListener{
   
   // 게임화면 창
   JPanel view = new JPanel();

   JPanel[] pans=new JPanel[6];
   JTextField[] ids=new JTextField[6];
   
   //정답입력창
   JTextField ans =new JTextField(15);
   
   // 채팅창
   JTextArea ta=new JTextArea();
   JTextField tf=new JTextField();
   JButton b2,b3,b4,b5;
   
   // 유저   ?? 유저가 1명씩 들어옴 -> 바꿔야함
   int userKey = 4;
   ArrayList<String> userList = new ArrayList<String>();
   {
      for(int i =0; i<userKey;i++) {
         userList.add("user"+i);
      }
   }
   String[] userName = {"저팔계","거북도사","부르마","삼장법사","오공이"};
   JLabel[] u = new JLabel[userList.size()];
   // 유저 점수 출력
   String[] s1 = new String[u.length];
   int[] score = new int[u.length];
   {
      for(int i =0; i<u.length;i++){
         score[i] =100;  // 여기에 점수 변수? 유저 점수가 들어올 자리
         s1[i] = String.valueOf(score[i]);
      } 
   }   

   
   // GameRoom()
   public GameRoom()
   {
      // 게임화면
      view.setBackground(Color.white);
      view.setLayout(new BorderLayout());
      view.setBounds(170,15, 680, 480);
      view.setSize(670,480);
      
      add(view);
      
      
      for(int i=0;i<6;i++)
      {
         pans[i]=new JPanel();
         pans[i].setBackground(Color.black);
         ids[i]=new JTextField();
      }
      
      int[] a = {15,180,340}; // x축 위치
      int[] e = {140,305,470};// y축 위치
      int j =0; // y축 위치잡는데 사용하는 변수
      setLayout(null);
     
      // 아바타 자리 잡기
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
     
      // 패널과 아이콘을 배치
      for(int i=0;i<u.length;i++)
      {
         add(pans[i]);
         add(ids[i]);
      }
      
      // 채팅창
      JScrollPane js=new JScrollPane(ta);
      // 채팅창 입력되지 않게 고정
      ta.setEditable(false); 
      js.setBounds(10, 510, 600, 180);
      add(js);
      
      tf.setBounds(10, 695, 600, 30);
      add(tf);
      
      // 정답 입력창
      ans.setBounds(620,630,200,30);
      ans.setSize(150, 80);
      add(ans);
     
      // 버튼 입력
//      b1=new JButton("초대하기");
      b2=new JButton("입력");
      b3=new JButton("게임준비");
      b4=new JButton("게임시작");
      b5=new JButton("나가기");
      
      
      // 패널과 버튼들
      JPanel p=new JPanel();
      p.setLayout(new GridLayout(5,1,5,5));
//      p.add(b1);p.add(b2);
      p.add(b3);p.add(b4);p.add(b5);
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
     
      
   
   }
}

