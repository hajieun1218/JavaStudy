package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.common.*;
public class Server implements Runnable {

	// 연결 => 접속처리 => ServerSocket
	// 각 클라이언트마다 통신담당(Thread) => Socket <=> Socket
	
	// 1. 서버 가동
	private ServerSocket ss;
	private final int PORT=8888;
	
	// 접속자 저장공간
	private Vector<Client> waitVc=new Vector<Client>();
	private Vector<Room> roomVc=new Vector<Room>();
	
	public Server() {
		try {
			ss=new ServerSocket(PORT); // bind,listen
			System.out.println("Server Start...");
		} catch(Exception ex) {}
	}
	
	// 접속시 처리
	@Override
	public void run() {
		try {
			while(true) {
				// 접속을 했다면 => 클라이언트의 정보 수집 => IP,PORT(Socket)
				Socket s=ss.accept();
				// s(클라이언트의 정보(ip,port)) => Thread로 전송(각자마다 통신할 수 있다)
				
				Client client=new Client(s);
				client.start();
			}
		} catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server=new Server();
		new Thread(server).start();
	}

	// 통신을 담당하는 부분(각 클라이언트마다 따로 작업을 한다)
	class Client extends Thread {
		String id,name,sex,pos;
		int avata;
		// pos => 방위치
		
