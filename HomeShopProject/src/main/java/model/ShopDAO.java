package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class ShopDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//회원등록 메소드
	public int memberWrite(MemberDTO dto) {
		//반환값 정의
		int row=0;
		//쿼리
		String sql="insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city)\r\n"
				+ "		values(?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			//?에 값 대입
			pstmt.setInt(1, dto.getCustno());//정수 대입
			pstmt.setString(2, dto.getCustname());//문자열 대입
			pstmt.setString(3, dto.getPhone());//문자열 대입
			pstmt.setString(4, dto.getGender());//문자열 대입
			pstmt.setString(5, dto.getJoindate());//문자열 대입
			pstmt.setString(6, dto.getGrade());//문자열 대입
			pstmt.setString(7, dto.getCity());//문자열 대입
			
			//명령 실행
			row = pstmt.executeUpdate();//insert, update, delete
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//insert, update, delete
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//회원전체목록검색 메소드
	public List<MemberDTO> memberList(){
		//반환값 정의
		List<MemberDTO> list = new ArrayList();
		//쿼리
		//String sql="select * from tbl_member_001 order by custno";
		String sql="select custno, custname, phone, gender, joindate,\r\n"
				+ "		grade,cityname from tbl_member_001 t1, tbl_citY_001 t2\r\n"
				+ "				where t1.city=t2.city";
		
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();//select
			while(rs.next()) {  //단 한줄 if(rs.next){
				MemberDTO dto = new MemberDTO();
				dto.setCustno(rs.getInt("custno"));//rs 값을 dto에 세팅
				dto.setCustname(rs.getString("custname"));//
				dto.setPhone(rs.getString("phone"));//
				dto.setGender(rs.getString("gender"));//
				dto.setJoindate(rs.getString("joindate"));//
				dto.setGrade(rs.getString("grade"));//
				dto.setCity(rs.getString("cityname"));//
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//select
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}
	
	//회원 매출 조회 메소드
	public List<MemberDTO> memberSaleList(){
		//반환값 정의
		List<MemberDTO> list = new ArrayList();
		//쿼리
		String sql="select t1.custno,custname,phone,grade,sum(price) tot\r\n"
				+ "		from tbl_member_001 t1, tbl_money_001 t2\r\n"
				+ "				where t1.custno=t2.custno\r\n"
				+ "						group by t1.custno,custname,phone,grade\r\n"
				+ "								order by sum(price) desc";
		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setCustno(rs.getInt("custno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setGrade(rs.getString("grade"));
				dto.setTot(rs.getInt("tot"));

				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//insert, update, delete
			DBManager.close(conn, pstmt);
		}
		return list;
	}
	//회원정보검색메소드
	public MemberDTO memberSearch(int custno) {
		//반환값 정의
		MemberDTO dto = new MemberDTO();
		//쿼리
		String sql="select custno, custname, phone, gender, joindate,\r\n"
				+ "		grade,cityname from tbl_member_001 t1, tbl_citY_001 t2\r\n"
				+ "				where t1.city=t2.city and custno=?";

		try {
			conn = DBManager.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				dto.setCustno(rs.getInt("custno"));//rs 값을 dto에 세팅
				dto.setCustname(rs.getString("custname"));//
				dto.setPhone(rs.getString("phone"));//
				dto.setGender(rs.getString("gender"));//
				dto.setJoindate(rs.getString("joindate"));//
				dto.setGrade(rs.getString("grade"));//
				dto.setCity(rs.getString("cityname"));//
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//insert, update, delete
			DBManager.close(conn, pstmt);
		}
		return dto;
		
	}
}
