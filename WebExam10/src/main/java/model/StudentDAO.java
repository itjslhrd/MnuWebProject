package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
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
	//이름을 이용한 검색
	public List<StudentDTO> studentNameSearch(String name){
		List<StudentDTO> sList = new ArrayList();
		String sql="select * from tbl_student_001 where name = ?";
		//String sql2="select * from tbl_student_001 where name like ?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			//pstmt.setString(1, "%"+name+"%");
			
			rs = pstmt.executeQuery();
			StudentDTO dto = new StudentDTO();
			while(rs.next()) {
				dto.setHakbun(rs.getString("hakbun"));
				dto.setName(rs.getString("name"));
				dto.setPhone1(rs.getString("phone1"));
				dto.setPhone2(rs.getString("phone2"));
				dto.setPhone3(rs.getString("phone3"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setRegdate(rs.getString("regdate"));
				
				sList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sList;
	}
}
