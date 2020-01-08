package com.sist.exception1;

import java.sql.*;  // 오라클 연결 => CheckException(예외처리 필수)

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;  // 오라클 연결(Socket)
		PreparedStatement ps = null; // SQL문장 전송 => 수신
		
		try {
			// 1. 오라클 드라이버 설정 (자바와 오라클을 연결해줌) : thin(사용), oci
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 연결
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			conn=DriverManager.getConnection(url,"hr","happy"); // XML로 감추기
			
			// 3. SQL문장
			String sql="SELECT ename,job,sal FROM emp"; // ; 찍으면 에러
			ps=conn.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {  // 처음부터 한줄씩 읽기
				System.out.println(rs.getString(1)+" "
						          +rs.getString(2)+" "
						          +rs.getInt(3));
			}
			rs.close();
			
		} catch(Exception ex) {
//			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch(Exception ex) {
				
			}
		}
	}

}
