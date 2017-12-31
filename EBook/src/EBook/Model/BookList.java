package EBook.Model;

public class BookList {
	private int ID;
	private String Name;
	private String CategoryID;
	private String CategoryName;
	private float Score;
	private int DownNum;

	public BookList() {
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
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

}
