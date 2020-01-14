package com.sist.dao;
import java.sql.*;
public class MemberDAO {
	// ����Ŭ ���� => Socket
	private Connection conn;  
	// BufferedReader, OutputStream
	private PreparedStatement ps; 
	// ����Ŭ �����ּ�
//	private final String URL="jdbc:oracle:thin:@211.238.142.184:1521:XE"; 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE"; 
	
	// 1. ����̹� ��� => �ѹ� ���� => ������
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	// 2. ����
	public void getConnection() {
		try {
			// conn hr/happy
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch(Exception ex) {}
	}
	
	// 3. ��������
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch(Exception ex) {}
	}
	
	// 4. ��� ó��
	public String isLogin(String id, String pwd) {
		String result="";
		try {
			// ����
			getConnection();
			// ����Ŭ�� ��û
			String sql="SELECT COUNT(*) FROM member WHERE id=?"; // 0=>idƲ��, 1=>id����
			// ����Ŭ�� ����
			ps=conn.prepareStatement(sql); 
			// ?�� ���� ä���
			ps.setString(1, id);
			// �����û
			ResultSet rs=ps.executeQuery();
			rs.next();  // ���� �����ġ�� Ŀ���� �̵��Ѵ�
			int count=rs.getInt(1);  // ����Ŭ=>1���� ����
			rs.close();
			
			if(count==0) {
				result="NOID";
			}
			else {
				// ��û
				sql="SELECT * FROM member WHERE id=?";
				ps=conn.prepareStatement(sql); // ����
				ps.setString(1, id); // �������� ?�� ���� ä���
				rs=ps.executeQuery();
				rs.next();
				
				// ���� �޴´�
				String mid=rs.getString(1);
				String mpwd=rs.getString(2);
				String name=rs.getString(3);
				String sex=rs.getString(4);
				rs.close();
				
				if(mpwd.equals(pwd)) {
					// �α���
					result=mid+"|"+name+"|"+sex;
				}
				else {
					// ��й�ȣ Ʋ��
					result="NOPWD";
				}
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			// ��������
			disConnection();
		}
		return result;
	}
}
