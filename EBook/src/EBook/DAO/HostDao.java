package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import EBook.Model.Host;

public class HostDao {
    
	public HostDao() {
		
	}
	
	public Host getHost(String _ID)
	{
		Host host=new Host();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "select * from tHosts where ID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, _ID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
	            host.setID(rs.getInt("ID"));
	            host.setUserName(rs.getString("UserName"));
	            host.setUserPwd(rs.getString("UserPwd"));
	            host.setUserMail(rs.getString("UserMail"));
	            host.setUserCity(rs.getString("UserCity"));
	            host.setUserSex(rs.getString("UserSex"));
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
		return host;
	}
	
	public int isHost(String _userName,String _userPwd)
	{
		int hostID=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "select * from tHosts where UserName=? and UserPwd=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, _userName);
			st.setString(2, _userPwd);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				hostID=rs.getInt("ID");
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
		return hostID;
	}
}
