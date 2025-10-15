package model;

public class InoutDTO {
	private String t_no;//입출고번호
	private String p_code;//제품코드
	private String t_type;//입출고구분
	private int t_cnt;//수량
	private String t_date;//거래일자
	private String c_code;//거래처코드
	
	public String getT_no() {
		return t_no;
	}
	public void setT_no(String t_no) {
		this.t_no = t_no;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public int getT_cnt() {
		return t_cnt;
	}
	public void setT_cnt(int t_cnt) {
		this.t_cnt = t_cnt;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
}
