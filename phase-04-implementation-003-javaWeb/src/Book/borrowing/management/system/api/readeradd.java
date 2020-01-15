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
 * Servlet implementation class readeradd
 */
@WebServlet("/book/api/readeradd")
public class readeradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readeradd() {
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
		ReaderModel readerinfo = new ReaderModel();
		readerinfo = new ReaderModel(request.getParameter("readerno"),request.getParameter("readername"),request.getParameter("sex"),request.getParameter("idnum"),request.getParameter("workunit"));
		if (readerinfo.getSqlAddResult()) {
			Util4Frm.showMessageDialogAndReturn(response,"添加信息成功","../readerinformation.jsp");
		} else {
			Util4Frm.showMessageDialogAndReturn(response,"添加信息失败","../readerinformation.jsp");
		}
	}

}
