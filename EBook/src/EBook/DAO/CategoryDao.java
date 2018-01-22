package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;

import EBook.Model.Book;
import EBook.Model.BookCategory;
import EBook.Model.Category;

public class CategoryDao {
	public CategoryDao()
	{
		
	}
	
	public Category getCategory(int categoryID) 
	{
		Category cate=new Category();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			
			BookCategory bookCategory;
			String sql = "select * from tBookCategory where ID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, categoryID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				bookCategory=new BookCategory();
				bookCategory.setID(rs.getInt("ID"));
				bookCategory.setName(rs.getString("Name"));
				bookCategory.setCategory(rs.getString("Category"));
				bookCategory.setIntro(rs.getString("Intro"));
				cate.setBookCategory(bookCategory);
	        }
			
			List<Book> books=new ArrayList<Book>();
			Book book;
			sql = "select *,ID+DATE_FORMAT(CreateDate, '%s%H%i') as SignID from tBooks where CategoryID=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, categoryID);
			rs = st.executeQuery();
			
			while(rs.next()){
				book=new Book();
				book.setID(rs.getInt("SignID"));
				book.setName(rs.getString("Name"));
				book.setScore(rs.getFloat("Score"));
				book.setDownNum(rs.getInt("DownNum"));
				book.setHostID(rs.getInt("HostID"));
				book.setCategoryID(rs.getInt("CategoryID"));
				book.setIntroduction(rs.getString("Introduction"));
				book.setCreateDate(rs.getTimestamp("CreateDate"));
				books.add(book);
	        }
			cate.setBooks(books);
			
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return cate;
	}
	
	public JSONObject getCategoryJSON(int categoryID)
	{
		Category cate=getCategory(categoryID);
		JSONObject json=JSONObject.fromObject(cate);
		return json;
	}
}
