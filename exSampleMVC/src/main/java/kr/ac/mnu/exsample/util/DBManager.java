package kr.ac.mnu.exsample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	public static Connection getConn() {
		Connection conn = null;
		try {
			//mysql 용
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exsample?serverTimezone=UTC", "root", "webs0100");
			
			//oracle 용
			//Class.forName("oracle.jdbc.OracleDriver");	
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.207.103:1521/xe","C##HR", "1234");

		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//메소드 오버로딩
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
