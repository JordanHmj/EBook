package EBook.BLL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EBook.DAO.ApplicantDao;
import EBook.DAO.BookDao;
import EBook.Model.Book;
import EBook.Util.ShaunUtils;

/**
 * Servlet implementation class HostActivation
 */
@WebServlet("/HostActivation")
public class HostActivation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostActivation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sign=request.getParameter("sign");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is HMJ's ");
        ApplicantDao appDao=new ApplicantDao();
        int result=appDao.AccountActivate(ShaunUtils.HexToString(sign));
        if(result==0)
        {
        	out.print("激活失败！");
        }
        else
        {
        	out.print("激活成功！<a href='Index.html'>返回首页</a>");
        }
        
        
        out.println("<br /><br />");
        
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
