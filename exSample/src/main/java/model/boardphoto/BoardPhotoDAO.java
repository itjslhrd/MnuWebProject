package model.boardphoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class BoardPhotoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	private BoardPhotoDAO() {}
	private static BoardPhotoDAO instance = new BoardPhotoDAO();
	public static BoardPhotoDAO getInstance() {
		return instance;
	}
	
	//등록 메소드
	public int boardPhotoWrite(BoardPhotoDTO dto) {
		int row = 0;
		String sql = "insert into tbl_photoboard (name, subject, contents, pass ) "
				+ "	values(?,?,?,?)";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContents());
			pstmt.setString(4, dto.getPass());
			
			row = pstmt.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 전제 게시글수 카운트
	public int boardCount() {
		int row=0;
		String sql="select count(*) as counter from tbl_photoboard";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	// 전제 게시글수 카운트(검색조건 포함)
	public int boardCount(String search, String key) {
		int row=0;
		String sql="select count(*) as counter from tbl_photoboard"
				+ " where " + search + " like ?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt("counter");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//전체목록
	public List<BoardPhotoDTO> boardList(){
		List<BoardPhotoDTO> list = new ArrayList();
		String sql="select * from tbl_photoboard order by idx desc";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardPhotoDTO dto = new BoardPhotoDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//전체목록(검색조건 포함)
	public List<BoardPhotoDTO> boardList(String search, String key){
		List<BoardPhotoDTO> list = new ArrayList();
		String sql="select * from tbl_photoboard where " + search + 
					" like ? order by idx desc";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ key + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardPhotoDTO dto = new BoardPhotoDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//idx에 해당하는 글 검색
	public BoardPhotoDTO boardSelect(int idx){
		BoardPhotoDTO dto = new BoardPhotoDTO();
		String sql="select * from tbl_photoboard where idx=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}

	//특정글 수정
	public int boardPhotoModify(BoardPhotoDTO dto) {
		int row = 0;
		String sql = "update tbl_photoboard set subject=?, contents=? "
									+ " where idx=? and pass=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getIdx());
			pstmt.setString(4, dto.getPass());
			
			row = pstmt.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	//특정글 삭제
	public int boardPhotoDelete(int idx, String pass) {
		int row = 0;
		String sql = "delete from tbl_photoboard "
				+ " where idx=? and pass=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			
			row = pstmt.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
}
