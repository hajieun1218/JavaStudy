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
      
   
      setSize(1024,768); // ������ ũ��
      setVisible(true);
      
      // X-> ����
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // title ����
      setTitle("�ż�����_����");
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
   // ��ư ó�� �ϴ� �޼���
   public void actionPerformed(ActionEvent e) { // ��ưó���ϴ� ����
      
      
      // ����ȭ�� ( start -> �α��� (���� ����x)
      if(e.getSource() == st.b1) {//  �α��� ��ư�� ���ȴٸ�         
         card.show(getContentPane(),"Login"); // ȭ�� ���� // ���� â���� �̵�
      }
      // ����ȭ�� (������ -> ����)
      else if(e.getSource() == st.b3) {
          System.exit(0);
      }
      // �α���ȭ�� (login -> ����)
      else if(e.getSource() == lo.b1) {   
         card.show(getContentPane(),"Waiting");
      }
      // �α���ȭ�� (main -> ����ȭ��)
      else if(e.getSource() == lo.b2) {   
         card.show(getContentPane(),"Start");
      }
      // ����(����� -> ���ӹ�)
      else if(e.getSource() == wr.b2) {
         card.show(getContentPane(),"GameRoom");
         gr.ta.setText("~~���� �濡 �����Ͽ����ϴ�");
      }
      // ����(������ -> ����ȭ��)
      else if(e.getSource() == wr.b3) {
         card.show(getContentPane(),"Start");
      }      
      // ���ӹ�( �������� -> end)
      else if(e.getSource()== gr.b5) {
         card.show(getContentPane(), "Waiting");
      }
      else if(e.getSource() == gr.b4) {
         JOptionPane.showMessageDialog(this, "������ �����մϴ�");
         card.show(getContentPane(), "End");
      }
      else if(e.getSource() == en.b1) {
         card.show(getContentPane(), "GameRoom");
      }
   }   
   
   
}