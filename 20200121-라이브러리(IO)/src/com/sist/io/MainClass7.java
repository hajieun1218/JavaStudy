package com.sist.io;
// 객체 단위 저장
import java.io.*;
import java.util.*;

class Member implements Serializable{
	private String id;
	private String name;
	private String sex;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}

public class MainClass7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ArrayList<Member> list=new ArrayList<Member>();
			Member m1=new Member();
			m1.setId("hong");
			m1.setName("홍길동");
			m1.setSex("남자");
			list.add(m1);
			
			m1=new Member();
			m1.setId("shim");
			m1.setName("심청이");
			m1.setSex("여자");
			list.add(m1);
			
			m1=new Member();
			m1.setId("lee");
			m1.setName("이순신");
			m1.setSex("남자");
			list.add(m1);
			
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c:\\oracle\\member.txt"));
			oos.writeObject(list);
			oos.close();
			
			System.out.println("ArrayList 저장 완료");
			
		} catch (Exception ex) {}
	}

}
