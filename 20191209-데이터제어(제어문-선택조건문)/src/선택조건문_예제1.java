
public class 선택조건문_예제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 난수 => 컴퓨터에서 임의의 수를 추출
		int score = (int)(Math.random()*101); // 0~100
		//     0.0~0.99 => 0.99*101 => 100.xx
		System.out.println("score = " + score);
		
		// 90 이상 => A, 80=>B, 70=>C, 60=>D, 60미만=>F
		if(score < 60)
		{
			System.out.println("F학점입니다");
		}
		else
		{
			if(score >= 90 && score <= 100)
				System.out.println("A학점");
			if(score >= 80 && score < 90)
				System.out.println("B학점");
			if(score >= 70 && score < 80)
				System.out.println("C학점");
			if(score >= 60 && score < 70)
				System.out.println("D학점");
		}
		
		
	}

}
