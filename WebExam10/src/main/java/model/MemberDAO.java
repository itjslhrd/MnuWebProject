package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//드라이버로딩 및 커넥션 객체 생성 메소드
	private Connection getConn() {
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

	//회원번호 마지막번호 반환
	public int custnoMax() {
		int row=0;
		String sql="select max(custno) from tbl_member_002";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	//회원번호를 이용한 검색
	public MemberDTO custnoSearch(int custno) {
		MemberDTO dto = new MemberDTO();
		String sql="select * from tbl_member_002 where custno=?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setCustno(rs.getInt("custno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setJoindate(rs.getString("joindate"));
				dto.setGrade(rs.getString("grade"));
				dto.setCity(rs.getString("city"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
