package model;

public class PointDTO {
	private int serail_no;
	private String artist_id;
	private String memto_id;
	private int point;
	
	public int getSerail_no() {
		return serail_no;
	}
	public void setSerail_no(int serail_no) {
		this.serail_no = serail_no;
	}
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getMemto_id() {
		return memto_id;
	}
	public void setMemto_id(String memto_id) {
		this.memto_id = memto_id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
