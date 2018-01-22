package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import EBook.Model.Book;
import EBook.Model.BookInfo;
import EBook.Model.Comment;

public class BookDao {
    
	public BookDao() {
		
	}
	
	public int AddBook(String _name,String _hostID,String _categoryID,String _introduction)
	{
		int num=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "insert into tBooks(Name) value('aaa')";
			PreparedStatement st = conn.prepareStatement(sql);
/*			st.setString(1, _name);
			st.setInt(2, Integer.parseInt(_hostID));
			st.setInt(3, Integer.parseInt(_categoryID));
			st.setString(4, _introduction);
			st.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
			System.out.println(sql);*/
			num = st.executeUpdate();

			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return num;
	}
	
	public boolean isExist(String bookName,String userID)
	{
		boolean exist=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "select * from tBooks where Name=? and HostID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, bookName);
			st.setInt(2, Integer.parseInt(userID));
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){
				exist=true;
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return exist;
	}
	
	public List<Book> getBooks()
	{
		Book book;
		List<Book> bookList=new ArrayList<Book>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			Statement st = conn.createStatement();
			String sql = "select * from tBooks";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
	            book=new Book();
	            book.setID(rs.getInt("ID"));
	            book.setName(rs.getString("Name"));
	            book.setScore(rs.getFloat("Score"));
	            book.setDownNum(rs.getInt("DownNum"));
	            book.setHostID(rs.getInt("HostID"));
	            book.setCategoryID(rs.getInt("CategoryID"));
	            book.setIntroduction(rs.getString("Introduction"));
	            book.setCreateDate(rs.getDate("CreateDate"));
	            bookList.add(book);
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return bookList;
	}
	
	public Book getBook(int signID)
	{
		Book book=new Book();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "select * from tBooks where ID+DATE_FORMAT(CreateDate, '%s%H%i')=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, signID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
	            book.setID(rs.getInt("ID"));
	            book.setName(rs.getString("Name"));
	            book.setScore(rs.getFloat("Score"));
	            book.setDownNum(rs.getInt("DownNum"));
	            book.setHostID(rs.getInt("HostID"));
	            book.setCategoryID(rs.getInt("CategoryID"));
	            book.setIntroduction(rs.getString("Introduction"));
	            book.setCreateDate(rs.getDate("CreateDate"));
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return book;
	}
	
	public BookInfo getBookInfo(int signID)
	{
		BookInfo bookInfo=new BookInfo();
		
		Book book=getBook(signID);
		bookInfo.setBook(book);
		
		CommentDao commDao=new CommentDao();
		List<Comment> commArrs=commDao.getComments(book.getID());
		bookInfo.setComments(commArrs);
		return bookInfo;
	}
}
