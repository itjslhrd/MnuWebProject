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
}
