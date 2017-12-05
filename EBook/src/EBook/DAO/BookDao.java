package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import EBook.Model.Book;

public class BookDao {
    //数据库地址
    private String url = "jdbc:mysql://47.93.246.137:3306/EBookDB";
    //MySQL配置时的用户名
    private String userName = "root";
    //MySQL配置时的密码
    private String password = "JordanHmj@01";
    
	public BookDao() {
		
	}
	
	public List<Book> getBooks()
	{
		Book book;
		List<Book> bookList=new ArrayList<Book>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement st = conn.createStatement();
			String sql = "select * from tBooks";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
	            book=new Book();
	            book.setID(rs.getInt("ID"));
	            book.setNameCn(rs.getString("NameCn"));
	            book.setNameEn(rs.getString("NameEn"));
	            book.setScore(rs.getInt("Score"));
	            book.setDownNum(rs.getInt("DownNum"));
	            book.setHostID(rs.getInt("HostID"));
	            book.setCategoryID(rs.getInt("CategoryID"));
	            bookList.add(book);
	        }
			rs.close();
			st.close();
			conn.close();
		}
		catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return bookList;
	}
}
