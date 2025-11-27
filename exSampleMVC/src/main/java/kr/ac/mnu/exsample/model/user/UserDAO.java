package kr.ac.mnu.exsample.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.mnu.exsample.util.DBManager;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	//전체 회원 카운트
	public int userCount() {
		int row = 0;
		String sql="select count(*) from tbl_user";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//전체회원 목록
	public List<UserDTO> userList(){
		List<UserDTO> list = new ArrayList();
		String sql="select * from tbl_user order by first_time desc";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setName(rs.getString("name"));
				dto.setUserid(rs.getString("userid"));
				dto.setTel(rs.getString("tel"));
				dto.setFirst_time(rs.getString("first_time"));
				dto.setLast_time(rs.getString("last_time"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	//id 중복검사 메소드
	public int userIdCheck(String userid) {
		int row=0;
		String sql="select count(*) from tbl_user where userid=?";
		//String sql1="select count(*) as counter from tbl_user where userid=?";
		try{
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
				//row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//회원등록 메소드
	public int userWrite(UserDTO dto) {
		int row=0;
		String sql="insert into tbl_user(name, userid, passwd, tel) "
				+ " values(?,?,?,?)";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getTel());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//회원 로그인 메소드
	public int userLogin(String userid, String passwd) {
		int row=0;
		//id을 이용한 비번 검색
		String sql="select passwd from tbl_user where userid=?";
		try{
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//id가 존재하는 경우
				String dbPass = rs.getString("passwd");
				if(passwd.equals(dbPass)) {
					//id, 비번 일치하는 경우
					sql="update tbl_user set last_time = now() where userid=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.executeUpdate();
					
					row = 1;
				}else {
					//id는 존재하지만 비번오류
					row = 0;
				}
			}else {
				//id가 없음
				row = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
		
	}
	//로그인 성공시 세션에 저장할 정보- 수정시 사용
	public UserDTO userSelect(String userid) {
		UserDTO dto = new UserDTO();
		String sql="select * from tbl_user where userid=?";
		try{
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setUserid(rs.getString("userid"));
				dto.setTel(rs.getString("tel"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
		
	}
	//회원정보수정 메소드
	public int userModify(UserDTO dto) {
		int row=0;
		String sql="update tbl_user set name=?, passwd=?, tel=? "
				+ " where userid=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getUserid());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
		
	}
	//회원전체 검색 메소드
	
	//특정회원(id, name, tel) 검색 메소드
	
	//특정회원삭제메소드
	
}
