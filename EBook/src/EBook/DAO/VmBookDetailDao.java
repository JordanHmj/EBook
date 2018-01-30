package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EBook.Model.Comment;
import EBook.Model.VmCommentHost;

public class VmBookDetailDao {
	
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
