package com.sist.movie;
// 오라클 연결
import java.util.*;
import java.sql.*;
/*
 *    1) 드라이버 등록 => Class.forName("oracle.jdbc.driver.OracleDriver"); ==> 오라클에서 다운로드 (ojdbc6.jar)
 *    2) 오라클 연결    => Connection
 *    				=> getConnection(URL,username,password)
 *    				=> conn hr/happy
 *    3) 기능처리 => SQL
 *    		   => SQL문장을 오라클에 전송  Statement
 *    				ResultSet executeQuery()  => 검색(SELECT)
 *    				executeUpdate() => 데이터 변경(INSERT,UPDATE,DELETE) => commit()
 *    4) 오라클 해제 => close()
 */
public class MovieDAO {

	private Connection conn; // Socket
	private PreparedStatement ps; // OutputStream,BufferedReader
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 드라이버 등록 => 한번만 수행
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 오라클 해제
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 기능처리 => 추가 ==> CURD
	public void movieInsert(MovieVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO movie VALUES("
					+ "(SELECT NVL(MAX(mno)+1,1) FROM movie),?,?,?,?,?,?,?,?,?,5)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setDouble(2, vo.getScore());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getRegdate());
			ps.setString(5, vo.getTime());
			ps.setString(6, vo.getGrade());
			ps.setString(7, vo.getDirector());
			ps.setString(8, vo.getActor());
			ps.setString(9, vo.getStory());
			ps.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
	}
	
	
	
	
	
	
}
