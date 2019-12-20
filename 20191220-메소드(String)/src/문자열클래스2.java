// equals => return(boolean)
// 저장된 문자열이 같은지 확인 

import java.util.Scanner;

public class 문자열클래스2 {

	static boolean isLogin(String id, String pwd) {
		
		boolean bCheck = false;
		final String ID = "admin";
		final String PWD = "1234";
		
		/*
		 *   equals : 대소문자 구분 비교
		 *   equalsIgnoreCase : 대소문자 구분 없이 비교
		 *   
		 *   startsWith : 시작 문자열이 같은 경우(true)
		 *   endsWith   : 끝나는 문자열이 같은 경우(true)
		 *   contains   : 문장에 문자열이 포함된 경우(true)
		 */
		
//		if(id.equals(ID) && pwd.equals(PWD)) {
		if(id.equalsIgnoreCase(ID) && pwd.equals(PWD)) {
			bCheck = true;
		}

		return bCheck;
	}
	
	static void process() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("ID 입력 : ");
			String id = scan.next();
			System.out.print("비밀번호 입력 : ");
			String pwd = scan.next();
			
			boolean bCheck = isLogin(id, pwd);
			if(bCheck) {
				System.out.println(id.toLowerCase() + "님 로그인 되었습니다!!");
				break;
			}
			else {
				System.out.println("ID나 비밀번호가 틀립니다!!\n다시 입력하세요");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process();
	}

}
