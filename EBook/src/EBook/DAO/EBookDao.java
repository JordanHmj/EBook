package EBook.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EBookDao {
	//����Connection����
    Connection con;
    //����������
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/sqltestdb";
    //MySQL����ʱ���û���
    String user = "root";
    //MySQL����ʱ������
    String password = "123456";
    //������ѯ�����
    
    public EBookDao()
    {
    }
    
    public void getlist()
    {
    	try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            String sql = "select * from emp";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");  
            System.out.println("-----------------");  
            System.out.println("����" + "\t" + "ְ��");  
            System.out.println("-----------------");  
             
            String job = null;
            String id = null;
            while(rs.next()){
                //��ȡstuname��������
                job = rs.getString("job");
                //��ȡstuid��������
                id = rs.getString("ename");

                //������
                System.out.println(id + "\t" + job);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
    }
}