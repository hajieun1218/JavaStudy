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

		// �޸� ����
		StudentVO vo = new StudentVO();
		vo.name = "ȫ�浿";
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
		
		
		System.out.println("==== ��� ��� ====");
		System.out.println(vo.name + " "
				+ vo.kor + " "
				+ vo.eng + " "
				+ vo.math + " "
				+ vo.total + " "
				+ vo.avg + " "
				+ vo.hakjum);
		
	}

}
