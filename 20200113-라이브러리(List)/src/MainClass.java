import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 List<String> list=new ArrayList<String>();
		 
		 // 저장 add()
		 list.add("홍길동");
		 list.add("심청이");
		 list.add("박문수");
		 
		 // 중간에 저장
		 list.add(1,"춘향이");
		 
		 // 출력
		 for(String name:list) {
			 System.out.println(name);
		 }
		 
		 System.out.println("===========");
		 // 수정
		 list.set(2,"이순신");
		 
		 // 출력
		 int i=0;
		 for (String name:list) {
			 System.out.println(name+":"+i);
			 i++;
		 }
		 
		 System.out.println("===========");
		 // 삭제
		 list.remove(1);
		 
		 // 출력
		 i=0;
		 for (String name:list) {
			 System.out.println(name+":"+i);
			 i++;
		 }
		 
		 // 데이터 저장된개수
		 System.out.println("저장된 개수 "+list.size());
		
		

	}

}
