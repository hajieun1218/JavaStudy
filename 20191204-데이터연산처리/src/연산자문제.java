import java.util.*;

public class �����ڹ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int �⺻�� = 1500000;
		int ���� = 55000;
	    double ���� = �⺻�� * 0.1;
	    double �Ǽ��ɾ� = �⺻�� + ���� - ����;
	    
	    System.out.println("�Ǽ��ɾ� : " + (int)�Ǽ��ɾ� + "��");
		
	    System.out.println("---------------------------");
	    
	    String name = "ȫ�浿";
	    String department = "���ߺ�";
	    String position = "�븮";
	    int sal = 1500000;
	    
	    System.out.println("�̸� : " + name);
	    System.out.printf("�μ� : " + department + "\n");
	    System.out.print("���� : " + position + "\n" + "�޿� : " + sal + "��" + "\n");
	    
	    System.out.println("---------------------------");
	    
	    String inputName;
	    int kor, eng, mat;
	    
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Input name : ");
	    inputName = scan.next();
	    System.out.print("kor : ");
	    kor = scan.nextInt();
	    System.out.print("eng : ");
	    eng = scan.nextInt();
	    System.out.print("mat : ");
	    mat = scan.nextInt();
	    
	    System.out.println("�̸� : " + inputName);
	    System.out.println("�հ����� : " + (kor + eng + mat) + "��");
	    System.out.printf("������� : %.1f", (kor+eng+mat)/3.0);
	    
	    System.out.println("\n---------------------------");
	    
	    int numOfApples = 123;
	    int sizeOfBucket = 10;
//	    int numOfBucket = numOfApples % sizeOfBucket == 0 ? numOfApples / sizeOfBucket : numOfApples / sizeOfBucket + 1;
	    int numOfBucket = (int)Math.ceil(((double)numOfApples / (double)sizeOfBucket));
	    System.out.println("�ʿ��� �ٱ����� �� : " + numOfBucket);
	    
	    
	}

}
