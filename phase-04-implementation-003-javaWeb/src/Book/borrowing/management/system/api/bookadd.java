package Book.borrowing.management.system.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Book.borrowing.management.system.*;
import Book.borrowing.management.system.model.*;

/**
 * Servlet implementation class bookadd
 */
@WebServlet("/book/api/bookadd")
public class bookadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookadd() {
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
		if (!Util4Frm.judgeusername(request,response)) return;
		request.setCharacterEncoding("UTF-8");
		BookModel bookinfo = new BookModel();
		bookinfo = new BookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"));
		if (bookinfo.getSqlAddResult()) {
			Util4Frm.showMessageDialogAndReturn(response,"添加信息成功","../bookmanager.jsp");
		} else {
			Util4Frm.showMessageDialogAndReturn(response,"添加信息失败","../bookmanager.jsp");
		}
	}

}
