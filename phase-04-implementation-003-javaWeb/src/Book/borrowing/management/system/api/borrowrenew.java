package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.Util4Frm;
import Book.borrowing.management.system.model.BorrowModel;
import Book.borrowing.management.system.model.MessageJSONModel;

/**
 * Servlet implementation class bookrenew
 */
@WebServlet("/book/api/borrowrenew")
public class borrowrenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowrenew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		
		BorrowModel borrowinfo;
		borrowinfo = new BorrowModel(request.getParameter("bookno"),request.getSession().getAttribute("username").toString());
		borrowinfo.setlanguage(Util4Frm.getlanguage(request));
		MessageJSONModel ret = borrowinfo.renew();
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
