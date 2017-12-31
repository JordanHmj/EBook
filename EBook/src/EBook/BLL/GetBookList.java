package EBook.BLL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EBook.DAO.BookListDao;
import EBook.Model.BookList;

/**
 * Servlet implementation class GetBookList
 */
@WebServlet("/GetBookList")
public class GetBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookList() {
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
		
		BookListDao bookListDao=new BookListDao();
		List<BookList> bookLists=bookListDao.getBookLists();
		BookList bookList;
		String outStr;
		for(int i=0;i<bookLists.size();i++)
		{
			bookList=bookLists.get(i);
			if(bookList.getID()==0)
			{
				outStr=bookList.getCategoryName()+"<br />";
			}
			else
			{
				outStr="<a href='BookDetail.html?uid="+bookList.getID()+"'>"+bookList.getName()+"</a> "+String.valueOf(bookList.getScore())+" "+String.valueOf(bookList.getDownNum())+"<br />";
			}
			out.println(outStr);
		}
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
