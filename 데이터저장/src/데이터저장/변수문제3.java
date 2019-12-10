package 데이터저장;

public class 변수문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "-Travel HEY";
		String title = "잡내없이삶기, 고기만 먹어도 맛있고 김치랑 먹어도 맛있는 수육";
		String subTitle = "\"야들야들하고 잡냄새 없이 삶는 팁\"";
		int num = 4;
		int time = 60;
		String who = "아무나";
		
		/*
		 *   1) " 출력 => \"
		 *   2) 다음줄 출력 => \n => new line
		 *   3) 일정 간격 => \t => tab
		 */
		
		System.out.println(name);
		System.out.println(title);
		System.out.println(subTitle);
		System.out.print(num + "인분\t");
		System.out.print(time + "분 이내\t");
		System.out.println(who);
		
		
	}

}
