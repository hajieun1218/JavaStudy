package com.sist.server;

import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.common.*;
import com.sist.server.Server.Client;

public class Server implements Runnable {
	// 연결=>접속처리 => ServerSocket
	// 각 클라이언트마다 통신담당 (Thread) => Socket <=> Socket
	// 1. 서버 가동
	private ServerSocket ss;
	private final int PORT = 8888;
	// 접속자 저장 공간
	private Vector<Client> waitVc = new Vector<Client>();
	private Vector<Room> roomVc = new Vector<Room>();

	public Server() {
		try {
			ss = new ServerSocket(PORT);// bind,listen
			System.out.println("Server Start...");
		} catch (Exception ex) {
		}
	}

	// 접속시 처리
	public void run() {
		try {
			while (true) {
				// 접속을 했다면 => 클라이언트의 정보수집 => IP,PORT(Socket)
				Socket s = ss.accept();
				// s(클라이언트의 정보 (ip,port) => Thread로 전송 (각자마다 통신을 할 수 있다)
				Client client = new Client(s);
				client.start();
			}
		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		new Thread(server).start();

	}

	// 통신을 담당하는 부분(각클라이언트마다 따로 작업을 한다)
	class Client extends Thread {
		String id, name, sex, pos;
		int avata;
		// pos=> 방위치
		// 통신
		Socket s;// 통신장비
		// 보내기
		OutputStream out;
		// 받기
		BufferedReader in;

		public Client(Socket s) {
			try {
				this.s = s;
				out = s.getOutputStream(); // 클라이언트의 저장위치 => 읽어갈 수 있게 만든다.
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// InputStreamReader (필터스트림 => byte -< 2byte로 변환
			} catch (Exception ex) {
			}
		}

		// 클라이언트와 통신
		public void run() {
			// 100 |hong|홍길동|남자\n
			try {
				while (true) {
					String msg = in.readLine();
					System.out.println("Client=>" + msg);
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {

					case Function.LOGIN: {
						id = st.nextToken();
						name = st.nextToken();
						sex = st.nextToken();
						avata = Integer.parseInt(st.nextToken());
						pos = "대기실";

						// 지금값을 waitVc에 저장해라
						messageAll(Function.LOGIN + "|" + id + "|" + name + "|" + sex + "|" + pos); // 서버와 다른 클라이언트들에게
																									// 자신의 정보를 전달함
						waitVc.add(this);
						messageTo(Function.LOGIN_UPDATE + "|" + id); // 대기실로 창을 바꿈
						// 클라이언트에서 id를 받아야하기 때문에 id를 붙여서 같이 보냄
						for (Client user : waitVc) {
							messageTo(
									Function.LOGIN + "|" + user.id + "|" + user.name + "|" + user.sex + "|" + user.pos);
							// 상대방의 정보를 읽어오겠다.
							// Login은 대기방 테이블에 저장된 값을 출력
						}

						// 개설된 방 정보 전송
						for (Room room : roomVc) {
							messageTo(Function.WAIT_MAKEROOM + "|" + room.roomName + "|" + room.roomState + "|"
									+ room.current + "/" + room.maxcount);
						}
						break;
					}
					/*
					 * 로그인 -> 서버와 기존에 로그인되어 있는 사람에게 정보를 뿌리고 저장된 데이터를 내가 가져옴
					 */
					case Function.WAIT_CHAT: {
						messageAll(Function.WAIT_CHAT + "|[" + name + "]" + st.nextToken());
						break;
					}

					case Function.WAIT_EXIT_U: {
						String mid = id;
						for (int i = 0; i < waitVc.size(); i++) {
							Client user = waitVc.get(i);
							if (mid.equals(user.id)) {
								// 윈도우 종료
								messageTo(Function.WAIT_EXIT + "|");
								// Vector에서 제거
								waitVc.remove(i);
								// 닫기 (통신종료)
								in.close();
								out.close();
								break;
							}
						}
						// 전체메세지 => 나가는 유저를 테이블에서 삭제
						messageAll(Function.WAIT_EXIT_U + "|" + mid);
						break;
					}
					case Function.WAIT_MAKEROOM: {
						// Function.MAKEROOM+"|"+rn+"|"+rs+"|"+rp+"|"+inwon+"\n"
						Room room = new Room(st.nextToken(), st.nextToken(), st.nextToken(),
								Integer.parseInt(st.nextToken()));
						room.userVc.add(this);
						roomVc.add(room);
						pos = room.roomName;

						messageAll(Function.WAIT_MAKEROOM + "|" + room.roomName + "|" + room.roomState + "|"
								+ room.current + "/" + room.maxcount);
						
						// 방에 들어가게 만든다
						messageTo(Function.WAIT_INROOM+"|"+room.roomName+"|"
								+id+"|"+sex+"|"+avata);
						
						// 대기실 갱신
						messageAll(Function.WAIT_POSCHANGE+"|"+id+"|"+pos);
						break;
					}
					case Function.WAIT_INROOM: {
						// Function.ROOMIN+"|"+rn+"\n"
						String rn = st.nextToken();
						/*
						 * 1. 방 이름을 받는다 2. 방을 찾는다(roomVc) 3. pos, current를 변경 ===================== = 이미
						 * 방에 있는 사람 처리 => ROOMADD 1. 방에 입장하는 사람의 정보 전송(id,avata,...) 2. 입장 메세지 전송 = 방에
						 * 들어가는 사람 처리 1. 방에 들어가라 => ROOMIN 2. 방에있는 사람들의 정보를 보내준다 = 대기실 변경 1. 인원수 변경 =>
						 * 메세지 전송
						 */
						for (Room room : roomVc) {
							if (rn.equals(room.roomName)) { // 방찾기
								pos = room.roomName;
								room.current++;

								for (Client user : room.userVc) {
									user.messageTo(Function.GAME_USERADD + "|" + id + "|" + sex + "|" + avata);
									user.messageTo(Function.GAME_CHAT + "|[알림 ☞]" + id + "님이 입장하였습니다");
								}

								// 본인처리
								room.userVc.add(this); // 서버에 저장
								messageTo(Function.WAIT_INROOM + "|" + room.roomName + "|" + id + "|" + sex + "|" + avata);
								// 상대방 출력
								for (Client user : room.userVc) {
									if (!id.equals(user.id)) { // 본인 빼고
										messageTo(Function.GAME_USERADD + "|" + user.id + "|" + user.sex + "|" + user.avata);
									}
								}
								// 대기실 변경
								// 전체적으로 전송
								messageAll(Function.WAIT_UPDATE+"|"+room.roomName+"|"
										+room.current+"|"+room.maxcount+"|"+id+"|"+pos);

//								// 다 들어오면 게임 시작
//								if(room.current==room.maxcount) {
//									for(Client user:room.userVc) {
////										user.messageTo(Function.GAME_START+"|[알림 ☞] 게임을 시작합니다");
//										user.messageTo(Function.GAME_START+"|");
//									}
//								}
								
							}
						}
						break;
					}
					case Function.GAME_CHAT: {
						// Function.ROOMCHAT+"|"+myRoom+"|"+msg+"\n"
						String rn=st.nextToken();
						String strMsg=st.nextToken();
						
						// 방 찾기
						for(Room room:roomVc) {
							if(rn.equals(room.roomName)) {
								for(Client user:room.userVc) {
									user.messageTo(Function.GAME_CHAT+"|["+name+"] "+strMsg);
								}
							}
						}
						break;
					}
					case Function.GAME_EXIT_U: {
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
										user.messageTo(Function.GAME_EXIT_U+"|"+id);
										user.messageTo(Function.GAME_CHAT+"|[알림 ☞] "+name+"님이 퇴장하였습니다");
									}
								}
								// 실제 나가는 사람
								for(int j=0;j<room.userVc.size();j++) {
									Client user=room.userVc.get(j);
									if(id.equals(user.id)) {
										// userVc에서 제거
										room.userVc.remove(j);
										messageTo(Function.GAME_EXIT+"|");
										break;
									}
								}
								// 대기실
								messageAll(Function.WAIT_UPDATE+"|"+room.roomName+"|"
										+room.current+"|"+room.maxcount+"|"+id+"|"+pos);
								if(room.current==0) {
									roomVc.remove(i);
									break;
								}
							}
						}
						
						break;
					}
					}
				}

			} catch (Exception ex) {
			}
		}

		/*
		 * 
		 * 반복을 제거 => 메서드 서버에서 전송 1. 개인적으로 전송 2. 접속자 전체적으로 전송
		 * 
		 */
		public synchronized void messageTo(String msg) {
			// synchronized : 동기화 프로그램
			// 데이터량이 많으면 동기화를 해주는 것이 좋음
			/*
			 * UDP : 통신속도 높음 , 신뢰성 낮음 TCP : 통신속도 낮음, 신뢰성이 높음
			 * 
			 * 패킷을 못 받았을 때 처리해주는 내용
			 */
			try {
				out.write((msg + "\n").getBytes());
				// readLine() => 끝나는 시점 =(\n) -> \n으로 끝나는 단위 = packet
			} catch (Exception ex) {
			}

		}

		public synchronized void messageAll(String msg) {

			try {

				for (Client user : waitVc) {
					user.messageTo(msg);
				}

			} catch (Exception ex) {
			}
		}

	}

}
