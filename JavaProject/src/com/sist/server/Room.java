package com.sist.server;
import java.util.*;

// ��ȿ� �� ����� ó��
public class Room {
	
	String roomName,roomState,roomPwd;
	int current,maxcount;

	// �ٸ�Ŭ������ �̳�Ŭ������ �տ� �Ҽ��� ������� Server.Client
	Vector<Server.Client> userVc=new Vector<Server.Client>();

	// ������ ȣ��Ǹ� ���� ������� => ȣ���ϴ»���� ����
	public Room(String roomName, String roomState, String roomPwd, int maxcount) {
		this.roomName = roomName;
		this.roomState = roomState;
		this.roomPwd = roomPwd;
		this.maxcount = maxcount;
		current=1;
		
	}
	
	
}
