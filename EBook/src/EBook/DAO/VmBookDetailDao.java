package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EBook.Model.BookInfo;
import EBook.Model.Comment;
import EBook.Model.VmBookDetail;
import EBook.Model.VmCommentHost;

public class VmBookDetailDao {
	
	public BookInfo getBookInfo(int signID)
	{
		BookInfo bookInfo=new BookInfo();
		VmBookDetail vBookDetail=getVmBookDetail(signID);
		List<VmCommentHost> vCommHost=getVmCommentHosts(vBookDetail.getID());
		bookInfo.setvBookDetail(vBookDetail);
		bookInfo.setCommHosts(vCommHost);
		return bookInfo;
	}
	
	public VmBookDetail getVmBookDetail(int signID)
	{
		VmBookDetail vBookDetail=new VmBookDetail();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "select ID,SignID,Name,Introduction from tBooks where SignID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, signID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				vBookDetail.setID(rs.getInt("ID"));
	            vBookDetail.setSignID(rs.getInt("SignID"));
	            vBookDetail.setName(rs.getString("Name"));
	            vBookDetail.setIntroduction(rs.getString("Introduction"));
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return vBookDetail;
	}
	
	public List<VmCommentHost> getVmCommentHosts(int bookID)
	{
		List<VmCommentHost> commHosts=new ArrayList<VmCommentHost>();
		VmCommentHost commHost;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			
			String sql = "SELECT b.UserName,a.CreateDate,a.Content FROM tComments a LEFT JOIN tHosts b on a.HostID=b.ID where a.BookID=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, bookID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				commHost=new VmCommentHost();
				commHost.setUserName(rs.getString("UserName"));
				commHost.setCreateDate(rs.getString("CreateDate"));
				commHost.setContent(rs.getString("Content"));
				commHosts.add(commHost);
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return commHosts;
	}
}
