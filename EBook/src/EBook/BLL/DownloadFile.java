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
		
        //�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
        String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
        //ͨ���ļ����ҳ��ļ�������Ŀ¼
        String fileStr = fileSaveRootPath+"\\"+String.valueOf(book.getCategoryID())+"\\"+book.getName();
        //�õ�Ҫ���ص��ļ�
        File file = new File(fileStr);
        //����ļ�������
        if(!file.exists()){
        	response.setContentType("text/html;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8");
    		PrintWriter out=response.getWriter();
    		out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.print("<HTML>");
            out.print("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.print("  <BODY>");
            out.print("��Ҫ���ص���Դ�����ڻ��ѱ�ɾ��!");
            out.print("<br /><br />");
            out.print("  </BODY>");
            out.print("</HTML>");
            out.flush();
            out.close();
        }
        else     //�ļ����ڣ������ļ�
        {
        	//�����ļ���
            String realname = book.getName();
            //������Ӧͷ��������������ظ��ļ�
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
            //��ȡҪ���ص��ļ������浽�ļ�������
            FileInputStream in = new FileInputStream(fileStr);
            //���������
            OutputStream out = response.getOutputStream();
            //����������
            byte buffer[] = new byte[1024];
            int len = 0;
            //ѭ�����������е����ݶ�ȡ������������
            while((len=in.read(buffer))>0){
                //��������������ݵ��������ʵ���ļ�����
                out.write(buffer, 0, len);
            }
            //�ر��ļ�������
            in.close();
            //�ر������
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
