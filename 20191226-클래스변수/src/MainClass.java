/* 
 *   Ŭ����(����, ����+�޼ҵ�, �޼ҵ�)
 *     ���� : ~VO(value object), ~DTO
 *     
 *   
 *   �ڹ� Ŭ���� ���� (������� : ���� + �޼ҵ� + ������)
 *   => ������Ʈ ���̽�
 *      ��) ��ǻ�� ����
 *         CPU, �޸�, �ϵ��ũ, ����ī��, ...(������Ʈ) 
 *         
 *   class ClassName {
 *      =========Ŭ������ ������ �ִ� ����=========  ��������(�ٸ� Ŭ�������� ����� ����)
 *       => �޸𸮿� ���� ����Ǵ� ����(instance ����)
 *       => �����ϴ� ����(static ����) => �޸� ������ �Ѱ�
 *      ==================================
 *       ������ �Լ� : ���������� �ʱ�ȭ ==> �ѹ��� ȣ��, ��ü ������ �� ó������ ȣ��
 *       ������, ��Ʈ��ũ, �����ͺ��̽�
 *       Ŭ������� ����, �������� ����
 *       ==> ���࿡ �����ڰ� ���� ��쿡�� JVM�� �ڵ����� ������ش� (default ������)
 *                              ------------------
 *                               import, return, ������
 *      ==================================
 *       �޼ҵ� : ��� ����
 *      ==================================
 *   }
 */


/*
 *      ��λ� (2019)
                 ����6.9/10
                 ���/�׼�
                 �ѱ�
        2019.12.19 ����
        128��, 12���̻������
        (����) ������, �躴��
        (�ֿ�) �̺���, ������, ������, ������, ����
        
        
        class MovieVO
        => ����ڰ� ���� ��������
        => int a
           double d
           ============= ��ǻ�Ͱ� �޸� ũ�� �ν�
           MovieVO vo
           ============= �޸� ũ�⸦ �� �� ����
                         => �޸� ũŰ Ȯ�� => �޸� ����
                           ====================== new 
           
 */
class MovieVO {  // 36byte
	// instance ���� ==> �޸𸮿� ����Ǵ� ���� ==> new(���ο� �޸𸮸� ���� �� => ���� �޸� ����)
	String title;
	double score;
	String genre;
	String regdate;
	int time;
	String grade;
	String director;
	String actor;
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �޸𸮿� ���� => ȣ�� ����
		// . (�޸� �ּ� ���� ������)
		MovieVO m1 = new MovieVO();
		m1.title = "��λ� (2019)";
		
		MovieVO m2 = new MovieVO();
		m2.title = "õ��: �ϴÿ� ���´�";
		
		MovieVO m3 = new MovieVO();
		m3.title = "Ĺ�� (2019)";
		
		MovieVO m4 = m3;
		m4.title = "�õ� (2019)";
		
		System.out.println("m1 : " + m1);
		System.out.println("m2 : " + m2);
		System.out.println("m3 : " + m3);
		System.out.println("m4 : " + m4);
		
		System.out.println("===����� ��ȭ ����===");
		System.out.println(m1.title);
		System.out.println(m2.title);
		System.out.println(m3.title);
		System.out.println(m4.title);
		
		
		MovieVO[] vo = {m1, m2, m3, m4};
		for(int i=0; i<vo.length; i++) {
			System.out.println(vo[i].title);
		}
	}

}
