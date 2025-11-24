package model.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class PdsDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	private PdsDAO() {}
	private static PdsDAO instance = new PdsDAO();
	public static PdsDAO getInstance() {
		return instance;
	}
	
	//전체 글수 카운트
	public int pdsCount() {
		int row=0;
		String sql="select count(*) as counter from tbl_pds";
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
	//특정 조건에 맞는 글수 카운트
	public int pdsCount(String search, String key) {
		int row=0;
		String sql="select count(*) as counter from tbl_pds "
				+ "	where " + search + " like ?";
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
	//전체목록
	public List<PdsDTO> pdsList() {
		List<PdsDTO> list = new ArrayList();
		
		String sql="select * from tbl_pds order by idx desc";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PdsDTO dto = new PdsDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setFilename(rs.getString("filename"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//특정조건에 맞는 글 목록
	public List<PdsDTO> pdsList(String search, String key) {
		List<PdsDTO> list = new ArrayList();
		
		String sql="select * from tbl_pds where " + search + " like ? order by idx desc";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PdsDTO dto = new PdsDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setFilename(rs.getString("filename"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//등록
	public int pdsWrite(PdsDTO dto) {
		int row=0;
		String sql="insert into tbl_pds(name, subject, contents, filename, pass) "
				+ " values(?,?,?,?,?)";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContents());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getPass());
			
			row = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//idx해당하는 글 검색
	public PdsDTO pdsSelect(int idx) {
		PdsDTO dto = new PdsDTO();
		
		String sql="select * from tbl_pds where idx = ?";
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
				dto.setFilename(rs.getString("filename"));	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	//수정
	public int pdsModify(PdsDTO dto) {
		int row=0;
		String sql="update tbl_pds set subject = ?, contents = ?, "
				+ " filename = ? where idx = ? and pass = ?";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContents());
			pstmt.setString(3, dto.getFilename());
			pstmt.setInt(4, dto.getIdx());
			pstmt.setString(5, dto.getPass());
			
			row = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	//삭제
	public int pdsDelete(int idx, String pass) {
		int row=0;
		String sql="delete from tbl_pds where idx = ? and pass = ?";
		
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
	
	// 첨부파일 검사
	public String pdsFileSearch(int idx) {
		String filename = "";
		
		String sql="select filename from tbl_pds where idx = ?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				filename = rs.getString("filename");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return filename;
	}
	
}
