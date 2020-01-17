package com.sist.server;

import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.common.*;
import com.sist.server.Server.Client;

public class Server implements Runnable {
	// ����=>����ó�� => ServerSocket
	// �� Ŭ���̾�Ʈ���� ��Ŵ�� (Thread) => Socket <=> Socket
	// 1. ���� ����
	private ServerSocket ss;
	private final int PORT = 8888;
	// ������ ���� ����
	private Vector<Client> waitVc = new Vector<Client>();
	private Vector<Room> roomVc = new Vector<Room>();

	public Server() {
		try {
			ss = new ServerSocket(PORT);// bind,listen
			System.out.println("Server Start...");
		} catch (Exception ex) {
		}
	}

	// ���ӽ� ó��
	public void run() {
		try {
			while (true) {
				// ������ �ߴٸ� => Ŭ���̾�Ʈ�� �������� => IP,PORT(Socket)
				Socket s = ss.accept();
				// s(Ŭ���̾�Ʈ�� ���� (ip,port) => Thread�� ���� (���ڸ��� ����� �� �� �ִ�)
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

	// ����� ����ϴ� �κ�(��Ŭ���̾�Ʈ���� ���� �۾��� �Ѵ�)
	class Client extends Thread {
		String id, name, sex, pos;
		int avata;
		// pos=> ����ġ
		// ���
		Socket s;// ������
		// ������
		OutputStream out;
		// �ޱ�
		BufferedReader in;

		public Client(Socket s) {
			try {
				this.s = s;
				out = s.getOutputStream(); // Ŭ���̾�Ʈ�� ������ġ => �о �� �ְ� �����.
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// InputStreamReader (���ͽ�Ʈ�� => byte -< 2byte�� ��ȯ
			} catch (Exception ex) {
			}
		}

		// Ŭ���̾�Ʈ�� ���
		public void run() {
			// 100 |hong|ȫ�浿|����\n
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
						pos = "����";

						// ���ݰ��� waitVc�� �����ض�
						messageAll(Function.LOGIN + "|" + id + "|" + name + "|" + sex + "|" + pos); // ������ �ٸ� Ŭ���̾�Ʈ�鿡��
																									// �ڽ��� ������ ������
						waitVc.add(this);
						messageTo(Function.LOGIN_UPDATE + "|" + id); // ���Ƿ� â�� �ٲ�
						// Ŭ���̾�Ʈ���� id�� �޾ƾ��ϱ� ������ id�� �ٿ��� ���� ����
						for (Client user : waitVc) {
							messageTo(
									Function.LOGIN + "|" + user.id + "|" + user.name + "|" + user.sex + "|" + user.pos);
							// ������ ������ �о���ڴ�.
							// Login�� ���� ���̺� ����� ���� ���
						}

						// ������ �� ���� ����
						for (Room room : roomVc) {
							messageTo(Function.WAIT_MAKEROOM + "|" + room.roomName + "|" + room.roomState + "|"
									+ room.current + "/" + room.maxcount);
						}
						break;
					}
					/*
					 * �α��� -> ������ ������ �α��εǾ� �ִ� ������� ������ �Ѹ��� ����� �����͸� ���� ������
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
								// ������ ����
								messageTo(Function.WAIT_EXIT + "|");
								// Vector���� ����
								waitVc.remove(i);
								// �ݱ� (�������)
								in.close();
								out.close();
								break;
							}
						}
						// ��ü�޼��� => ������ ������ ���̺��� ����
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
						
						// �濡 ���� �����
						messageTo(Function.WAIT_INROOM+"|"+room.roomName+"|"
								+id+"|"+sex+"|"+avata);
						
						// ���� ����
						messageAll(Function.WAIT_POSCHANGE+"|"+id+"|"+pos);
						break;
					}
					case Function.WAIT_INROOM: {
						// Function.ROOMIN+"|"+rn+"\n"
						String rn = st.nextToken();
						/*
						 * 1. �� �̸��� �޴´� 2. ���� ã�´�(roomVc) 3. pos, current�� ���� ===================== = �̹�
						 * �濡 �ִ� ��� ó�� => ROOMADD 1. �濡 �����ϴ� ����� ���� ����(id,avata,...) 2. ���� �޼��� ���� = �濡
						 * ���� ��� ó�� 1. �濡 ���� => ROOMIN 2. �濡�ִ� ������� ������ �����ش� = ���� ���� 1. �ο��� ���� =>
						 * �޼��� ����
						 */
						for (Room room : roomVc) {
							if (rn.equals(room.roomName)) { // ��ã��
								pos = room.roomName;
								room.current++;

								for (Client user : room.userVc) {
									user.messageTo(Function.GAME_USERADD + "|" + id + "|" + sex + "|" + avata);
									user.messageTo(Function.GAME_CHAT + "|[�˸� ��]" + id + "���� �����Ͽ����ϴ�");
								}

								// ����ó��
								room.userVc.add(this); // ������ ����
								messageTo(Function.WAIT_INROOM + "|" + room.roomName + "|" + id + "|" + sex + "|" + avata);
								// ���� ���
								for (Client user : room.userVc) {
									if (!id.equals(user.id)) { // ���� ����
										messageTo(Function.GAME_USERADD + "|" + user.id + "|" + user.sex + "|" + user.avata);
									}
								}
								// ���� ����
								// ��ü������ ����
								messageAll(Function.WAIT_UPDATE+"|"+room.roomName+"|"
										+room.current+"|"+room.maxcount+"|"+id+"|"+pos);

//								// �� ������ ���� ����
//								if(room.current==room.maxcount) {
//									for(Client user:room.userVc) {
////										user.messageTo(Function.GAME_START+"|[�˸� ��] ������ �����մϴ�");
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
						
						// �� ã��
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
						// �� ã��
						// Function.ROOMOUT+"|"+myRoom+"\n"
						String rn=st.nextToken();
						for(int i=0;i<roomVc.size();i++) {
							Room room=roomVc.get(i);
							if(rn.equals(room.roomName)) {
								pos="����";
								room.current--;
								
								// �濡 �����ִ� ���
								for(Client user:room.userVc) {
									if(!user.id.equals(id)) {
										user.messageTo(Function.GAME_EXIT_U+"|"+id);
										user.messageTo(Function.GAME_CHAT+"|[�˸� ��] "+name+"���� �����Ͽ����ϴ�");
									}
								}
								// ���� ������ ���
								for(int j=0;j<room.userVc.size();j++) {
									Client user=room.userVc.get(j);
									if(id.equals(user.id)) {
										// userVc���� ����
										room.userVc.remove(j);
										messageTo(Function.GAME_EXIT+"|");
										break;
									}
								}
								// ����
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
		 * �ݺ��� ���� => �޼��� �������� ���� 1. ���������� ���� 2. ������ ��ü������ ����
		 * 
		 */
		public synchronized void messageTo(String msg) {
			// synchronized : ����ȭ ���α׷�
			// �����ͷ��� ������ ����ȭ�� ���ִ� ���� ����
			/*
			 * UDP : ��żӵ� ���� , �ŷڼ� ���� TCP : ��żӵ� ����, �ŷڼ��� ����
			 * 
			 * ��Ŷ�� �� �޾��� �� ó�����ִ� ����
			 */
			try {
				out.write((msg + "\n").getBytes());
				// readLine() => ������ ���� =(\n) -> \n���� ������ ���� = packet
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
