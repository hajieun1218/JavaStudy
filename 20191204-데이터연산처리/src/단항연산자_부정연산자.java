/* 
 *   단항 : 피연산자(연산대상) 1개일 경우
 *   부정연산자 : ! / boolean 사용
 *            true->false, false->true  => 오라클에서도 사용
 *            
 *            
 */
public class 단항연산자_부정연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean bCheck = false;
		System.out.println("bCheck 변경전 : " + bCheck);
		bCheck = !bCheck;
		System.out.println("bCheck 변경후 : " + bCheck);
		
		
	}

}
