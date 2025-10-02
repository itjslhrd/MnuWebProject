package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//드라이버로딩 및 커넥션 객체 생성 메소드
	public Connection getConn() {
		try {
			//드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			//커넥션 연결
			String url="jdbc:mysql://localhost:3306/mnu?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", "webs0100");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//전체 목록 검색 메소드
	public List<DeptDTO> deptList(){
		//반환타입정의
		List<DeptDTO> dList = new ArrayList();
		//query
		String sql="select * from dept";
		
		try {
			//커넥션 연결
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//select
			while(rs.next()) {
				DeptDTO dto = new DeptDTO();
				dto.setDno(rs.getInt("dno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
				dList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dList;
	}
	
	//DB 저장 메소드
	public int deptWrite(DeptDTO dto) {
		//반환타입
		int row=0;
		//쿼리
		String sql="insert into dept(dno,dname,loc)\r\n"
				+ "			values(?, ?, ?)";
		
		try {
			//커넥션
			conn = getConn();
			//명령문
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getDno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
			
			row = pstmt.executeUpdate();//insert, update, delete
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int deptWrite(int dno, String dname, String loc) {
		//반환타입
		int row=0;
		//쿼리
		String sql="";
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
}
