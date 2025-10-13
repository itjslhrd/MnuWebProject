package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuditionDAO {
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
	//등록
	public int auditionWrite(AuditionDTO dto) {
		//반환타입정의
		int row=0;
		//query
		String sql="insert into tbl_artist_201905(artist_id, "
				+ "artist_name, artist_gender, artist_birth,"
				+ " talent, agency) values(?,?,?,?,?,?)";
		
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getArtist_id());
			pstmt.setString(2, dto.getArtist_name());
			pstmt.setString(3, dto.getArtist_gender());
			pstmt.setString(4, dto.getArtist_birth());
			pstmt.setString(5, dto.getTalent());
			pstmt.setString(6, dto.getAgency());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	//전체 목록
	public List<AuditionDTO> auditionList(){
		//반환타입정의
		List<AuditionDTO> aList = new ArrayList();
		//query
		String sql="select * from tbl_artist_201905";
		
		try {
			//커넥션 연결
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//select
			while(rs.next()) {
				AuditionDTO dto = new AuditionDTO();
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
