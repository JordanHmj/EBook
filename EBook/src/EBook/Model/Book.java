package EBook.Model;

import java.util.Date;

public class Book {
	private int ID;
	private int SignID;
	private String Name;
	private float Score;
	private int DownNum;
	private int HostID;
	private int CategoryID;
	private String Introduction;
	private Date CreateDate;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public int getSignID() {
		return SignID;
	}
	public void setSignID(int signID) {
		SignID = signID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getScore() {
		return Score;
	}
	public void setScore(float score) {
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
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Book() {
		
	}
	
}
