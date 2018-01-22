package EBook.Model;

public class Comment {
	private int ID;
	private int HostID;
	private int BookID;
	private String Content;
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
		this.HostID = hostID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		this.BookID = bookID;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
