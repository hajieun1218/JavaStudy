// StringTokenizer => �������� => ������ �м� 

import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String data = "Java Oracle HTML CSS JavaScript JSP Spring Kotlin";
		StringTokenizer st=new StringTokenizer(data); // �������� �ڸ�
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
