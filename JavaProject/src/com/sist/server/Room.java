package com.sist.server;
import java.util.*;

// 방안에 들어간 사람만 처리
public class Room {
	
	String roomName,roomState,roomPwd;
	int current,maxcount;

	// 다른클래스의 이너클래스는 앞에 소속을 써줘야함 Server.Client
	Vector<Server.Client> userVc=new Vector<Server.Client>();

	// 생성자 호출되면 방이 만들어짐 => 호출하는사람이 방장
	public Room(String roomName, String roomState, String roomPwd, int maxcount) {
		this.roomName = roomName;
		this.roomState = roomState;
		this.roomPwd = roomPwd;
		this.maxcount = maxcount;
		current=1;
		
	}
	
	
}
