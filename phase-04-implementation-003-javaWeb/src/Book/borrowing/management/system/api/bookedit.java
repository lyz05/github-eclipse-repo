package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.Util;
import Book.borrowing.management.system.model.BookModel;
import Book.borrowing.management.system.model.Msg;

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
		Util.setRequestResponseAccess(request, response);
		if (!Util.judgeusername(request,response) || !Util.judgeadmin(request, response)) return;
		
		BookModel bookinfo;
		bookinfo = new BookModel(Util.getlanguage(request),request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"));
		Msg ret = bookinfo.editBook();
		response.getWriter().append(JSON.toJSONString(ret));
	}

}
