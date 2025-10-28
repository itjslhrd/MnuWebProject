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
			
			//실행(insert, update, delete)
			row = pstmt.executeUpdate();//DB에 저장
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//학생전체 목록 출력 메소드
	public List<StudentDTO> studentList(){
		//반환값
		List<StudentDTO> list = new ArrayList();	
		//쿼리
		String sql="select * from tbl_student_001";
		
		try {
			//커넥션
			conn = DBManager.getConn();
			//명령문
			pstmt = conn.prepareStatement(sql);
			
			//결과 set (select)
			rs = pstmt.executeQuery();
			
			//list에 추가
			while(rs.next()) {//존재하면
				StudentDTO dto = new StudentDTO();
				dto.setHakbun(rs.getString("hakbun"));
				dto.setName(rs.getString("name"));
				dto.setPhone1(rs.getString("phone1"));
				dto.setPhone2(rs.getString("phone2"));
				dto.setPhone3(rs.getString("phone3"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 등록 메소드 정의(등록, 수정, 삭제)
	public int scoreWrite(ScoreDTO dto) {
		//반환값
		int row=0;
		//쿼리문장
		String sql="insert into tbl_score_001(hakbun,kor,eng,mat) "
				+ " values(?,?,?,?)";
		
		//String sql="insert into tbl_student_001 values(?,?,?,?,?,?,?,?)";
		
		try {
			//커넥션 연결
			conn = DBManager.getConn();
			//명령문 수행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getHakbun());//각 ? 에 값을 대입
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			
			//실행(insert, update, delete)
			row = pstmt.executeUpdate();//DB에 저장
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	//학생 성적 전체 목록 출력 메소드
	public List<ScoreDTO> scoreList(){
		//반환값
		List<ScoreDTO> list = new ArrayList();	
		//쿼리
		String sql="select *, kor+eng+mat tot, round((kor+eng+mat)/3,2) ave \r\n"
				+ "		from tbl_score_001 order by tot desc";
		
		try {
			//커넥션
			conn = DBManager.getConn();
			//명령문
			pstmt = conn.prepareStatement(sql);
			
			//결과 set (select)
			rs = pstmt.executeQuery();
			
			//list에 추가
			while(rs.next()) {//존재하면
				ScoreDTO dto = new ScoreDTO();
				dto.setHakbun(rs.getString("hakbun"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getDouble("ave"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//학번을 이용한 학생 성적 조회
	public ScoreDTO studentScoreList(String hakbun){
		//반환값
		ScoreDTO dto = new ScoreDTO();	
		//쿼리
		String sql="select *, kor+eng+mat tot, round((kor+eng+mat)/3,2) ave \r\n"
				+ "		from tbl_score_001 where hakbun=?";
		
		try {
			//커넥션
			conn = DBManager.getConn();
			//명령문
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			
			//결과 set (select)
			rs = pstmt.executeQuery();
			
			//list에 추가
			if(rs.next()) {//존재하면
				dto.setHakbun(rs.getString("hakbun"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getDouble("ave"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	
}
