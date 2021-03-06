package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.Util;
import Book.borrowing.management.system.model.BorrowModel;
import Book.borrowing.management.system.model.Msg;


/**
 * Servlet implementation class bookreturn
 */
@WebServlet("/book/api/borrowreturn")
public class borrowreturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowreturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Util.setRequestResponseAccess(request, response);
		if (!Util.judgeusername(request,response) || !Util.judgereader(request, response)) return;

		BorrowModel borrowinfo;
		borrowinfo = new BorrowModel(request.getParameter("bookno"),request.getSession().getAttribute("username").toString());
		borrowinfo.setlanguage(Util.getlanguage(request));
		Msg ret = borrowinfo.ret();
		response.getWriter().append(JSON.toJSONString(ret));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Pages isn't support Post");
	}

}
