package model;

public class ScoreDTO {
	private String hakbun;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double ave;
	
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
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
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
}
