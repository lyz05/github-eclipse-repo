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
 * Servlet implementation class bookedit
 */
@WebServlet("/book/api/bookedit")
public class bookedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookedit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Pages isn't support GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if (BookDBCon.preparedupdateData("update Book set bookName=?,authorName=?,publishingName=?,price=?,publishingDate=?,shopNum=? where bookNO=?",request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"),request.getParameter("bookno"))) {
            Util4Frm.showMessageDialogAndReturn(response,"修改信息成功","../bookmanager.jsp");
        } else {
            Util4Frm.showMessageDialogAndReturn(response,"修改信息失败","../bookmanager.jsp");
        }

	}

}
