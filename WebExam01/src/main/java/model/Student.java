package model;

public class Student {
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	
	public Student(int bun,String name, int kor, int eng, int mat){
		this.bun=bun;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		totAve();//메소드 호출
	}
	private void totAve() {
		tot=kor+eng+mat;
		ave = tot /3.;
	}
	public int getBun() {
		return bun;
	}
	public void setBun(int bun) {
		this.bun = bun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}
}
