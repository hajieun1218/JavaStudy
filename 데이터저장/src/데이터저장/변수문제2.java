package 데이터저장;

/*
 *   이름, 성별, 나이, 주소, 전화, 이메일 => 존재(true)/비존재(false)
 */

public class 변수문제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "하지은";
		char gender = '여';
		int age = 24;
		String address = "서울시 마포구";
		String number = "010-1111-1111";
		boolean email = true;
		
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("전화 : " + number);
		System.out.println("이메일 존재 여부 : " + email);
		
		
	}

}
