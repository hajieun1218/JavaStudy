/*
 *   조건문 : true/false 일 때 별도로 처리를 따로 한다
 *      형식) 
 *          if (조건문)
 *             실행문장  ==> 조건문 true
 *          else 
 *             실행문장  ==> 조건문 false
 *             
 *          예)
 *             사용자 => 두개의 정수 입력 => 처리(나누기)
 *             
 *             ===> if 사용 ==> error 방지, 원하는 데이터
 *                            ==========
 *                             실제 처리
 */
public class 선택조건문_형식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = 1;
		
		if(b == 0)  // error 방지
			System.out.println("0으로 나눌 수 없습니다");
		else        // 실제 처리
			System.out.println("a/b = " + (a/b));
		
		
	}

}
