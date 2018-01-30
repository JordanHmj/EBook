package EBook.Model;

import java.util.List;

public class BookInfo {
	private Book book;
	private List<VmCommentHost> commHosts;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<VmCommentHost> getCommHosts() {
		return commHosts;
	}
	public void setCommHosts(List<VmCommentHost> commHosts) {
		this.commHosts = commHosts;
	}
}
