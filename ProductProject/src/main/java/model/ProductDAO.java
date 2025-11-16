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
	
	// 입출고번호 마지막번호+1
	public int inoutMax() {
		int row=0;
		String sql="select max(t_no)+1 aa from tbl_inout_202002";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt("aa");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	
	//거래처 전체 목록 출력
	public List<CompanyDTO> companyList(){
		List<CompanyDTO> cList = new ArrayList();
		String sql="select c_code, c_name from tbl_company_202002";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CompanyDTO dto = new CompanyDTO();
				dto.setC_code(rs.getString("c_code"));
				dto.setC_name(rs.getString("c_name"));
				
				cList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return cList;
	}
	
	
}
