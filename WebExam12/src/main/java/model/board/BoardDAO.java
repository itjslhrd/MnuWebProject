package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private BoardDAO() {}
	//자신의 객체 생성
	private static BoardDAO instance = new BoardDAO();
	
	//DAO 객체 반환
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//전체 게시글 수 카운트
	public int boardCount(){
		int row = 0;
		String sql = "select count(*) from tbl_board_01";
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
	
	//전체 게시글 목록
	public List<BoardDTO01> boardList(){
		List<BoardDTO01> bList = new ArrayList();
		String sql = "select * from tbl_board_01 order by idx desc";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO01 dto = new BoardDTO01();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setRegdate(rs.getString("regdate"));
				
				bList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bList;
	}
	//게시글 등록
	
	//기본키를 이용한 게시글 검색(view, modify사용)
	
	//게시글 조회수 증가
	
	//게시글 수정

	//게시글 삭제

}
