package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import EBook.Model.*;

public class BookCategoryDao {
	
	public BookCategoryDao()
	{
		
	}
	
	public List<BookCategory> getBookCategorys(String _category)
	{
		BookCategory bookCategory;
		List<BookCategory> bookCategoryList=new ArrayList<BookCategory>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			
			String sql = "select * from tBookCategory where Category=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, _category);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				bookCategory=new BookCategory();
				bookCategory.setID(rs.getInt("ID"));
				bookCategory.setName(rs.getString("Name"));
				bookCategory.setCategory(rs.getString("Category"));
	            bookCategoryList.add(bookCategory);
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return bookCategoryList;
	}
	
	public List<BookCategory> getBookCategorys()
	{
		BookCategory bookCategory;
		List<BookCategory> bookCategoryList=new ArrayList<BookCategory>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			
			String sql = "select * from tBookCategory";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				bookCategory=new BookCategory();
				bookCategory.setID(rs.getInt("ID"));
				bookCategory.setName(rs.getString("Name"));
				bookCategory.setCategory(rs.getString("Category"));
	            bookCategoryList.add(bookCategory);
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return bookCategoryList;
	}
	
	public String getIntro(int id)
	{
		String intro="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			
			String sql = "select Intro from tBookCategory where ID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				intro=rs.getString("Intro");
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return intro;
	}
}
