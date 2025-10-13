package model;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {
	//SQL 클래스 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;//select
	
	// 커넥션 메소드
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
	
	// 등록 메소드
	public int studentWrite(StudentDTO dto) {
		//반환타입
		int row=0;
		//query
		String sql="insert into tbl_student_201905(syear,sclass,sno,sname,\r\n"
				+ "birth,gender,tel1,tel2,tel3)\r\n"
				+ "		values(?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSyear());
			pstmt.setString(2, dto.getSclass());
			pstmt.setString(3, dto.getSno());
			pstmt.setString(4, dto.getSname());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getTel1());
			pstmt.setString(8, dto.getTel2());
			pstmt.setString(9, dto.getTel3());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	//전체 검색 메소드
	public List<StudentDTO> studentList(){
		//반환타입
		List<StudentDTO> sList = new ArrayList();
		//query
		String sql="SELECT * FROM tbl_student_201905\r\n"
				+ "		order by syear,sclass,sno";
		
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();//select
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setSyear(rs.getString("syear"));
				dto.setSclass(rs.getString("sclass"));
				dto.setSno(rs.getString("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				
				sList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sList;
	}
}
