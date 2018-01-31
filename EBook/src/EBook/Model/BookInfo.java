package EBook.Model;

import java.util.List;

public class BookInfo {
	private VmBookDetail vBookDetail;
	private List<VmCommentHost> commHosts;
	
	
	public VmBookDetail getvBookDetail() {
		return vBookDetail;
	}
	public void setvBookDetail(VmBookDetail vBookDetail) {
		this.vBookDetail = vBookDetail;
	}
	public List<VmCommentHost> getCommHosts() {
		return commHosts;
	}
	public void setCommHosts(List<VmCommentHost> commHosts) {
		this.commHosts = commHosts;
	}
}
