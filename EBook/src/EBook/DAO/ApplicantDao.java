package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import EBook.Util.ShaunUtils;

public class ApplicantDao {
	
	public ApplicantDao()
	{
		
	}
	
	public int Add(String userName,String userPwd,String userMail)
	{
		int id=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "insert into tApplicants(UserName,UserPwd,UserMail) value(?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, userName);
			st.setString(2, userPwd);
			st.setString(3, userMail);
			st.executeUpdate();
			ResultSet rs=st.getGeneratedKeys();
			if(rs.next())
			{
				id=rs.getInt(1);
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return id;
	}
	
	public int AESPwd(int _id)
	{
		int num=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "update tApplicants set UserPwd=HEX(AES_ENCRYPT(UserPwd,DateKey(CreateDate))) where ID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, _id);
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
	
	public int AccountActivate(String userMail)
	{
		int num=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(ConnBase.url, ConnBase.userName, ConnBase.password);
			String sql = "insert into tHosts(UserName,UserPwd,UserMail,CreateDate) select UserName,UserPwd,UserMail,CreateDate from tApplicants where UserMail=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, userMail);
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
}
