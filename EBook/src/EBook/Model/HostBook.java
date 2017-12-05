package EBook.Model;

public class HostBook {
	private int ID;
	private int HostID;
	private int BookID;
	private int CommentID;
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
	public int getCommentID() {
		return CommentID;
	}
	public void setCommentID(int commentID) {
		CommentID = commentID;
	}
}
