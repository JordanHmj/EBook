package EBook.BLL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EBook.DAO.BookCategoryDao;
import EBook.Model.BookCategory;

/**
 * Servlet implementation class GetBookCategory
 */
@WebServlet("/GetBookCategory")
public class GetBookCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookCategory() {
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
		PrintWriter out=response.getWriter();
        BookCategoryDao bookCategoryDao=new BookCategoryDao();
        List<BookCategory> bookCategoryList=bookCategoryDao.getBookCategorys();
        BookCategory bookCategory;
        bookCategory=bookCategoryList.get(0);
        out.print("<dl>");
        for(int i=0;i<bookCategoryList.size();i++)
        {
        	bookCategory=bookCategoryList.get(i);
        	if(bookCategory.getName().length()==0)
        	{
    			out.print("<dt>"+bookCategory.getCategory()+"</dt>");
        	}
        	else
        	{
        		out.print("<dd onclick=cate("+bookCategory.getID()+")>"+bookCategory.getName()+"</dd>");
        	}
        }
        out.print("</dl>");
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
