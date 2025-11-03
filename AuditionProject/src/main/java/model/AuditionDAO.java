package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class AuditionDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1. 오디션 지원자 등록 메소드
	public int artistWrite(ArtistDTO dto) {
		int row=0;
		String sql="insert into tbl_artist_201905 values (?,?,?,?,?,?)";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getArtist_id());
			pstmt.setString(2,dto.getArtist_name());
			pstmt.setString(3,dto.getArtist_gender());
			pstmt.setString(4,dto.getArtist_birth());
			pstmt.setString(5,dto.getTalent());
			pstmt.setString(6,dto.getAgency());
			
			row = pstmt.executeUpdate();//insert,update,delete
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//2. 참가자 목록 조회 메소드
	
	//3.멘토점수조회 메소드
	
	//4.참가자조회 메소드
	
	//5.참가자 등수 조회메소드
	
}