		// 통신
		Socket s; // 통신장비
		// 보내기(1byte로)
		OutputStream out;
		// 받기(2byte로)
		BufferedReader in;
		
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream(); // 클라이언트의 저장위치 => 읽어갈 수 있게 만든다
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// InputStreamReader(필터스트림) => byte를 2byte로 변환
				
			} catch(Exception ex) {}
		}
		
		// 클라이언트와 통신
		public void run() {
			// 100|hong|홍길동|남자\n
			try {
				while(true) {
					String msg=in.readLine();  // 클라이언트가 전송한값(요청)
					System.out.println("Client=>"+msg);
					StringTokenizer st=new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					
					switch(protocol) {
					case Function.LOGIN: 
					{
						id=st.nextToken();
						name=st.nextToken();
						sex=st.nextToken();
						avata=Integer.parseInt(st.nextToken());
						pos="대기실";
						
						messageAll(Function.LOGIN+"|"
								+id+"|"+name+"|"+sex+"|"+pos);
						
						waitVc.add(this);
						messageTo(Function.MYLOG+"|"+id);
						
						for(Client user:waitVc) {
							messageTo(Function.LOGIN+"|"
									+user.id+"|"+user.name+"|"
									+user.sex+"|"+user.pos);
						}
						
						// 개설된 방 정보 전송
						for(Room room:roomVc) {
							messageTo(Function.MAKEROOM+"|"+room.roomName+"|"
									+room.roomState+"|"
									+room.current+"/"+room.maxcount);
						}
						
						break;
					}
					case Function.WAITCHAT:
					{
						messageAll(Function.WAITCHAT+"|["+name+"] "+st.nextToken());
						break;
					}
					case Function.EXIT: {
						String mid=id;
						for(int i=0;i<waitVc.size();i++) {
							Client user=waitVc.get(i);
							if(mid.equals(user.id)) {
								// 윈도우 종료
								messageTo(Function.MYEXIT+"|");
								// Vector에서 제거
								waitVc.remove(i);
								// 닫기 (통신종료)
								in.close();
								out.close();
								break;
							}
						}
						// 전체메세지 => 나가는 유저를 테이블에서 삭제
						messageAll(Function.EXIT+"|"+mid);
						break;
					}
					case Function.MAKEROOM: {
						// Function.MAKEROOM+"|"+rn+"|"+rs+"|"+rp+"|"+inwon+"\n"
						Room room=new Room(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
						room.userVc.add(this);
						roomVc.add(room);
						pos=room.roomName;
						
						messageAll(Function.MAKEROOM+"|"+room.roomName+"|"
								+room.roomState+"|"
								+room.current+"/"+room.maxcount);
						
						// 방에 들어가게 만든다
						messageTo(Function.ROOMIN+"|"+room.roomName+"|"
								+id+"|"+sex+"|"+avata);
						
						// 대기실 갱신
						messageAll(Function.POSCHANGE+"|"+id+"|"+pos);
						break;
					}
					case Function.ROOMIN: {
						//Function.ROOMIN+"|"+rn+"\n"
						String rn=st.nextToken();
						/*
						 *  1. 방 이름을 받는다
						 *  2. 방을 찾는다(roomVc)
						 *  3. pos, current를 변경
						 *  =====================
						 *   = 이미 방에 있는 사람 처리 => ROOMADD
						 *      1. 방에  입장하는 사람의 정보 전송(id,avata,...)
						 *      2. 입장 메세지 전송
						 *   = 방에 들어가는 사람 처리
						 *      1. 방에 들어가라 => ROOMIN
						 *      2. 방에있는 사람들의 정보를 보내준다
						 *   = 대기실 변경
						 *      1. 인원수 변경 => 메세지 전송
						 */
						for(Room room:roomVc) {
							if(rn.equals(room.roomName)) { // 방찾기
								pos=room.roomName;
								room.current++;
								
								for(Client user:room.userVc) {
									user.messageTo(Function.ROOMADD+"|"
											+id+"|"+sex+"|"+avata);
									user.messageTo(Function.ROOMCHAT+"|[알림 ☞] "+id+"님이 입장하였습니다");
								}
								
								// 본인처리
								room.userVc.add(this); // 서버에 저장
								messageTo(Function.ROOMIN+"|"+room.roomName+"|"
										+id+"|"+sex+"|"+avata);
								// 상대방 출력
								for(Client user:room.userVc) {
									if(!id.equals(user.id)) { // 본인 빼고
										messageTo(Function.ROOMADD+"|"
												+user.id+"|"+user.sex+"|"+user.avata);
									}
								}
								// 대기실 변경
								// 전체적으로 전송
								messageAll(Function.WAITUPDATE+"|"+room.roomName+"|"
										+room.current+"|"+room.maxcount+"|"+id+"|"+pos);
							}
						}
						/*
						 *   대기실 => messageAll
						 *   방,개인 => messageTo
						 *   
						 *   ==> 행위자 처리
						 *   ==> 남아있는 사람들 처리
						 *   ==> 대기실 처리
						 */
						break;
					}
					case Function.ROOMCHAT: {
						// Function.ROOMCHAT+"|"+myRoom+"|"+msg+"\n"
						String rn=st.nextToken();
						String strMsg=st.nextToken();
						
						// 방 찾기
						for(Room room:roomVc) {
							if(rn.equals(room.roomName)) {
								for(Client user:room.userVc) {
									user.messageTo(Function.ROOMCHAT+"|["+name+"] "+strMsg);
								}
							}
						}
						break;
					}
					case Function.ROOMOUT: {
						// 방 찾기
						// Function.ROOMOUT+"|"+myRoom+"\n"
						String rn=st.nextToken();
						for(int i=0;i<roomVc.size();i++) {
							Room room=roomVc.get(i);
							if(rn.equals(room.roomName)) {
								pos="대기실";
								room.current--;
								
								// 방에 남아있는 사람
								for(Client user:room.userVc) {
									if(!user.id.equals(id)) {
										user.messageTo(Function.ROOMOUT+"|"+id);
										user.messageTo(Function.ROOMCHAT+"|[알림 ☞] "+name+"님이 퇴장하였습니다");
									}
								}
								// 실제 나가는 사람
								for(int j=0;j<room.userVc.size();j++) {
									Client user=room.userVc.get(j);
									if(id.equals(user.id)) {
										// userVc에서 제거
										room.userVc.remove(j);
										messageTo(Function.MYROOMOUT+"|");
										break;
									}
								}
								// 대기실
								messageAll(Function.WAITUPDATE+"|"+room.roomName+"|"
										+room.current+"|"+room.maxcount+"|"+id+"|"+pos);
								if(room.current==0) {
									roomVc.remove(i);
									break;
								}
							}
						}
						
						break;
					}
					case Function.KANG: {
						// Function.KANG+"|"+myRoom+"|"+youId+"\n"
						String rn=st.nextToken();
						String yid=st.nextToken();
						for(Client user:waitVc) {
							if(yid.equals(user.id)) {
								user.messageTo(Function.KANG+"|"+rn);
								break;
							}
						}
						
						break;
					}
					}
				}
			} catch (Exception ex) {}
		}
		
		
		// 반복을 제거 => 메소드
		// 서버에서 전송 => 개인적으로 전송, 접속자 전체에게 전송
		
		// synchronized : 동기화 프로그램
		// 개인적으로 전송
		public synchronized void messageTo(String msg) {
			try {
				out.write((msg+"\n").getBytes());
				// readLine() => 끝나는 시점 => \n
			} catch(Exception ex) {}
		}
		
		// 전체적으로 전송
		public synchronized void messageAll(String msg) {
			try {
				for(Client user:waitVc) {
					user.messageTo(msg);
				}
			} catch(Exception ex) {}
		}
		
	}
}
