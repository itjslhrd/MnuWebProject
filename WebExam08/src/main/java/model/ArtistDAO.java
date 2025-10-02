package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//드라이버로딩 및 커넥션 객체 생성 메소드
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

	//전체 목록
	public List<ArtistDTO> artistList(){
		//반환타입정의
		List<ArtistDTO> aList = new ArrayList();
		//query
		String sql="select * from tbl_artist_201905";
		
		try {
			//커넥션 연결
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//select
			while(rs.next()) {
				ArtistDTO dto = new ArtistDTO();
				dto.setArtist_id(rs.getString("artist_id"));
				dto.setArtist_name(rs.getString("artist_name"));
				dto.setArtist_birth(rs.getString("artist_birth"));
				dto.setArtist_gender(rs.getString("artist_gender"));
				dto.setTalent(rs.getString("talent"));
				dto.setAgency(rs.getString("agency"));
				
				aList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return aList;
	}
	
}
