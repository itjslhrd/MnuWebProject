package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//학생등록
	public int studentWrite(StudentDTO dto) {
		int row=0;
		String sql="insert into tbl_student_201905(syear,sclass,sno,sname,"
				+ "birth,gender,tel1,tel2,tel3) values (?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConn();
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
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//학생목록(전체)
	public List<StudentDTO> studentList(){
		List<StudentDTO> list = new ArrayList();
		String sql="select * from tbl_student_201905";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
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
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//학생정보 검색(학년,반,번호)
	public StudentDTO studentSelect(String syear, String sclass, String sno){
		StudentDTO dto = new StudentDTO();
		String sql="select * from tbl_student_201905 where syear=? "
				+ "and sclass=? and sno=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, syear);
			pstmt.setString(2, sclass);
			pstmt.setString(3, sno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setSyear(rs.getString("syear"));
				dto.setSclass(rs.getString("sclass"));
				dto.setSno(rs.getString("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	
	//학생정보 수정처리
	public int studentModify(StudentDTO dto) {
		int row=0;
		String sql="update tbl_student_201905 set birth=?, gender=?,"
				+ "tel1=?, tel2=?, tel3=? where syear=? and sclass=? and sno=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBirth());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getTel1());
			pstmt.setString(4, dto.getTel2());
			pstmt.setString(5, dto.getTel3());
			pstmt.setString(6, dto.getSyear());
			pstmt.setString(7, dto.getSclass());
			pstmt.setString(8, dto.getSno());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	//성적등록
	
	//성적리스트
	
	//성적수정
	
	//반별통계
	
}
