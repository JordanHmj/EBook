package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import EBook.Model.BookList;

public class BookListDao {

	public BookListDao()
	{
		
	}
	
	public List<BookList> getBookLists()
	{
		BookList bookList;
		List<BookList> bookLists=new ArrayList<BookList>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			Statement st = conn.createStatement();
			String sql = "select * FROM (select 0 as ID,null as Name,ID as CategoryID,Name as CategoryName,0.0 as Score,0 as DownNum from tBookCategory"
					+" UNION ALL select ID+DATE_FORMAT(CreateDate, '%s%H%i') as ID,Name,CategoryID,null as CategoryName,Score,DownNum from tBooks) a ORDER BY a.CategoryID,a.ID";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				bookList=new BookList();
				bookList.setID(rs.getInt("ID"));
				bookList.setName(rs.getString("Name"));
				bookList.setCategoryID(rs.getString("CategoryID"));
				bookList.setCategoryName(rs.getString("CategoryName"));
				bookList.setScore(rs.getFloat("Score"));
				bookList.setDownNum(rs.getInt("DownNum"));
	            bookLists.add(bookList);
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return bookLists;
	}
}
