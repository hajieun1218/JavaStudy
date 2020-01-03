import java.awt.*;
import javax.swing.*;
/*
 *    JPanel  => 단독으로 실행할 수 없다
 *               기본 Layout => FlowLayout() => 일자 배열
 *    JFrame  => 기본 Layout => BorderLayout() => 위,아래,좌,우,가운데
 *    JDialog => 기본 Layout => BorderLayout()
 * 
 */
public class Movie {
	
	JPanel p;
	JLabel la;
	JTextField f;
	
	private String poster;
	private String name;
	
	public Movie() {
		
		poster = "c:\\image\\poster.jpeg";
		name = "나이브스 아웃 (2019)";
		la = new JLabel(new ImageIcon(poster));
		f = new JTextField();
		f.setText(name);
		p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add("Center", la);
		p.add("South", f);
		
		
	}
}
