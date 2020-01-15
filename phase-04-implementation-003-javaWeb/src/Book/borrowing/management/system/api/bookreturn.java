package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util4Frm;


/**
 * Servlet implementation class bookreturn
 */
@WebServlet("/book/api/bookreturn")
public class bookreturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookreturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String bookNO = request.getParameter("bookno");
		String readerNO = session.getAttribute("username").toString();
		String sql = "update Borrow set returnDate=getdate() from borrow where readerNO=? and bookNO=? and returnDate is null";
		if (bookNO==null || session.getAttribute("username")==null) {
			//请求非法
			response.sendRedirect("../borrowinformation.jsp");
		}
		
		if(BookDBCon.preparedupdateData(sql,readerNO,bookNO)) {
			Util4Frm.showMessageDialogAndReturn(response,"还书成功","../borrowinformation.jsp");
		} else {
			Util4Frm.showMessageDialogAndReturn(response,"还书失败","../borrowinformation.jsp");
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
