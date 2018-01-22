package EBook.Model;

public class Score {
	private int ID;
	private int HostID;
	private int BookID;
	private int Score;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getHostID() {
		return HostID;
	}
	public void setHostID(int hostID) {
		HostID = hostID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
}
