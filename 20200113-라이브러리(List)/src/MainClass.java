import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 List<String> list=new ArrayList<String>();
		 
		 // ���� add()
		 list.add("ȫ�浿");
		 list.add("��û��");
		 list.add("�ڹ���");
		 
		 // �߰��� ����
		 list.add(1,"������");
		 
		 // ���
		 for(String name:list) {
			 System.out.println(name);
		 }
		 
		 System.out.println("===========");
		 // ����
		 list.set(2,"�̼���");
		 
		 // ���
		 int i=0;
		 for (String name:list) {
			 System.out.println(name+":"+i);
			 i++;
		 }
		 
		 System.out.println("===========");
		 // ����
		 list.remove(1);
		 
		 // ���
		 i=0;
		 for (String name:list) {
			 System.out.println(name+":"+i);
			 i++;
		 }
		 
		 // ������ ����Ȱ���
		 System.out.println("����� ���� "+list.size());
		
		

	}

}
