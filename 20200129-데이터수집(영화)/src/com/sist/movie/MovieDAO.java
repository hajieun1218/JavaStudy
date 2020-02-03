package com.sist.movie;
// ����Ŭ ����
import java.util.*;
import java.sql.*;
/*
 *    1) ����̹� ��� => Class.forName("oracle.jdbc.driver.OracleDriver"); ==> ����Ŭ���� �ٿ�ε� (ojdbc6.jar)
 *    2) ����Ŭ ����    => Connection
 *    				=> getConnection(URL,username,password)
 *    				=> conn hr/happy
 *    3) ���ó�� => SQL
 *    		   => SQL������ ����Ŭ�� ����  Statement
 *    				ResultSet executeQuery()  => �˻�(SELECT)
 *    				executeUpdate() => ������ ����(INSERT,UPDATE,DELETE) => commit()
 *    4) ����Ŭ ���� => close()
 */
public class MovieDAO {

	private Connection conn; // Socket
	private PreparedStatement ps; // OutputStream,BufferedReader
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// ����̹� ��� => �ѹ��� ����
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// ����Ŭ ����
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// ����Ŭ ����
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
	
	// ���ó�� => �߰� ==> CURD
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
