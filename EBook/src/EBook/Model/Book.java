package EBook.Model;

public class Book {
	private int ID;
	private String NameCn;
	private String NameEn;
	private int Score;
	private int DownNum;
	private int HostID;
	private int CategoryID;
	public Book() {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNameCn() {
		return NameCn;
	}
	public void setNameCn(String nameCn) {
		NameCn = nameCn;
	}
	public String getNameEn() {
		return NameEn;
	}
	public void setNameEn(String nameEn) {
		NameEn = nameEn;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public int getDownNum() {
		return DownNum;
	}
	public void setDownNum(int downNum) {
		DownNum = downNum;
	}
	public int getHostID() {
		return HostID;
	}
	public void setHostID(int hostID) {
		HostID = hostID;
	}
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
}
