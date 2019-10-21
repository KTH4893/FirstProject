package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTemplate {

	public JDBCTemplate() {
	}
	//Connection 媛앹껜 �깮�꽦 硫붿냼�뱶
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.26:1521:xe","dangsanproject","1234");



			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.26:1521:xe","dangsanproject","1234");

//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dangsan","1234");

			//자동으로 commit을 지원해주는 기능을 해제

			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//而ㅻ꽖�뀡�냼硫�
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//而ㅻ컠�슜硫붿냼�뱶
	public static void commit(Connection conn) {
		try {
			if(conn !=null & !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//濡ㅻ갚
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//stmt, pstmt, rset
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//PreparedStatement�뒗 Statement瑜� �긽�냽�븳 �옄�떇�씠�뿬�꽌 �쐞�뿉 硫붿냼�뱶瑜� �떎�삎�꽦�쓣 �씠�슜�빐�꽌 �궗�슜�븷 �닔 �엳�떎.!
//	public void close(PreparedStatement pstmt) {
//			try {
//				if(pstmt != null && !pstmt.isClosed()) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
