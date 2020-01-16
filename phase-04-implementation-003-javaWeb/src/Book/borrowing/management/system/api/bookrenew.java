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
 * Servlet implementation class bookrenew
 */
@WebServlet("/book/api/bookrenew")
public class bookrenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookrenew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		HttpSession session = request.getSession(true);
		String bookNO = request.getParameter("bookno");
		String readerNO = session.getAttribute("username").toString();
		String sql = "update Borrow set shouldDate=date_add(NOW(), interval 1 MONTH) where readerNO=? and bookNO=? and returnDate is null";
		if (bookNO==null || session.getAttribute("username")==null) {
			//请求非法
			response.sendRedirect("../borrowinformation.jsp");
		}
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(BookDBCon.preparedupdateData(sql,readerNO,bookNO)) {
			Util4Frm.showMessageDialogAndReturn(response,"续借成功","../borrowinformation.jsp");
		} else {
			Util4Frm.showMessageDialogAndReturn(response,"续借失败","../borrowinformation.jsp");
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
