package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private ProductDAO() {}
	//자신의 객체 생성
	private static ProductDAO instance = new ProductDAO();
	
	//DAO 객체 반환
	public static ProductDAO getInstance() {
		return instance;
	}
	// 제품 조회 메소드
	public List<ProductDTO> productList(){
		List<ProductDTO> pList = new ArrayList<ProductDTO>();
		String sql="select * from tbl_product_202002";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setP_code(rs.getString("p_code"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_size(rs.getInt("p_size"));
				dto.setP_incost(rs.getInt("p_incost"));
				dto.setP_outcost(rs.getInt("p_outcost"));
				
				pList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pList;
	}
	//입출고 등록
	public int productInout(InoutDTO dto) {
		int row=0;
		String sql="insert into tbl_inout_202002(t_no,p_code,t_type,t_cnt,t_date,c_code) "
				+ "values(?,?,?,?,?,?)";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getT_no());
			pstmt.setString(2, dto.getP_code());
			pstmt.setString(3, dto.getT_type());
			pstmt.setInt(4, dto.getT_cnt());
			pstmt.setString(5, dto.getT_date());
			pstmt.setString(6, dto.getC_code());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	//수정폼 사용할 데이터 검색
	public ProductDTO productSearch(String p_code) {
		ProductDTO dto = new ProductDTO();
		String sql="select * from tbl_product_202002 where p_code=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setP_code(rs.getString("p_code"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_size(rs.getInt("p_size"));
				dto.setP_incost(rs.getInt("p_incost"));
				dto.setP_outcost(rs.getInt("p_outcost"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	//수정처리
	public int productModify(ProductDTO dto) {
		int row=0;
		String sql="update tbl_product_202002 set p_name=?, p_size=?, p_incost=?, "
				+ "p_outcost=?, p_update=curdate()	where p_code=?";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getP_name());
			pstmt.setInt(2, dto.getP_size());
			pstmt.setInt(3, dto.getP_incost());
			pstmt.setInt(4, dto.getP_outcost());
			pstmt.setString(5, dto.getP_code());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	// 입출고 조회 메소드
	public List<InoutDTO> productInoutList(){
		List<InoutDTO> pList = new ArrayList();
		String sql="select * from tbl_inout_202002";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				InoutDTO dto = new InoutDTO();
				dto.setT_no(rs.getString("t_no"));
				dto.setP_code(rs.getString("p_code"));
				dto.setT_type(rs.getString("t_type"));
				dto.setT_cnt(rs.getInt("t_cnt"));
				dto.setT_date(rs.getString("t_date"));
				dto.setC_code(rs.getString("c_code"));
				
				pList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pList;
	}

}
