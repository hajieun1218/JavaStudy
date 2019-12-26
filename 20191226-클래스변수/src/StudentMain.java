class StudentVO {
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	char hakjum;
}
public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 메모리 저장
		StudentVO vo = new StudentVO();
		vo.name = "홍길동";
		vo.kor = 90;
		vo.eng = 80;
		vo.math = 70;
		vo.total = vo.kor + vo.eng + vo.math;
		vo.avg = vo.total / 3.0;
		
		vo.hakjum = 'A';
		switch ((int)vo.avg/10) {
		case 10:
		case 9:
			vo.hakjum = 'A';
			break;
		case 8: 
			vo.hakjum = 'B';
			break;
		case 7:
			vo.hakjum = 'C';
			break;
		case 6:
			vo.hakjum = 'D';
			break;
		default:
			vo.hakjum = 'F';
			break;
		}
		
		
		System.out.println("==== 결과 출력 ====");
		System.out.println(vo.name + " "
				+ vo.kor + " "
				+ vo.eng + " "
				+ vo.math + " "
				+ vo.total + " "
				+ vo.avg + " "
				+ vo.hakjum);
		
	}

}
