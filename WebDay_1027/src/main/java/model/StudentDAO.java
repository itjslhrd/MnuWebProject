package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 등록 메소드 정의(등록, 수정, 삭제)
	public int studentWrite(StudentDTO dto) {
		//반환값
		int row=0;
		//쿼리문장
		String sql="insert into tbl_student_001(hakbun,name,phone1,phone2,phone3, "
				+ "	birth,gender,regdate) "
				+ "		values(?,?,?,?,?,?,?,?)";
		
		//String sql="insert into tbl_student_001 values(?,?,?,?,?,?,?,?)";
		
		try {
			//커넥션 연결
			conn = DBManager.getConn();
			//명령문 수행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getHakbun());//각 ? 에 값을 대입
			pstmt.setString(2, dto.getName());//각 ? 에 값을 대입
			pstmt.setString(3, dto.getPhone1());//각 ? 에 값을 대입
			pstmt.setString(4, dto.getPhone2());//각 ? 에 값을 대입
			pstmt.setString(5, dto.getPhone3());//각 ? 에 값을 대입
			pstmt.setString(6, dto.getBirth());//각 ? 에 값을 대입
			pstmt.setString(7, dto.getGender());//각 ? 에 값을 대입
			pstmt.setString(8, dto.getRegdate());//각 ? 에 값을 대입
			
			//실행
			row = pstmt.executeUpdate();//DB에 저장
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
}
