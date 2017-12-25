package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import EBook.Model.Book;

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
			num = st.executeUpdate(sql);

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
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){
				exist=true;
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
