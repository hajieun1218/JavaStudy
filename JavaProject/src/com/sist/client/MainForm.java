package com.sist.client;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener; 

public class MainForm extends JFrame implements ActionListener{
   
   Start st = new Start();
   Login lo = new Login();
   WaitRoom wr = new WaitRoom();
   MyDialog md = new MyDialog();
   GameRoom gr = new GameRoom();
   End en = new End();
   CardLayout card = new CardLayout();
   
   public MainForm() {
      
      setLayout(card);
      add("Start", st);
      add("Login", lo);
      add("Waiting",wr);
      add("GameRoom",gr);
      add("End",en);
      
   
      setSize(1024,768); // 윈도우 크기
      setVisible(true);
      
      // X-> 종료
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // title 설정
      setTitle("신서유기_퀴즈");
      st.b1.addActionListener(this);
      st.b3.addActionListener(this);
      wr.b1.addActionListener(this);
      wr.b2.addActionListener(this);
      wr.b3.addActionListener(this);
      en.b1.addActionListener(this);
      lo.b1.addActionListener(this);
      lo.b2.addActionListener(this);
      gr.b4.addActionListener(this);
      gr.b5.addActionListener(this);
   }
   
   
   public static void main(String[] args) {
      
      try {
         UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
         JFrame.setDefaultLookAndFeelDecorated(true);  
      }
      catch(Exception e) {}
      

      MainForm mf = new MainForm();
      WaitRoom wf = new WaitRoom();
      GameRoom gm = new GameRoom();
      End end = new End(); 
      
   }
   // 버튼 처리 하는 메서드
   public void actionPerformed(ActionEvent e) { // 버튼처리하는 내용
      
      
      // 시작화면 ( start -> 로그인 (아직 구현x)
      if(e.getSource() == st.b1) {//  로그인 버튼을 눌렸다면         
         card.show(getContentPane(),"Login"); // 화면 변경 // 대기실 창으로 이동
      }
      // 시작화면 (나가기 -> 종료)
      else if(e.getSource() == st.b3) {
          System.exit(0);
      }
      // 로그인화면 (login -> 대기방)
      else if(e.getSource() == lo.b1) {   
         card.show(getContentPane(),"Waiting");
      }
      // 로그인화면 (main -> 시작화면)
      else if(e.getSource() == lo.b2) {   
         card.show(getContentPane(),"Start");
      }
      // 대기방(방들어가기 -> 게임방)
      else if(e.getSource() == wr.b2) {
         card.show(getContentPane(),"GameRoom");
         gr.ta.setText("~~님이 방에 입장하였습니다");
      }
      // 대기방(나가기 -> 시작화면)
      else if(e.getSource() == wr.b3) {
         card.show(getContentPane(),"Start");
      }      
      // 게임방( 정상종료 -> end)
      else if(e.getSource()== gr.b5) {
         card.show(getContentPane(), "Waiting");
      }
      else if(e.getSource() == gr.b4) {
         JOptionPane.showMessageDialog(this, "게임을 시작합니다");
         card.show(getContentPane(), "End");
      }
      else if(e.getSource() == en.b1) {
         card.show(getContentPane(), "GameRoom");
      }
   }   
   
   
}