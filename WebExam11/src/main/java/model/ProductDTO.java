package model;

public class ProductDTO {
	private String p_code;//제품코드
	private String p_name;//제품명
	private int p_size;//사이즈
	private int p_incost;//매인단가
	private int p_outcost;//출고단가
	
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_size() {
		return p_size;
	}
	public void setP_size(int p_size) {
		this.p_size = p_size;
	}
	public int getP_incost() {
		return p_incost;
	}
	public void setP_incost(int p_incost) {
		this.p_incost = p_incost;
	}
	public int getP_outcost() {
		return p_outcost;
	}
	public void setP_outcost(int p_outcost) {
		this.p_outcost = p_outcost;
	}
}
