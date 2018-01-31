package EBook.BLL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EBook.DAO.VmBookDetailDao;
import EBook.Model.BookInfo;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetBookInfo
 */
@WebServlet("/GetBookInfo")
public class GetBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookInfo() {
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
		int signID=Integer.parseInt(request.getParameter("SignID"));
		VmBookDetailDao vBookDetailDao=new VmBookDetailDao();
		BookInfo bookInfo=vBookDetailDao.getBookInfo(signID);
		JSONObject json=JSONObject.fromObject(bookInfo);
		PrintWriter out=response.getWriter();
		out.print(json);
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
