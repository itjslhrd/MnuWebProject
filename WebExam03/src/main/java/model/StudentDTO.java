package model;

public class StudentDTO {
	private String name;
	private String gender;
	private String job;
	private String sports;
	
	public StudentDTO() {}
	public StudentDTO(String name, String gender, String job, String sports) {
		this.name=name;
		this.gender=gender;
		this.job=job;
		this.sports=sports;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
}
