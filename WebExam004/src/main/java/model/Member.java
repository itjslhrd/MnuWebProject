package model;

public class Member {
	private int custno;//고객번호
	private String custname;//이름
	private String phone;//전화
	private String gender;//성별
	private String joindate;//가입일자
	private String grade;//고객등급
	private String city;//도시코드
	
	public Member() {}
	
	public Member(int custno,String custname,String phone,String gender,String joindate,String grade,String city) {
		this.custno=custno;
		this.custname=custname;
		this.phone=phone;
		this.gender=gender;
		this.joindate=joindate;
		this.grade=grade;
		this.city=city;
	}
	
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
