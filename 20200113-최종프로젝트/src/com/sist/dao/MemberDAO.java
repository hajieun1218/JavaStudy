package com.sist.dao;
import java.sql.*;
public class MemberDAO {
	// 오라클 연결 => Socket
	private Connection conn;  
	// BufferedReader, OutputStream
	private PreparedStatement ps; 
	// 오라클 연결주소
//	private final String URL="jdbc:oracle:thin:@211.238.142.184:1521:XE"; 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE"; 
	
	// 1. 드라이버 등록 => 한번 수행 => 생성자
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	// 2. 연결
	public void getConnection() {
		try {
			// conn hr/happy
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch(Exception ex) {}
	}
	
	// 3. 연결해제
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch(Exception ex) {}
	}
	
	// 4. 기능 처리
	public String isLogin(String id, String pwd) {
		String result="";
		try {
			// 연결
			getConnection();
			// 오라클에 요청
			String sql="SELECT COUNT(*) FROM member WHERE id=?"; // 0=>id틀림, 1=>id존재
			// 오라클로 전송
			ps=conn.prepareStatement(sql); 
			// ?에 값을 채운다
			ps.setString(1, id);
			// 실행요청
			ResultSet rs=ps.executeQuery();
			rs.next();  // 실제 출력위치에 커서를 이동한다
			int count=rs.getInt(1);  // 오라클=>1부터 시작
			rs.close();
			
			if(count==0) {
				result="NOID";
			}
			else {
				// 요청
				sql="SELECT * FROM member WHERE id=?";
				ps=conn.prepareStatement(sql); // 전송
				ps.setString(1, id); // 실행전에 ?에 값을 채운다
				rs=ps.executeQuery();
				rs.next();
				
				// 값을 받는다
				String mid=rs.getString(1);
				String mpwd=rs.getString(2);
				String name=rs.getString(3);
				String sex=rs.getString(4);
				rs.close();
				
				if(mpwd.equals(pwd)) {
					// 로그인
					result=mid+"|"+name+"|"+sex;
				}
				else {
					// 비밀번호 틀림
					result="NOPWD";
				}
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			// 연결해제
			disConnection();
		}
		return result;
	}
}
