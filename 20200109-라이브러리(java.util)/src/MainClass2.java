// StringTokenizer => 지능형웹 => 데이터 분석 

import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String data = "Java Oracle HTML CSS JavaScript JSP Spring Kotlin";
		StringTokenizer st=new StringTokenizer(data); // 공백으로 자름
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
