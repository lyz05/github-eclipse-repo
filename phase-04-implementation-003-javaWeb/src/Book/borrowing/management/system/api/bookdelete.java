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
 * Servlet implementation class bookdelete
 */
@WebServlet("/book/api/bookdelete")
public class bookdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String bookNO = request.getParameter("bookno");
		String sql = "select * from View_Book where ͼ����=? and �ڿ�����=�������";
		if (BookDBCon.preparedqueryResult(sql,bookNO) == null)
		{
			response.getWriter().append("<script>alert('���ж���δ�黹�˱�ͼ�飬����޷�ɾ������');window.location.href='../bookmanager.jsp'</script>");
		}
		sql = "delete from Borrow where bookno=? and returnDate is not null";
        BookDBCon.preparedupdateData(sql,bookNO);
        sql = "delete from Book where bookNO=?";
        if (BookDBCon.preparedupdateData(sql,bookNO)) {
        	Util4Frm.showMessageDialogAndReturn(response,"ɾ����Ϣ�ɹ�","../bookmanager.jsp");
		} else {
			Util4Frm.showMessageDialogAndReturn(response,"ɾ����Ϣʧ��","../bookmanager.jsp");
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
