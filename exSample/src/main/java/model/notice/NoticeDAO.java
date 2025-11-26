package model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.board.BoardDTO;
import util.DBManager;

public class NoticeDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	private NoticeDAO() {}
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}

	//공지사항 최근글 n개
	public List<NoticeDTO> noticeList(int num) {
		List<NoticeDTO> nList = new ArrayList();
		String sql="select * from tbl_notice order by idx desc limit 0,?";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDTO nDto = new NoticeDTO();
				nDto.setIdx(rs.getInt("idx"));
				nDto.setAdid(rs.getString("adid"));
				nDto.setSubject(rs.getString("subject"));
				nDto.setRegdate(rs.getString("regdate"));
				nDto.setReadcnt(rs.getInt("readcnt"));
				
				nList.add(nDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nList;
	}
	
	//공지사항 전체 게시글수 카운트
	public int noticeCount() {
		int row=0;
		String sql="select count(*) as counter from tbl_notice";
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

 	//1_1. 조건에 맞는 공지사항 게시글수 카운트
 	public int noticeCount(String search, String key) {
 		//반환타입
 		int row = 0;
 		//쿼리
 		String sql = "select count(*) counter from tbl_notice where " + search + " like ?";
 		
 		try {
 			conn = DBManager.getConn();
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, "%"+key+"%");
 			
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
	
	//공지사항 전체 게시글 검색
	public List<NoticeDTO> noticeList() {
		List<NoticeDTO> nList = new ArrayList();
		String sql="select * from tbl_notice order by idx desc";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDTO nDto = new NoticeDTO();
				nDto.setIdx(rs.getInt("idx"));
				nDto.setAdid(rs.getString("adid"));
				nDto.setSubject(rs.getString("subject"));
				nDto.setRegdate(rs.getString("regdate"));
				nDto.setReadcnt(rs.getInt("readcnt"));
				
				nList.add(nDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nList;
	}

 	//2_2. 전체 게시글수 목록
 	public List<NoticeDTO> noticeList(String search, String key) {
 		//반환타입
 		List<NoticeDTO> list = new ArrayList();
 		//쿼리
 		String sql = "select * from tbl_notice where "+search+" like ? order by regdate desc";
 		
 		try {
 			conn = DBManager.getConn();
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, "%"+key+"%");
 			
 			rs = pstmt.executeQuery();
 			
 			while(rs.next()) {
 				NoticeDTO dto = new NoticeDTO();
 				dto.setIdx(rs.getInt("idx"));
 				dto.setAdid(rs.getString("adid"));
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

 	// 페이지 처리를 위한 메소드
 	public List<NoticeDTO> noticeList(int pagestart, int maxlist) {
 		//반환타입
 		List<NoticeDTO> list = new ArrayList();
 		//쿼리
 		String sql = "select * from tbl_notice order by idx desc limit ?,?";
 		
 		try {
 			conn = DBManager.getConn();
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setInt(1, pagestart);
 			pstmt.setInt(2, maxlist);
 			
 			rs = pstmt.executeQuery();
 			
 			while(rs.next()) {
 				NoticeDTO dto = new NoticeDTO();
 				dto.setIdx(rs.getInt("idx"));
 				dto.setAdid(rs.getString("adid"));
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

 	// 페이지 처리를 위한 메소드(검색조건 포함)
 	public List<NoticeDTO> noticeList(int pagestart, int maxlist, String search, String key) {
 		//반환타입
 		List<NoticeDTO> list = new ArrayList();
 		//쿼리
 		String sql = "select * from tbl_notice where " + search + " like ? order by idx desc limit ?,?";
 		
 		try {
 			conn = DBManager.getConn();
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, "%"+key+"%");
 			pstmt.setInt(2, pagestart);
 			pstmt.setInt(3, maxlist);
 			
 			rs = pstmt.executeQuery();
 			
 			while(rs.next()) {
 				NoticeDTO dto = new NoticeDTO();
 				dto.setIdx(rs.getInt("idx"));
 				dto.setAdid(rs.getString("adid"));
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

	//공지사항 등록(관리자)
	
	//공지사항 수정(관리자)
	
	//공지사항 상세보기 시 글 조회수 증가
	public void noticeHits(int idx) {
		String sql="update tbl_notice set readcnt = readcnt + 1 "
				+ "where idx=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	//공지사항 상세보기(기본키(idx)를 이용한 특정 글 검색)
	public NoticeDTO noticeSelect(int idx) {
		NoticeDTO nDto = new NoticeDTO();
		String sql="select * from tbl_notice where idx = ?";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nDto.setIdx(rs.getInt("idx"));
				nDto.setAdid(rs.getString("adid"));
				nDto.setSubject(rs.getString("subject"));
				nDto.setContents(rs.getString("contents"));
				nDto.setRegdate(rs.getString("regdate"));
				nDto.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nDto;
	}
	
	
}
