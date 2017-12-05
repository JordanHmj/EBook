package EBook.BLL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import EBook.Model.*;
import EBook.DAO.*;

/**
 * Servlet implementation class Account
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is HMJ's ");
        out.print(this.getClass());
        out.println(", using the GET method");
        
        out.println("<br /><br />");
        out.print("<table>");
        BookDao bookDao=new BookDao();
        List<Book> bookList=bookDao.getBooks();
        
        for(int i=0;i<bookList.size();i++)
        {
        	Book book=bookList.get(i);
        	out.print("<tr>");
        	out.print("<td>"+book.getNameCn()+"</td>");
        	out.print("<td>"+book.getNameEn()+"</td>");
        	out.print("<td>"+book.getScore()+"</td>");
        	out.print("<td>"+book.getDownNum()+"</td>");
        	out.print("</tr>");
        }
        out.println("  </table>");
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
