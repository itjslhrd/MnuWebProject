package model;

public class PersonDTO {
	private int bun;
	private String name;
	private String gender;
	private int score;
	
	//생성자 메소드
	public PersonDTO(int bun, String name, String gender, int score) {
		this.bun=bun;
		this.name=name;
		this.gender=gender;
		this.score=score;
	}

	//Setter&Getter 생성
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
