package model;

public class Student {
	private String hakbun;//학번
	private String name;//이름
	private String phone1;//전화1
	private String phone2;//전화2
	private String phone3;//전화3
	private String birth;//생년월일
	private String gender;//성별
	private String regdate;//등록일자
	
	public Student() {}
	
	public Student(String hakbun,String name,String phone1,String phone2,
			String phone3,String birth,String gender,String regdate) {
		this.hakbun=hakbun;
		this.name=name;
		this.phone1=phone1;
		this.phone2=phone2;
		this.phone3=phone3;
		this.birth=birth;
		this.regdate=regdate;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
