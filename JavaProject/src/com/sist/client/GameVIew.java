package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class GameVIew extends JPanel{
	Image back;
    public GameVIew()
    {
    	back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\game_wait.png");
    }
    public void setImage(int no, int quizNo)
    {
//    	if(no==0)
//    	{
//    		back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Quiz\\quizTitle0.png");
//    	}
//    	else
//    	{
//    	   back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Quiz\\"+quizNo+"_"+no+".png");
//    
//    	}
//    	if(no==0) {
//    		back=back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\press_start.png");
//    	}
    	if(no==50) {
    		back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\press_start.png");
    	}
    	else if(no==100) { // 초기화 (start화면)
    		back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\game_wait.png");
    	}
    	else {
    		back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\ProjectImage\\Quiz\\"+quizNo+"_"+no+".png");
    	}
    	
    }
    
	@Override
	public void paint(Graphics g) {
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
	}
    
}
