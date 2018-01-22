package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EBook.Model.Comment;

public class CommentDao {
	
	
	public List<Comment> getComments(int bookID)
	{
		List<Comment> commArrs=new ArrayList<Comment>();
		Comment comm;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			
			String sql = "select * from tComments where BookID=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, bookID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				comm=new Comment();
				comm.setID(rs.getInt("ID"));
				comm.setHostID(rs.getInt("HostID"));
				comm.setBookID(rs.getInt("BookID"));
				comm.setContent(rs.getString("Content"));
				commArrs.add(comm);
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return commArrs;
	}
}
