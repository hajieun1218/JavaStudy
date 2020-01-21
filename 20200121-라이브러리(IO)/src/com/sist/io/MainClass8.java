package com.sist.io;
import java.io.*;
import java.util.*;
public class MainClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("c:\\oracle\\member.txt"));
			ArrayList<Member> list=(ArrayList<Member>)ois.readObject();
			ois.close();
			for(Member m:list) {
				System.out.println(m.getId()+" "+m.getName()+" "+m.getSex());
			}
		} catch (Exception ex) {}
	}

}
