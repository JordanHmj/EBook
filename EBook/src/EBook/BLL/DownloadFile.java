package EBook.BLL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EBook.DAO.BookDao;
import EBook.Model.Book;

/**
 * Servlet implementation class DownloadFile
 */
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String signID=request.getParameter("signID");
		BookDao bookDao=new BookDao();
		Book book=bookDao.getBook(Integer.valueOf(signID));
		
        //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
        //通过文件名找出文件的所在目录
        String fileStr = fileSaveRootPath+"\\"+String.valueOf(book.getCategoryID())+"\\"+book.getName();
        //得到要下载的文件
        File file = new File(fileStr);
        //如果文件不存在
        if(!file.exists()){
        	response.setContentType("text/html;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8");
    		PrintWriter out=response.getWriter();
    		out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.print("<HTML>");
            out.print("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.print("  <BODY>");
            out.print("你要下载的资源不存在或已被删除!");
            out.print("<br /><br />");
            out.print("  </BODY>");
            out.print("</HTML>");
            out.flush();
            out.close();
        }
        else     //文件存在，下载文件
        {
        	//处理文件名
            String realname = book.getName();
            //设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
            //读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(fileStr);
            //创建输出流
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while((len=in.read(buffer))>0){
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            //关闭文件输入流
            in.close();
            //关闭输出流
            out.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
