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
}
