package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util4Frm;

/**
 * Servlet implementation class readerdelete
 */
@WebServlet("/book/api/readerdelete")
public class readerdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readerdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String readerNO = request.getParameter("readerno");
		String sql = "select * from View_reader where ���߱��=? and δ�黹����=0";
		if (BookDBCon.preparedqueryResult(sql,readerNO) == null)
		{
			Util4Frm.showMessageDialogAndReturn(response,"�ö��߻���δ�黹��ͼ�飬����޷�ɾ���ö���","../readerinformation.jsp");
		}
		sql = "delete from Borrow where readerNO=? and returnDate is not null";
        BookDBCon.preparedupdateData(sql,readerNO);
        sql = "delete from reader where readerNO=?";
        if (BookDBCon.preparedupdateData(sql,readerNO)) {
        	Util4Frm.showMessageDialogAndReturn(response,"ɾ����Ϣ�ɹ�","../readerinformation.jsp");
		} else {
			Util4Frm.showMessageDialogAndReturn(response,"ɾ����Ϣʧ��","../readerinformation.jsp");
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
